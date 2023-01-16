//child class in same package
package AssesmentThree;

public class Child4 {

	
	void base1() {
		System.out.println("this is DEFAULT methoD not a CHILD");
		
	}

	private void base2()
	{
		System.out.println("this is PRIVATE methoD not a CHILD");
	}
	
	protected void base3() {
		System.out.println("this is aPROCTECED methoD not a CHILD");
		
	}
	
	public void base4() {
		System.out.println("this is A  PUBLIC method "
				+ "\n which is used to creat a Base class object"
				+"and call the method");
		Base b=new Base();
		b.base1();
		b.base3();
		b.base4();
		}


	
	

	public static void main(String[] args) {
		Child4 c = new Child4();
		c.base1();
		c.base2();
		c.base3();
		c.base4();

	}

}
