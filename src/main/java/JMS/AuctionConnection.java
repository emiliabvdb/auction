package JMS;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.logging.Logger;

public class AuctionConnection {

    private String API_DWEET_END_POINT = "dweet.io";

    private JsonParser jsonParser = new JsonParser();

    private String thingName = "AuctionGroup13";

    public boolean publish(JsonElement content) throws IOException {
        if (thingName == null || content == null)
            throw new NullPointerException();

        thingName = URLEncoder.encode(thingName, "UTF-8");

        URL url = new URL("http" + "://" + API_DWEET_END_POINT + "/dweet/for/" + thingName);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        connection.setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);

        PrintWriter out = new PrintWriter(connection.getOutputStream());
        out.println(content.toString());
        out.flush();
        out.close();

        JsonObject response = readResponse(connection.getInputStream());
        connection.disconnect();

        return (response.has("this") && response.get("this").getAsString().equals("succeeded"));
    }


    private JsonObject readResponse(InputStream in) {
        Scanner scan = new Scanner(in);
        StringBuilder sn = new StringBuilder();
        while (scan.hasNext())
            sn.append(scan.nextLine()).append('\n');
        scan.close();
        return jsonParser.parse(sn.toString()).getAsJsonObject();
    }
}
