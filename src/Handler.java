import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    private boolean isName = false;
    private String name;
    private boolean isSkill = false;
    private boolean isSkilled = false;

    @Override
    public void startDocument() {
        System.out.println("Start parsing...");
        System.out.println("People with CodeIgniter, CSS3 or Sinatra skill:");
    }

    @Override
    public void endDocument() {
        System.out.println("End parsing.");
    }

    @Override
    public void startElement(String url, String localName, String qName, Attributes attr) {
        if (qName.equalsIgnoreCase("user")) {
            name = "";
        }
        if (qName.equalsIgnoreCase("name")) {
            isName = true;
        }
        if (qName.equalsIgnoreCase("skill")) {
            isSkill = true;
        }

    }

    @Override
    public void endElement(String url, String localName, String qName) {
        if (qName.equalsIgnoreCase("user")) {
            if (isSkilled) {
                System.out.println(name);
            }
            isSkilled = false;
        }
    }

    @Override
    public void characters(char []ch, int start, int length) {

            if (isName) {
                name = new String(ch, start, length);
                isName = false;
            }
            if (isSkill) {
                String skill = new String(ch, start, length);
                if (skill.equalsIgnoreCase("CodeIgniter")
                        | skill.equalsIgnoreCase("CSS3")
                        | skill.equalsIgnoreCase("Sinatra")) {
                    isSkilled = true;
                }
                isSkill = false;
            }

    }
}

