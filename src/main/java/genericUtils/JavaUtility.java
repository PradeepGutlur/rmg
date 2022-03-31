package genericUtils;

import java.util.Random;

public class JavaUtility {
	public int getrandom() {
		Random ran = new Random();
		 int randomNo = ran.nextInt(5000);
		return randomNo;
	}

}
