package andrii.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        JsonNode jsonNode = jsonParser.readValueAsTree();

        String year = jsonNode.path("year").asText();
        String month = jsonNode.path("monthValue").asText();
        String dayOfMonth = jsonNode.path("dayOfMonth").asText();

        return LocalDate.parse(year + "-" + month + "-" + dayOfMonth, formatter);
    }


}
