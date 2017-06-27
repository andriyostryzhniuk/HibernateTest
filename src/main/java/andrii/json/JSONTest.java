package andrii.json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import java.io.File;
import java.io.IOException;

public class JSONTest {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static  <T> void parseToJSON(T object){
        try {

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\user.json"), object);

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T parseToJava(File file, Class<T> tClass) {

        T object = null;

        try {
            object = mapper.readValue(file, tClass);
//            object = mapper.readValue(file, new TypeReference<T>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return object;
    }

    protected static ObjectMapper getMapper() {
        return mapper;
    }
}
