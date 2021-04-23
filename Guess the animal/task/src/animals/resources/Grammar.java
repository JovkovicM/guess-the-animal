package animals.resources;

import java.util.ListResourceBundle;
import java.util.function.UnaryOperator;

public class Grammar extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"statement.regEx", "It\\s+(can|has|is)\\s+.+"},
                {"statement.begin", "It"},
                {"fact.negate", new String[][]{
                        {" is ", " isn't "},
                        {" can ", " can't "},
                        {" has ", " doesn't have "}
                }},
                {"fact.question", new String[][]{
                        {"It is ", "Is it "},
                        {"It can ", "Can it "},
                        {"It has ", "Does it have "}
                }},
                {"animal.name", (UnaryOperator<String>) name -> {
                    if (name.matches("[aeiou].*")) {
                        return "an " + name;
                    } else {
                        return "a " + name;
                    }
                }},
                {"article.indefinite", "(a|an)"},
                {"article.definite", "The"},
                {"question.begin", "Is it "},
                {"positiveAnswer.isCorrect", new String[] {
                        "y",
                        "yes",
                        "yeah",
                        "yep",
                        "sure",
                        "right",
                        "affirmative",
                        "correct",
                        "indeed",
                        "you bet",
                        "exactly",
                        "you said it"
                }},
                {"negativeAnswer.isCorrect", new String[] {
                        "n",
                        "no",
                        "no way",
                        "nah",
                        "nope",
                        "i don't think so",
                        "yeah no"
                }}
        };
    }
}
