import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class YouAreEll {

    IdController idController;
    MessageController messageController;

    YouAreEll() {
        idController = new IdController();
        messageController = new MessageController();
    }

    public static void main(String[] args) throws IOException {
        YouAreEll urlhandler = new YouAreEll();
//        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
//        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
//        System.out.println(urlhandler.idController.getAllIDs("/ids"));
        System.out.println(urlhandler.messageController.getMyMessages("/ids/The King of Lambdas/messages/"));
//        System.out.println(urlhandler.messageController.postMessageToAll("/messages","The King of Lambdas",
//                "rayskeez21", "The lambdagod strikes again!"));
//        System.out.println(urlhandler.idController.postID("/ids", "Jason", "The King of Lambdas"));

    }

    public String get_ids() throws IOException {
        return MakeURLCall(idController.getAllIDs("/ids"));
    }

    public String post_id(String name, String github) {
        return MakeURLCall(idController.postID("/ids", name, github));
    }

    public String get_messages() throws IOException {
        return MakeURLCall(messageController.getMessages("/messages"));
    }

    public String getMyMessages(String github) throws IOException {
        return MakeURLCall(messageController.getMessages("/ids/" + github + "/messages/"));
    }

    public String getMessagesFromFriend(String github, String friendGithub) throws IOException {
        return MakeURLCall(messageController.getMessages("/ids/" + github + "/from/" + friendGithub));
    }

    public String postMessageToAll(String fromid, String message) {
        return MakeURLCall(messageController.postMessageToAll("/ids/" + fromid + "/messages/", fromid, message));
    }

    public String postMessageToFriend(String fromid, String toid, String message) {
        return MakeURLCall(messageController.postMessageToFriend("/ids/" + toid + "/messages/", fromid, toid, message));
    }

    public String MakeURLCall( String method) { return method; }
}

