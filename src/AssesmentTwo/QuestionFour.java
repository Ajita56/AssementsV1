/*
4. Demonstrate the difference between array and array list with the sample program.*/
package AssesmentTwo;

public class QuestionFour {
	int size;
	int rows,cols;
	int[] intarr;
	int[][] intarr2;
	String[] strarr;
	QuestionFour()
	{
		this.initdata();
		this.initdatastr();
		this.initdatatwo();
	}
	void initdata()
	{
		this.size=5;
		intarr=new int[this.size];
		for(int i=0;i<this.size;i++)
			intarr[i]=i+1;
		
	}
	void initdatastr()
	{
		this.size=5;
		strarr=new String[]{"one","two","three","four","five"};
	}
	void initdatatwo()
	{
		this.rows=3;this.cols=4;
		intarr2=new int[this.rows][this.cols];
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				intarr2[i][j]=i+j;
	}
	void displayList()
	{
		for(int i=0;i<this.size;i++)
			System.out.println(intarr[i]+" is "+strarr[i]);
	}
	void display(int[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	void display(String[] array)
	{
		for(int i=0;i<array.length;i++)
			System.out.print(array[i]+" ");
	}
	void display(int[][] array)
	{
		for(int i=0;i<this.rows;i++)
			display(array[i]);
	}
	void findString(String find)
	{
		boolean exsists=false;
		for (int i = 0; i < this.strarr.length; i++) {
			if(this.strarr[i].contentEquals(find))
				exsists=true;
		}
		if(exsists)
			System.out.println("The string exsists");
		else
			System.out.println("the string does not exsists");
	}

	public static void main(String[] args) {
				
		QuestionFour obj= new QuestionFour();
		
		System.out.println("display list of students");
		obj.displayList();
		System.out.println();
		System.out.println("display the tow dimentional array");
		obj.display(obj.intarr2);
		System.out.println();
		System.out.println("display only the names");
		obj.display(obj.strarr);
		System.out.println();
		System.out.println("find the name two");
		obj.findString("two");
	}

}
