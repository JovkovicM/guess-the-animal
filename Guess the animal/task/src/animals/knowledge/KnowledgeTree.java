package animals.knowledge;

import animals.util.ScannerUtil;

import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import static animals.knowledge.KnowledgeTreeRepository.*;
import static animals.util.QuestionFactManipulationUtil.*;
import static animals.util.UserCommunicationUtil.*;

public class KnowledgeTree implements KnowledgeTreeService {

    public Question root;
    private final Set<String> knownAnimals;
    private final Map<String, String> stats;
    private int minDepth;
    private int sumDepth;

    public KnowledgeTree() {
        this.root = null;
        this.knownAnimals = new TreeSet<>();
        this.stats = new LinkedHashMap<>();
        this.minDepth = Integer.MAX_VALUE;
        this.sumDepth = 0;
    }


    @Override
    public void startGuessing() {

        boolean playAgain = true;
        while (playAgain) {
            System.out.println(appMessageResource.getString("game.think") + "\n"
                    + appMessageResource.getString("game.enter"));

            ScannerUtil.getInstance().nextLine();

            this.guessAnimal(this.root);

            System.out.println(appMessageResource.getStringArray("game.again")[0]);
            String answer = askYesOrNo();
            if ("No".equals(answer)) {
                playAgain = false;
            }
        }
        this.save();
    }

    @Override
    public void printAllKnownAnimals() {
        loadAllKnownAnimals(this.root);
        System.out.println(appMessageResource.getString("tree.list.animals"));
        for (String s : this.knownAnimals) {
            System.out.printf("- %10s%n", s);
        }
    }

    @Override
    public void printStats() {
        loadStats();
        System.out.println(appMessageResource.getString("tree.stats.title") + "\n");
        for (String s : stats.keySet()) {
            System.out.printf("%-30s%10s%n", s, stats.get(s));
        }
    }

