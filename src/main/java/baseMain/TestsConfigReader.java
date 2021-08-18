package baseMain;

import java.io.*;
import java.util.Properties;

public class TestsConfigReader {

    private Properties properties;

    public TestsConfigReader(){
        String propertyFilePath= "src/test/resources/tests.config";

        try {
            File fileDir = new File(propertyFilePath);

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        catch (UnsupportedEncodingException e)
        {
            System.out.println(e.getMessage());
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("tests.config not found at " + propertyFilePath);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String getBrowsers() {
        return properties.getProperty("browsers");
    }

    public String getARC_Supplier_url(String domain) {
        switch (domain){
            case "dev9": return properties.getProperty("dev9_supplier");
            default: return properties.getProperty("qa11_supplier");
        }
    }

    public String getARC_Admin_url(String domain) {
        switch (domain){
            case "dev9": return properties.getProperty("dev9_admin");
            default: return properties.getProperty("qa11_admin");
        }
    }

    public String getCommerceUrl() {
        return properties.getProperty("ecommerce_url");
    }

    public String getDBKapsch_url() {return properties.getProperty("DB_url"); }
    public String getDBKapsch_user() {
        return properties.getProperty("DB_user");
    }
    public String getDBKapsch_pass() {
        return properties.getProperty("DB_pass");
    }

    public String getDBFree_url() {return properties.getProperty("DBfree_url"); }
    public String getDBFree_user() {
        return properties.getProperty("DBfree_user");
    }
    public String getDBFree_pass() {
        return properties.getProperty("DBfree_pass");
    }
}
