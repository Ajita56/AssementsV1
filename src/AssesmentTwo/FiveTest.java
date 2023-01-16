//5. Demonstrate method overloading and Method overriding with the sample program.
package AssesmentTwo;

public class FiveTest extends FiveBase {
	public double a, b;
	public String stra, strb;

	public FiveTest(double d, double e, String str1, String str2) {
		a = d;
		b = e;
		stra = str1;
		strb = str2;
	}

	public FiveTest() {
		a=b=2;
		stra="globe";
		strb="market";
	}

	@Override
	public double add(double a, double b) {
		double result = 10.25;
		result = result + a + b;
		System.out.println("this is a child method add which adds extra"+result+" to the passed numbers");
		return result;
	}

	@Override
	public String add(String str1, String str2) {
		String strReturn = (str1.concat(" added to ")).concat(str2);
		System.out.println("this is a child method string concat which adds extra words in between");
		return strReturn;
	}

	public static void main(String[] args) {

		FiveTest child = new FiveTest(5.6, 4.3, "object", "Basket");
		System.out.println("first add: "+ child.add(7, 8));//parent method
		System.out.println("first add: "+child.add(child.a,child.b));//child method 
		System.out.println("first add: "+child.add(child.a, 8));//parent method
		System.out.println("first add: "+child.add(child.stra,child.strb));//child method
		FiveBase child2 = new FiveTest();
		System.out.println("second add: "+child2.add(7, 8));//parent method
		System.out.println("second add: "+child2.add(child.a,child.b));//child method 
		System.out.println("second add: "+child2.add(child.a, 8));//parent method
		System.out.println("second add: "+child2.add(child.stra,child.strb));//child method 
		FiveBase parent = new FiveBase();
		System.out.println("second add: "+parent.add(7, 8));//parent method
		System.out.println("second add: "+parent.add(child.a,child.b));//parent method
		System.out.println("second add: "+parent.add(child.a, 8));//parent method
		System.out.println("second add: "+parent.add(child.stra,child.strb));//parent method
		
		}

}
