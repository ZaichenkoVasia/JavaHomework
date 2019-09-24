package ua.mycompany.task5.service;

import ua.mycompany.task5.domain.Text;

public interface TextService {
    Text convertStringToText(String text);

    String convertTextToString(Text text);
}
