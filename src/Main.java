import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxParser = parserFactory.newSAXParser();
            saxParser.parse(new File("feed-test.xml"), handler);   //D:\BSUIR\4\OOP\feed.xml
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}
