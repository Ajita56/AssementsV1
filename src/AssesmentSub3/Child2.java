//child class in same package
package AssesmentSub3;

import AssesmentThree.Base;

public class Child2 extends Base{
	
	
void base1() {
		System.out.println("this is A CHILD DEFAULT methoD as the BASE DEFAULT one cannot be accessed");
		
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
		Child2 c = new Child2();
		c.base1();
		c.base2();
		c.base3();
		c.base4();

	}

}
