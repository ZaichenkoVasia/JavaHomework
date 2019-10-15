package ua.mycompany.parser.json;

import com.google.gson.Gson;
import ua.mycompany.parser.User;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ParseJsonToObject {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("d:\\user.json")) {
            User user = gson.fromJson(reader, User.class);
            System.out.println(user);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
