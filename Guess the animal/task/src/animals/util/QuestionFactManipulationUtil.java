package animals.util;

import static animals.knowledge.KnowledgeTreeRepository.appGrammarResource;

public class QuestionFactManipulationUtil {
    public static String negateFact(String fact) {
        for (String[] rule : (String[][]) appGrammarResource.getObject("fact.negate")) {
            if (fact.contains(rule[0])) {
                fact = fact.replaceFirst(rule[0], rule[1]);
            }
        }

        return fact;
    }
    public static String getQuestionFromFact(String fact) {
        for (String[] rule : (String[][]) appGrammarResource.getObject("fact.question")) {
            if (fact.contains(rule[0])) {
                fact = fact.replaceFirst(rule[0], rule[1]);
            }
        }
        return fact + "?";
    }
    public static String getQuestionFromAnimal(String animal) {
        return appGrammarResource.getString("question.begin") + animal + "?";
    }
    public static String getAnimalFromQuestion(String question) {
        return question.replaceFirst(appGrammarResource.getString("question.begin")
                + "(a|an)?", "").
                replaceFirst("\\?", "");
    }
    public static String getFactFromQuestion(String question) {
        for (String[] rule : (String[][]) appGrammarResource.getObject("fact.question")) {
            if (question.contains(rule[1])) {
                question = question.replaceFirst(rule[1], rule[0]);
            }
        }
        return question.replaceAll("\\?", "");
    }
}
