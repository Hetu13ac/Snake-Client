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

    public ArrayList<User> getUsers()
    {
        String jsonData = sc.get("users/");

        ArrayList<User> users = new Gson().fromJson(jsonData, new TypeToken<ArrayList<User>>()
        {

        }.getType());

        return users;

    }

    public String createGame(Game game)
    {
        String jsonData = sc.post(new Gson().toJson(game), "games/");

        return sc.stringMessageParser(jsonData);
    }
}
