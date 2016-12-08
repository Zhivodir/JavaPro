package les2.hw.task3;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by User on 08.12.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String request = "http://query.yahooapis.com/v1/public/yql?format=json&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

            String result = performRequest(request);
            File file = new File("c:/DevKit/yahoo.xml");
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(result);
        }catch(IOException e){e.printStackTrace();}
    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }
}
