package API;
import Prop.PropertiesConf;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicHeader;

import java.io.IOException;
import java.util.stream.Stream;

public class ClientApi {
    //
    //
        public CloseableHttpResponse getApiQuery(String uriPath) {

            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(PropertiesConf.getValue("apiURI") + uriPath);
            httpGet.setHeaders(headers());
            CloseableHttpResponse response = null;
            try {
                response = httpClient.execute(httpGet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return response;
        }


        //Headers for request
        protected Header[] headers(){
            Stream<Header> headerStream = Stream.of(
                    new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            );
            return headerStream.toArray(Header[]::new);
        }

        public String getStringFromResponse(CloseableHttpResponse response){
            HttpEntity entity = response.getEntity();
            String result = null;
            try {
                result = EntityUtils.toString(entity);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return result;
        }



}
