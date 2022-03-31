package javapra;

import org.testng.annotations.Test;

public class FirstOneLetter {
/*	@Test
		public void firstletter() {

	String s ="idsfa amsc going tosds village tomorrow";
	String[] s1 = s.split(" ");

	for (int i = 0; i < s1.length; i++) {
	//String s2 = s1[i];
	System.out.print(s1[i].charAt(3));
	}
	}*/	
	@Test
	public void firstletterCaptial() {
		String s = "welcome to india";
		 char ch = (char)(s.charAt(0)-32);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)== ' ') {
				System.out.print(" "+(char)(s.charAt(i+1)-32));
				i=i+1;
			}else {
				System.out.print(s.charAt(i));
			}
			
			
			
		}
		
	}

}
