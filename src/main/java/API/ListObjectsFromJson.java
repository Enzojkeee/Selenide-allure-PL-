package API;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import user.User;

import java.io.IOException;
import java.util.List;

//Обрабатываем Json response from API using Jackson

public class ListObjectsFromJson {

    public static List<User> getList(String jsonResponse) throws IOException {
        String json = jsonResponse;
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = mapper.readValue(json, new TypeReference<List<User>>() {});

        return userList;
    }
}
