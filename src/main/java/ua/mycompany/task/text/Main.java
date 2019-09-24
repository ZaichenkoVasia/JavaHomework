package ua.mycompany.task.text;

public class Main {

    public static void main(String[] args) {
        String inputText = "First sentence. Second sentence with symbols? Last, third sentence!";
        Text text = new Text(inputText);
        System.out.println(text.toString());
        System.out.println(text.getTitle());
        text.suppText("Some text!");
        System.out.println(text.toString());

    }
}
