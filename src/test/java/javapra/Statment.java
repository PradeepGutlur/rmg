package javapra;

import java.util.LinkedHashSet;

public class Statment {

	public static void main(String[] args) {

		String s = "i am pradeep";
		String s1 = "i am gv";
		String s2 = s+" "+s1;
		String[] s3 = s2.split(" ");
		//System.out.println(s2);
	LinkedHashSet<String> set = new LinkedHashSet<String>();
		for (int i = 0; i < s3.length; i++) {
			
			 set.add(s3[i]);
		}
		for (String str : set) {
			System.out.print(str+" ");
		}
			for (int i = 0; i < s3.length; i++) {
			
			if (s3[i].equals("i")) {
				System.out.println(s3[5]);
			}	
			}
			
			}
		
		
		
	
	}


