import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Controller<T extends Model> {

    protected OkHttpClient client = null;

    protected ObjectMapper objectMapper = new ObjectMapper();

    protected final String uRL = "http://zipcode.rocks:8085";

    protected String responseBody;

    protected static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    protected List<T> list = new ArrayList<>();

    protected StringBuilder builder = new StringBuilder();

    protected String jsonObject;

    public String doPostRequest(String url, String json) {
        client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder().url(uRL).post(body).build();

        try {
            Response response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;

    }

    public String get(String resource) throws IOException{
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



    public OkHttpClient getClient() { return client; }

    public String getuRL() { return uRL; }

}
