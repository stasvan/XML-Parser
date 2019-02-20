import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    private boolean isName = false;
    private String name;
    private boolean isSkill = false;
    private boolean isSkilled = false;
    private boolean isSkilled1 = false;
    private boolean isSkilled2 = false;


    private String [] skills = {"CSS3", "CodeIgniter"};
    private int counter = 0;

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
//            if (isSkilled1 && isSkilled2) {
//                System.out.println(name);
//            }
//            isSkilled1 = false;
//            isSkilled2 = false;
            if (counter == skills.length) {
                System.out.println(name);
            }
            counter = 0;
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

                for (String str: skills) {
                    if (str.equals(skill)) {
                        counter++;
                    }
                }

//                if (skill.equalsIgnoreCase("CSS3")) {
//                    isSkilled1 = true;
//                }
//                if (skill.equalsIgnoreCase("CodeIgniter")) {
//                    isSkilled2 = true;
//                }


                isSkill = false;
            }

    }
}

