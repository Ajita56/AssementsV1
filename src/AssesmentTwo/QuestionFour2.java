/*
4. Demonstrate the difference between array and array list with the sample program.*/
package AssesmentTwo;

import java.util.ArrayList;

public class QuestionFour2 {
	public static void main(String[] args) {
		// integer array list
		System.out.println("opratios on integer array");
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++)
			al.add(i);
		System.out.println(al);
		al.remove(9);
		System.out.println("array after removing the 10th element whose index is 9 \n and add 10 more numbers ");
		for (int i = 11; i <= 20; i++)
			al.add(i);
		System.out.println(al);
		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i) + " ");
		System.out.println();
		System.out.println("add the deleted number in its position");
		al.add(9, 10);
		System.out.println(al);
		for (int i = 0; i < al.size(); i++)
			System.out.print(al.get(i) + " ");
		System.out.println();
		System.out.println("opratios on string array");
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 1; i <= 10; i++)
			str.add(Integer.toString(i));
		System.out.println(al);
		str.remove(9);
		System.out.println("array after removing the 10th element whose index is 9 \n and add 10 more numbers ");
		for (int i = 11; i <= 20; i++)
			str.add(Integer.toString(i));
		System.out.println(str);
		for (int i = 0; i < str.size(); i++)
			System.out.print(str.get(i) + " ");
		System.out.println();
		System.out.println("add the deleted number in its position");
		str.add(9,Integer.toString(10));
		System.out.println(str);
		for (int i = 0; i < str.size(); i++)
			System.out.print(str.get(i) + " ");
		System.out.println();
		
	}

}
