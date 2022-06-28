package API;
import io.qameta.allure.internal.shadowed.jackson.core.JsonProcessingException;
import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import user.User;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

//Обрабатываем Json response from API using Jackson

public class ListObjectsFromJson {

    public static List<User> getList(String jsonResponse) throws IOException {
        String json = jsonResponse;
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = mapper.readValue(json, new TypeReference<List<User>>() {});

        return userList;
    }

    public static <T>List<T> getListOfObjectsFromResponse(String entity, Class<User> tClass){
        ObjectMapper mapper = new ObjectMapper();
        Class<T[]> tArrayClass = (Class<T[]>) Array.newInstance(tClass,0).getClass();
        List<T> result = null;
        try {
            result =  Arrays.stream(mapper.readValue(entity, tArrayClass)).toList();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
