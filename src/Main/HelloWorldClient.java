package Main;

/**
 * Created by HenrikTuyen on 26/10/15.
 */

import Logic.Start;
import SDK.ServerConnection;

public class HelloWorldClient {

  public static void main(String[] argv) {

    Start start = new Start();
    start.run();

    try {

      ServerConnection serverConnection = new ServerConnection();

      serverConnection.get("user");

    } catch (Exception e) {

      e.printStackTrace();

    }
  }

}
