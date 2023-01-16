package AssesmentThree;

public class Base {
	void base1() {
		System.out.println("this is BASE class DEFAULT method");
	}

	private void base2() {
		System.out.println("this is BASE class PRIVATE method");
	}

	protected void base3() {
		System.out.println("this is BASE class PROTECTED method");
	}

	public void base4() {
		System.out.println("this is BASE class PUBLIC method");
	}

	public static void main(String[] args) {
		Base b = new Base();
		b.base1();
		b.base2();
		b.base3();
		b.base4();

	}

}
