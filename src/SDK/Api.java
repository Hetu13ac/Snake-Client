package SDK;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Created by HenrikTuyen on 19/11/15.
 */
public class Api {

    private ServerConnection sc;

    public Api()
    {
        sc = new ServerConnection();
    }

    public ArrayList<Score> getHighscores()
    {
        String jsonData = sc.get("scores/");

        ArrayList<Score> scores = new Gson().fromJson(jsonData, new TypeToken<ArrayList<Score>>(){}.getType());

        return scores;
    }

}
