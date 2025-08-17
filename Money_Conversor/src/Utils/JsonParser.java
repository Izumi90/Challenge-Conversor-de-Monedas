package Utils;

import Model.ExhangeRate;
import com.google.gson.Gson;

public class JsonParser {

    public static ExhangeRate parseRate (String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, ExhangeRate.class);
    }

}
