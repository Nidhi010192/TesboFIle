
    import org.json.JSONException;
    import org.json.JSONObject;
    import org.json.XML;

    import java.io.File;
    import java.io.FileReader;

    public class records {


        public static int PRETTY_PRINT_INDENT_FACTOR = 4;
        public static String TEST_XML_STRING =
                "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

        public static void main(String[] args) {
            File file = new File("M:\\testing\\test-output\\testng-results.xml");

            try {
                FileReader reader = new FileReader(file);
                StringBuffer buffer = new StringBuffer();

                int i;
                while ((i=reader.read())!= -1) {
                    buffer.append((char)i);
                }

                JSONObject xmlJSONObj = XML.toJSONObject(buffer.toString());
                String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
                System.out.println(jsonPrettyPrintString);
            }

            catch (Exception je) {
                System.out.println(je.toString());
            }
        }
    }

