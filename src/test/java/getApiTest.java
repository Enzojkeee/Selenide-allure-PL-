import API.ListObjectsFromJson;
import API.getAPI;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.List;


public class getApiTest {
    @Test
    void usersGetApi() throws Exception {
        String responseAPI = getAPI.get("http://77.50.236.203:4880/users");
//        Assertions.assertEquals(200, responseAPI);
        List<User> a = ListObjectsFromJson.getList(responseAPI);
        for (User item : a) {
            System.out.println(item);
        }
    }
    }