import API.ClientApi;
import API.ListObjectsFromJson;
import API.getAPI;
import SQL.SQL;
import equalsApiSql.ConvertSexColumn;
import equalsApiSql.UserEquals;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;

import java.sql.ResultSet;
import java.util.List;

public class TestResponseFromApiSameFromSQL {
    @Test
    void compareSqlAndApi() throws Exception {

//         Получаем ответ от API сервера
        ClientApi clientApi = new ClientApi();
        CloseableHttpResponse response = clientApi.getApiQuery("users");
        String bodyResponse = clientApi.getStringFromResponse(response);
//         Создаем список объектов из ответа API
        List<User>userListApi = ListObjectsFromJson.getListOfObjectsFromResponse(bodyResponse, User.class);
//          Получаем ответ от SQL
        SQL clientSQL = new SQL();
        ResultSet result = clientSQL.query("SELECT * FROM person");
        //Создаем лист из пользователей
        List<User>userListSql = clientSQL.getUserListFromResultSet(result);
//        ConvertSexColumn.boolToSex(userListSql);
        //Сравниваем листы
        Assertions.assertEquals(userListSql.size(), userListApi.size());
        Assertions.assertTrue(UserEquals.equalsUsers(userListSql, userListApi));


    }
}
