package SDK;

/**
 * Created by HenrikTuyen on 28/10/15.
 */

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ServerConnection {

    public ServerConnection(){
        this.hostAddress = "http://localhost";
        this.port = 8888;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }

    public void get(String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);


        String output = response.getEntity(String.class);
        System.out.println(output);


    }

    public boolean post(String json, String path){

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

       /* if (response.getStatus() != 200 && response.getStatus() != 201) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }*/

        if(response.getStatus() == 200)
        {
            String output = response.getEntity(String.class);
            System.out.println(output);
            return true;
        }
        else
            return false;

    }


    /*public boolean auth()
    {
        boolean isUserAuth = false;

        String name = screen.getWelcome().getUserName();
        String password = screen.getWelcome().getPassword();
        for (BCBSDto user : bcbsDao.getUsers())
        {
            if (user.getUserName().equals(name) && user.getPassword().equals(password))
            {
                System.out.println("Welcome " + user.getUserName());
                currentUser = user;
                isUserAuth = true;
                screen.getWelcome().getWrongUser().setVisible(false);
            }
        }
        screen.getWelcome().getWrongUser().setVisible(true);
        return isUserAuth;
    }*/
}
