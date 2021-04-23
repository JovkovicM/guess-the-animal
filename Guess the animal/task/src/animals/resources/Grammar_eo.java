package animals.resources;

import java.util.ListResourceBundle;
import java.util.function.UnaryOperator;

public class Grammar_eo extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"statement.regEx", "ĝi\\s+.+"},
                {"statement.begin", "Ĝi"},
                {"fact.negate", new String[][]{
                        {"Ĝi",  "Ĝi ne"},
                }},
                {"fact.question", new String[][]{
                        {"Ĝi ",  "Ĉu ĝi "},
                }},
                {"animal.name", (UnaryOperator<String>) name -> name},
                {"article.indefinite", ""},
                {"article.definite", "La "},
                {"question.begin", "Ĉu ĝi estas "},
                {"positiveAnswer.isCorrect", new String[] {
                        "j",
                        "jes",
                        "certe"
                }},
                {"negativeAnswer.isCorrect", new String[] {
                        "n",
                        "ne"
                }}
        };
    }
}
