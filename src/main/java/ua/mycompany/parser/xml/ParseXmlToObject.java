package ua.mycompany.parser.xml;

import ua.mycompany.parser.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParseXmlToObject {
    public static void main(String[] args) {
        try {
            File file = new File("d:\\user.xml");
            JAXBContext context = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            User user = (User) unmarshaller.unmarshal(file);
            System.out.println(user);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
