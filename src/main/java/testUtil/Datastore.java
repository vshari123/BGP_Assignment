package testUtil;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

public class Datastore {

    private Map<String, Object> testData;
    public Datastore() {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/testData/TestData.yaml");
            testData = yaml.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getTestData(String key){
        return (String) testData.get(key);
    }
}
