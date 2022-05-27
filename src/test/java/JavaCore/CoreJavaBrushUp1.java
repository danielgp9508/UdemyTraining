package JavaCore;

import java.util.ArrayList;
import java.util.List;


public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		int[] arr2 = {1, 2, 3, 4, 5 , 6};
		for(int value : arr2) {
			if(value % 2 == 0) {
				System.out.println(value + " is odd");
			}
		}
		
		List ar = new ArrayList();
		ar.add("ob1");
		ar.add(2);
		
		for(Object ob : ar) {
			System.out.println(ob);
		}
		
		//String
		String s1 = "brenda lizeth Mendez";
		String[] StringSplitted = s1.split(" ");
		System.out.println(s1.split(" ").length);
		System.out.println(StringSplitted[1]);
		
		String password = "your new password 'danilson' is temporal";
		System.out.println("***"+ password.split("'")[2]);
		System.out.println(password.substring(password.indexOf(" '") + 2, password.indexOf("' ")));
	}

}
