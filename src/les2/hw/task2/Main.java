package les2.hw.task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 06.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        String result = readFromFile("c:/DevKit/json.txt");
        Visitka visitka = (Visitka) gson.fromJson(result, Visitka.class);
        System.out.println(visitka);
    }

    public static String readFromFile(String path){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String text;
            while((text = reader.readLine()) != null  ) {
                sb.append(text);
            }
            System.out.println(sb);
        } catch(IOException e){ e.printStackTrace(); }
        return sb.toString();
    }
}
