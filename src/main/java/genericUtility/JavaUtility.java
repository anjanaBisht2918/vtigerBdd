package genericUtility;

import java.util.Date;
import java.util.Random;
//22/47
public class JavaUtility {
	public int generateRandomNo(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);
	}

	public String generateSystemDateTime() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
}