    @Override
    public void searchForAnimal() {
        System.out.println(appMessageResource.getString("animal.prompt"));
        String searchAnimal = enterAnimal().replaceFirst(appGrammarResource.getString("article.indefinite"),
                "");

        List<String> statements = new LinkedList<>();
        if (!searchForAnimal(searchAnimal, this.root, statements)) {
            System.out.println(MessageFormat.format(
                    appMessageResource.getString("tree.search.noFacts"), searchAnimal));
        } else {
            Collections.reverse(statements);
            System.out.println(MessageFormat.format(
                    appMessageResource.getString("tree.search.facts"), searchAnimal));
            for (String s : statements) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void printKnowledgeTree() {
        printKnowledgeTree(this.root, "└");
    }

    @Override
    public void load(String[] args) {
        Question rootQuestion = loadRootQuestion(args);

        if (rootQuestion == null) {
            enterFavoriteAnimal();
        } else {
            System.out.println(appMessageResource.getString("animal.learnedMuch"));
            this.root = rootQuestion;
        }
    }

    @Override
    public void save() {
        saveRootQuestion(this.root);
    }

    private void guessAnimal(Question question) {
        System.out.println(question.text);
        String answer = askYesOrNo();

        if ("Yes".equals(answer)) {
            if (question.positive == null) {
                System.out.println(appMessageResource.getString("game.win"));
            } else {
                guessAnimal(question.positive);
            }
        } else if ("No".equals(answer)) {
            if (question.negative == null) {
                System.out.println(appMessageResource.getString("game.giveUp"));
                String thoughtAnimal = enterAnimal();
                String guessedAnimal = question.text.replaceAll(
                        appGrammarResource.getString("question.begin"), "")
                        .replaceAll("\\?", "");
                learnFact(guessedAnimal, thoughtAnimal, question);
            } else {
                guessAnimal(question.negative);
            }
        }
    }
    private static void learnFact(String animal1, String animal2, Question question) {
        String fact = enterFact(animal1, animal2);

        System.out.println(MessageFormat.format(appMessageResource.getString("game.isCorrect"),
                animal2));
        String answer = askYesOrNo();

        String negativeAnimal;
        String positiveAnimal;

        String fact1 = fact;
        String fact2 = fact;

        if ("Yes".equals(answer)) {
            positiveAnimal = animal2;
            negativeAnimal = animal1;
            fact1 = negateFact(fact1);
        } else {
            positiveAnimal = animal1;
            negativeAnimal = animal2;
            fact2 = negateFact(fact2);
        }

        fact1 = fact1.replaceFirst(appGrammarResource.getString("statement.begin"),
                animal1).replaceFirst(appGrammarResource.getString("article.indefinite"),
                appGrammarResource.getString("article.definite"));
        fact2 = fact2.replaceFirst(appGrammarResource.getString("statement.begin"),
                animal2).replaceFirst(appGrammarResource.getString("article.indefinite"),
                appGrammarResource.getString("article.definite"));

        System.out.println(appMessageResource.getString("game.learned") + "\n"
                + "- " + fact1 + "\n"
                + "- " + fact2 + "\n");

        System.out.println(appMessageResource.getString("game.distinguish"));
        String distinguishQuestion = "- " + getQuestionFromFact(fact);
        System.out.println(distinguishQuestion + "\n"
                + appMessageResource.getStringArray("animal.nice")[0] + " "
                + appMessageResource.getString("animal.learnedMuch"));

        question.text = distinguishQuestion;
        question.negative = new Question(getQuestionFromAnimal(negativeAnimal));
        question.positive = new Question(getQuestionFromAnimal(positiveAnimal));
    }
    private static String enterFact(String animal1, String animal2) {
        System.out.println(MessageFormat.format(appMessageResource.getString("statement.prompt"),
                animal1, animal2));

        String factRegEx = appGrammarResource.getString("statement.regEx");
        String fact = ScannerUtil.getInstance().nextLine();
        Pattern pattern = Pattern.compile(factRegEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(fact);
        if (matcher.matches()) {
            fact = fact.replaceAll("\\p{Punct}", "")
                    .replaceAll("\\s+", " ")
                    .toLowerCase();
            return fact.substring(0, 1).toUpperCase() + fact.substring(1);
        }
        System.out.println(appMessageResource.getString("statement.error"));
        return enterFact(animal1, animal2);
    }
    private void loadAllKnownAnimals(Question question) {
        if (isAnimal(question)) {
            this.knownAnimals.add(getAnimalFromQuestion(question.text));
            return;
        }
        loadAllKnownAnimals(question.negative);
        loadAllKnownAnimals(question.positive);
    }
    private boolean searchForAnimal(String animal, Question question, List<String> statements) {
        if (isAnimal(question)) {
            return question.text.contains(animal);
        } else {
            boolean positive;
            if (searchForAnimal(animal, question.positive, statements)) {
                positive = true;
            } else if (searchForAnimal(animal, question.negative, statements)) {
                positive = false;
            } else {
                return false;
            }

            String fact = getFactFromQuestion(question.text);
            if (!positive) {
                fact = negateFact(fact);
            }
            statements.add(fact);
            return true;
        }
    }
    private void loadStats() {
        loadAllKnownAnimals(this.root);
        loadMinDepthAndSumDepth();
        int numberOfNodes = getNumberOfNodes(this.root);
        this.stats.put(appMessageResource.getString("tree.stats.root"),
                getFactFromQuestion(this.root.text));
        this.stats.put(appMessageResource.getString("tree.stats.nodes"),
                String.valueOf(numberOfNodes));
        this.stats.put(appMessageResource.getString("tree.stats.animals"),
                String.valueOf(this.knownAnimals.size()));
        this.stats.put(appMessageResource.getString("tree.stats.statements"),
                String.valueOf(numberOfNodes - this.knownAnimals.size()));
        this.stats.put(appMessageResource.getString("tree.stats.height"),
                String.valueOf(this.getHeight(this.root)));
        this.stats.put(appMessageResource.getString("tree.stats.minimum"),
                String.valueOf(this.minDepth));
        this.stats.put(appMessageResource.getString("tree.stats.average"),
                String.format("%.1f" ,
                        (double) this.sumDepth / this.knownAnimals.size()));

    }
    private void loadMinDepthAndSumDepth() {
        this.sumDepth = 0;
        this.minDepth = Integer.MAX_VALUE;
        loadMinDepthAndSumDepth(this.root, 0);
    }
    private void loadMinDepthAndSumDepth(Question question, int currDepth) {
        if (isAnimal(question)) {
            if (currDepth < minDepth) {
                minDepth = currDepth;
            }
            this.sumDepth += currDepth;
            return;
        }
        loadMinDepthAndSumDepth(question.negative, currDepth + 1);
        loadMinDepthAndSumDepth(question.positive, currDepth + 1);
    }
    private int getNumberOfNodes(Question question) {
        if (question == null) {
            return 0;
        }
        return 1 + getNumberOfNodes(question.negative) + getNumberOfNodes(question.positive);
    }
    private int getHeight(Question question) {
        if (question == null) {
            return -1;
        }
        int left = 1 + getHeight(question.negative);
        int right = 1 + getHeight(question.positive);
        return Math.max(left, right);
    }
    private void printKnowledgeTree(Question question, String offset) {
        if (question == null) {
            return;
        }
        if (isAnimal(question)) {
            System.out.println(offset + "- " + getAnimalFromQuestion(question.text));
        } else {
            System.out.println(offset + question.text);
        }
        printKnowledgeTree(question.positive, " " + offset);
        printKnowledgeTree(question.negative, " " + offset);
    }
    private static boolean isAnimal(Question question) {
        return question.positive == null && question.negative == null;
    }
    private void enterFavoriteAnimal() {
        System.out.println(appMessageResource.getString("animal.wantLearn") + "\n"
                + appMessageResource.getString("animal.askFavorite"));
        String favAnimal = enterAnimal();
        this.root = new Question(getQuestionFromAnimal(favAnimal));
        save();
    }

}
