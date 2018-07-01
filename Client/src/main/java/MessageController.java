
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.List;

public class MessageController extends Controller<Messages> {

    private Messages messages;

    public String getAllMessages(String resource) throws IOException{
        responseBody = get(resource);
        return unpackMessages(responseBody);
    }

    public String getMyMessages(String resource) throws IOException{
        responseBody = get(resource);
        return unpackMessages(responseBody);
    }

    public String postMessageToAll(String url, String fromid, String message) {
        return doPostRequest(url, packMessagesToAll(fromid, message));
    }

    public String postMessageToFriend(String url, String fromid,String toid, String message) {
        return doPostRequest(url, packMessagesToFriend(fromid, toid, message));
    }

    public String getMessages(String resource) throws IOException{
        client = new OkHttpClient();
        Request request = new Request.Builder().url(uRL + resource).get().build();

        Response response = null;

        try {
            response = client.newCall(request).execute();
            responseBody = response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    public String unpackMessages(String responseBody) throws IOException {
        list = objectMapper.readValue(responseBody, new TypeReference<List<Messages>>() {});

        list.forEach(messages1 -> System.out.println(builder.append(messages1.toString() + "\n")));

        return builder.toString();
    }


    public String packMessagesToAll(String fromid, String message) {
        messages = new Messages(fromid, message);
        try {
            jsonObject = objectMapper.writeValueAsString(messages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public String packMessagesToFriend(String fromid, String toid, String message) {
        messages = new Messages(fromid, toid, message);
        try {
            jsonObject = objectMapper.writeValueAsString(messages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }






}
