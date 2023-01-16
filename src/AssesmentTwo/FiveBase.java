//5. Demonstrate method overloading and Method overriding with the sample program.
//this is parent class
package AssesmentTwo;

public class FiveBase {
	public int add(int a, int b) {
		System.out.println("this is a parent method int add");
		return a + b;
	}

	public double add(double a, double b) {
		System.out.println("this is a parent method double add");
		return a + b;
	}

	public double add(double a, int b) {
		System.out.println("this is a parent method mixed add");
		return a + b;
	}

	public String add(String str1, String str2) {
		System.out.println("this is a parent method string concat");
		return str1.concat(str2);
	}
}
