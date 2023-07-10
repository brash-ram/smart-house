import types.CustomBase64;
import types.CustomJson;
import types.Types;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Server {

    private static String SERVER_URL = "http://localhost:8081";


    public static void send(Types.packet packet) throws IOException {
        String json = CustomJson.encodeObjToJson(packet);
        String base64 = CustomBase64.encode(json.getBytes(StandardCharsets.UTF_8));

        URL url = new URL(SERVER_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);

        byte[] out = base64.getBytes(StandardCharsets.UTF_8);
        int length = out.length;

        con.setFixedLengthStreamingMode(length);
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        con.connect();
        try(OutputStream os = con.getOutputStream()) {
            os.write(out);
        }
        con.connect();
        InputStream in = con.getInputStream();
        System.out.println(new String(in.readAllBytes(), StandardCharsets.UTF_8));
    }
}
