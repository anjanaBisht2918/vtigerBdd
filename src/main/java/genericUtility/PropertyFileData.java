package genericUtility;

 
import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileData {
 
		   public  static String fetchDataFromPropertyFile(String key) throws Exception   {
		    //  FileInputStream fis = new FileInputStream("./src/test/resources/testData/vtigerPropertyData.properties");
			      FileInputStream fis = new FileInputStream("./src/test/resources/testData/vtigercommonData.properties");

		      Properties prop = new Properties();
		      prop.load(fis);
		      return prop.getProperty(key);
		   }

}
