
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

public class IdController extends Controller<IDs>{

     IDs iDs;


    public String getAllIDs(String resource) throws IOException{
        responseBody = get(resource);
        return unpackIDs(responseBody);
    }

    public String postID(String mainrl, String name, String github) {
        return doPostRequest(mainrl, packID(name, github));
    }



    public String unpackIDs(String responseBody) throws IOException {
            list = objectMapper.readValue(responseBody, new TypeReference<List<IDs>>() {});

            list.forEach(iDs1 -> System.out.println(builder.append(iDs1 + "\n").toString()));

            return builder.toString();
    }

    public String packID(String name, String github) {
        iDs = new IDs(name, github);
        try {
            jsonObject = objectMapper.writeValueAsString(iDs);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

}
