package util;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;

import java.io.StringReader;

public class JsonDataProcessor {

    public static String getJsonValue(String path, String... keys) {
        String json = "";
        try {
            json = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
        JsonElement element = jsonObject;
        for (String key : keys) {
            if (element instanceof JsonObject) {
                element = ((JsonObject) element).get(key);
            } else {
                break;
            }
        }
        return element != null ? element.getAsString() : null;
    }

    private static Gson gson = new Gson();

    public static JsonObject getObjectFromJson(String pathToJson, String key1, String key2) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(pathToJson)));
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
        JsonObject key1Object = jsonObject.getAsJsonObject(key1);
        return key1Object.getAsJsonObject(key2);
    }



    public static void main(String[] args) throws IOException {
        String json = "src/test/data/SCM/loginUser_Data.json"; // Tu JSON va aquí
        System.out.println(JsonDataProcessor.getJsonValue(json, "prod", "comprador","usuario"));
        String json3 = "src/test/data/SCM/notaCorreccion_Data.json"; // Tu JSON va aquí
        System.out.println(JsonDataProcessor.getJsonValue(json3, "iva"));
        String json1 = "src/test/data/SCM/pedidoMateriales_Data.json"; // Tu JSON va aquí
        System.out.println(JsonDataProcessor.getJsonValue(json1, "agregar", "nombrePedido"));
        JsonObject user = JsonDataProcessor.getObjectFromJson("src/test/data/SCM/loginUser_Data.json", "prod", "implantaciones");
        String usuario = user.get("usuario").getAsString();
        System.out.println(usuario);
    }
}