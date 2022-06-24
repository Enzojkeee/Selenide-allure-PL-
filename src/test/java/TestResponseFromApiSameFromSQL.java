import API.ListObjectsFromJson;
import API.getAPI;
import SQL.sqlQuery;
import equalsApiSql.ConvertSexColumn;
import equalsApiSql.UserEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;

import java.util.List;

public class TestResponseFromApiSameFromSQL {
    @Test
    void test() throws Exception {

//         Получаем ответ от API сервера
        String responseApiString = getAPI.get("http://77.50.236.203:4880/users");
//         Создаем список объектов из ответа API
        List<User> responseApi = ListObjectsFromJson.getList(responseApiString);
//         Создаем список обьектов из ответа SQL
        List<User> responseSql = sqlQuery.sqlQuery("SELECT * FROM person");
//          Заменяем true/false из sex column на male/female
        ConvertSexColumn.boolToSex(responseSql);
        System.out.println(responseSql);
        System.out.println(responseApi);

    //        Сравниваем 2 списка
        Assertions.assertEquals(responseSql.size(), responseApi.size());
        Assertions.assertTrue(UserEquals.equalsUsers(responseSql, responseApi));

    }
}
