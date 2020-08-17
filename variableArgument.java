
public class variableArgument {

	public static void main(String[] args) {
		vararg(1,2,3);
	}
	
	static void vararg(int... numbers) {
		for(int i  : numbers) {
			System.out.println(i);
		}
	}

}
