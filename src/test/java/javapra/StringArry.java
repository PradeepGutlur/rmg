package javapra;

public class StringArry {
	public static void main(String[] args) {
		String s[]= {"java","pyton","java","java","payton"};
		
		for (int i = 0; i < s.length; i++) {
			int count = 0;
			for (int j = i; j < s.length; j++) {
				if (s[i].equals(s[j])) {
					count++;	
				}
			}
			if (count>1) {
				System.out.println(s[i]);
			}
			
		}
		
	}

}
