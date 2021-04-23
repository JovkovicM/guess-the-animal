package animals.knowledge;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
    public String text;
    public Question negative;
    public Question positive;

    @JsonCreator
    public Question(@JsonProperty("text") String text,
                    @JsonProperty("negative") Question negative,
                    @JsonProperty("positive") Question positive) {
        this.text = text;
        this.negative = negative;
        this.positive = positive;
    }

    public Question(String text) {
        this.text = text;
        this.negative = null;
        this.positive = null;
    }
}
