package javapra;

public class Primid {
	public static void main(String[] args) {
		int row =6;
		
		  for (int i = 0; i <row; i++) { 
		 for (int j =row-i; j >1; j--) {
		  System.out.print(" ");
		  
		  } for (int j = 0; j <=i; j++) { System.out.print("*");
		  
		  } System.out.println();
		  
		  }
		 
		for (int i = row-1; i >=1; i--) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
				
			}for (int j = i; j <=row; j++) {
				System.out.print("*");
				
			}
			System.out.println();
			
		}
	}

}
