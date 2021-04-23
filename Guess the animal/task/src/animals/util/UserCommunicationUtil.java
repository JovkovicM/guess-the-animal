package animals.util;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

import static animals.knowledge.KnowledgeTreeRepository.appGrammarResource;
import static animals.knowledge.KnowledgeTreeRepository.appMessageResource;

public class UserCommunicationUtil {

    public static void greetUser() {
        LocalTime localTime = LocalTime.now();
        if (localTime.getHour() >= 5 && localTime.getHour() < 12) {
            System.out.println(appMessageResource.getString("greeting.morning") + "\n");
        } else if (localTime.getHour() >= 12 && localTime.getHour() < 18) {
            System.out.println(appMessageResource.getString("greeting.afternoon") + "\n");
        } else {
            System.out.println(appMessageResource.getString("greeting.evening") + "\n");
        }

    }
    public static void farewellUser() {
        List<String> farewellMessages = List.of(appMessageResource.getStringArray("farewell"));

        Random random = new Random();
        System.out.println("\n" + farewellMessages.get(random.nextInt(farewellMessages.size())));
    }
    public static void printMenu() {
        System.out.println(appMessageResource.getString("welcome") + "\n"
                + appMessageResource.getString("menu.property.title") + "\n\n"
                + "1. " + appMessageResource.getString("menu.entry.play") + "\n"
                + "2. " + appMessageResource.getString("menu.entry.list") + "\n"
                + "3. " + appMessageResource.getString("menu.entry.search") + "\n"
                + "4. " + appMessageResource.getString("menu.entry.statistics") + "\n"
                + "5. " + appMessageResource.getString("menu.entry.print") + "\n"
                + "0. " + appMessageResource.getString("menu.property.exit"));
    }
    public static String enterAnimal() {
        String animal = processString(ScannerUtil.getInstance().nextLine());

        if("".equals(animal)) {
            System.out.println(appMessageResource.getString("animal.error"));
            return enterAnimal();
        }

        if (animal.startsWith("a ") || animal.startsWith("an ")) {
            return animal;
        }
        if (animal.startsWith(appGrammarResource.getString("article.definite").toLowerCase())) {
            animal = animal.replace(
                    appGrammarResource.getString("article.definite").toLowerCase() + " ",
                    "");
        }

        var nameRule = (UnaryOperator) appGrammarResource.getObject("animal.name");

        return (String) nameRule.apply(animal);
    }
    public static String askYesOrNo() {
        String answer = ScannerUtil.getInstance().nextLine();

        boolean answerRecognized = false;

        while(!answerRecognized) {
            answer = simplifyAnswer(answer);
            if ("Undefined".equals(answer)) {
                askAgain();
                answer = ScannerUtil.getInstance().nextLine();
            } else {
                answerRecognized = true;
            }
        }
        return answer;
    }

    private static String processString(String answer) {
        return answer.toLowerCase().strip().replaceAll("\\p{Punct}", "")
                .replaceAll("\\d", "");
    }
    private static void askAgain() {
        List<String> clarificationQuestions = List.of(appMessageResource.getStringArray("ask.again"));

        Random random = new Random();
        System.out.println(clarificationQuestions.get(random.nextInt(clarificationQuestions.size())));
    }
    private static String simplifyAnswer(String answer) {
        List<String> positiveAnswers = List.of(appGrammarResource.getStringArray("positiveAnswer.isCorrect"));

        List<String> negativeAnswers = List.of(appGrammarResource.getStringArray("negativeAnswer.isCorrect"));

        answer = processString(answer);
        if (positiveAnswers.contains(answer)) {
            return "Yes";
        }

        if (negativeAnswers.contains(answer)) {
            return "No";
        }

        return "Undefined";
    }

}
