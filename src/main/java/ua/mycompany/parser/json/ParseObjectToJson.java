package ua.mycompany.parser.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.mycompany.parser.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ParseObjectToJson {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User userToParse = new User("NameJson", "Surname", 20, Arrays.asList("My", "Super", "List"));
        try (FileWriter writer = new FileWriter("d:\\user.json")) {
            gson.toJson(userToParse, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
