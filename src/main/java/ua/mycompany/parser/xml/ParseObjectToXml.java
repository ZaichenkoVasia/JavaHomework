package ua.mycompany.parser.xml;

import ua.mycompany.parser.User;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;

public class ParseObjectToXml {
    public static void main(String[] args) {
        User user = new User("NameXML", "Surname", 20, Arrays.asList("My", "Super", "List"));
        jaxbObjectToXML(user);
    }

    private static void jaxbObjectToXML(User user) {
        try {
            File file = new File("d:\\user.xml");
            JAXBContext context = JAXBContext.newInstance(User.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(user, file);
            marshaller.marshal(user, System.out);
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
    }
}
