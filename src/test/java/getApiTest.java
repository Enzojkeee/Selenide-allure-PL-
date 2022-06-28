import API.ClientApi;
import API.ListObjectsFromJson;
import API.getAPI;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.List;


public class getApiTest {
//    @Test
//    void usersGetApi() throws Exception {
//        String responseAPI = getAPI.get("http://77.50.236.203:4880/users");
////        Assertions.assertEquals(200, responseAPI);
//        List<User> a = ListObjectsFromJson.getList(responseAPI);
//        for (User item : a) {
//            System.out.println(item);
//        }
//    }

    @Test
    void getUsersAPI(){
        //Create client
        ClientApi client = new ClientApi();
        //Send GET query to users path
        CloseableHttpResponse response = client.getApiQuery("users");
        //Check status code
        Assertions.assertEquals(200, response.getCode());
        //Получаем body
        String bodyResponse = client.getStringFromResponse(response);
        //Body to Object
        List<User>userList = ListObjectsFromJson.getListOfObjectsFromResponse(bodyResponse, User.class);
        for (User item : userList) {
            System.out.println(item);
        }

    }
    }