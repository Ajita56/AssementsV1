//child class in same package
package AssesmentThree;

public class Child1 extends Base{
	
	
	@Override
	void base1() {
		System.out.println("this is A CHILD DEFAULT methoD which calls on BASE DEFAULT mathod");
		super.base1();
	}


	@Override
	protected void base3() {
		System.out.println("this is A CHILD PROCTECED methoD which calls on BASE PROCTECED mathod");
		super.base3();
	}


	@Override
	public void base4() {
		System.out.println("this is A CHILD PUBLIC methoD which calls on BASE PUBLIC mathod");
		super.base4();
	}


	private void base2()
	{
		System.out.println("this is A CHILD PRIVATE methoD as the BASE PRIVATE one cannot be accessed ");
	}
	

	public static void main(String[] args) {
		Child1 c = new Child1();
		c.base1();
		c.base2();
		c.base3();
		c.base4();

	}

}
