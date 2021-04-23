package animals.knowledge;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import javax.security.auth.callback.LanguageCallback;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class KnowledgeTreeRepository {
    //TODO switch back to default locale
    public static ResourceBundle appMessageResource
            = ResourceBundle.getBundle("animals.resources.Messages", Locale.getDefault());
    public static ResourceBundle appGrammarResource
            = ResourceBundle.getBundle("animals.resources.Grammar", Locale.getDefault());

    private static ObjectMapper objectMapper;
    private static String fileType = "json";

    protected static Question loadRootQuestion(String[] args) {
        setObjectMapper(args);
        return loadRootQuestion();
    }
    protected static void saveRootQuestion(Question question) {
        try {
            File file = new File("animals_"
                    + Locale.getDefault().getLanguage() + "." + fileType);
            objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValue(file, question);
        } catch (Exception e) {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    private static Question loadRootQuestion() {
        try {
            return objectMapper.readValue(new File("animals_"
                    + Locale.getDefault().getLanguage() + "." + fileType),
                    Question.class);
        } catch (IOException e) {
            return null;
        }
    }
    private static void setObjectMapper(String[] args) throws IllegalArgumentException {
        if (args.length == 0) {
            objectMapper = new JsonMapper();
            return;
        }
        try {
            switch (args[0] + " " + args[1]) {
                case "-type json" : {
                    objectMapper = new JsonMapper();
                    fileType = "json";
                    break;
                }
                case "-type xml" : {
                    objectMapper = new XmlMapper();
                    fileType = "xml";
                    break;
                }
                case "-type yaml" : {
                    objectMapper = new YAMLMapper();
                    fileType = "yaml";
                    break;
                }
                default: {
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid argument. Valid arguments:\n" +
                    "-type [(json)|(xml)|(yaml)]");
        }
    }

}
