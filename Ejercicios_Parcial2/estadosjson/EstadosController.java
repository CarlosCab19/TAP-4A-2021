package estadosjson;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
public class EstadosController {
    URL url;
    String uri = "http://datamx.io/dataset/73b08ca8-e955-4ea5-a206-ee618e26f081/resource/9c5e8302-221c-46f2-b9f7-0a93cbe5365b/download/estados.json";
    List<Estados> estados;
    public EstadosController()throws IOException, ParseException{
        url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36 Edg/89.0.774.68");
        connection.setRequestMethod("GET");
        connection.setReadTimeout(60 * 3000);
        connection.setRequestProperty("content-type", "application/json");

        connection.connect();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));
        String buffer = "";
        String response = "";
        while((buffer = reader.readLine())!=null) {
            response += buffer;
        }

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONObject object = (JSONObject) obj; 
        JSONArray array = (JSONArray) object.get("id");
        ArrayList<Estados> countries = new ArrayList<>();
        for(int i=0;i<array.size();i++) {
            JSONObject country = (JSONObject) array.get(i);
            Estados c = new Estados();
            c.setName((String)country.get("name"));
            c.setId((int)country.get("id"));
            estados.add(c);
        }
        this.estados = countries;
    }
}
