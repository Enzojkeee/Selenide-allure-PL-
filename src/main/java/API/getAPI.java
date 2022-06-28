package API;

import io.qameta.allure.Step;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

public class getAPI {
@Step("API - GET")
    public static String get(String uri) throws Exception {
        // Создаем http клиент !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! отдельная сущность
        try (final CloseableHttpClient httpclient = HttpClients.createDefault()) {
            //Инициализируем метод get
            final HttpGet httpGet = new HttpGet(uri);
            //Добавляем Хэдеры
            httpGet.addHeader("Content-Type", "application/json");
            try (final CloseableHttpResponse response = httpclient.execute(httpGet)) {
                System.out.print(httpGet.getMethod() + " ");
                System.out.println(response.getVersion() + response.getReasonPhrase());
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                //Возврат не entity
                final HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
        }
    }
}

