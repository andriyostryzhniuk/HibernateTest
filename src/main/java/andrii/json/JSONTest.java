package andrii.json;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JSONTest<E> {

    private ObjectMapper mapper = new ObjectMapper();

    public void parseToJSON(E object){
        try {

            mapper.writeValue(new File("D:\\user.json"), object);



        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
