package lambda;

public class practice {
	
	public void dotask(LambdaInterface t) {
		t.performe();
	}
	

	public static void main(String[] args) {
	   practice p = new practice();
	   p.dotask(() -> System.out.println("Hello World"));
	   p.dotask(() -> System.out.println("Once again"));
	}

}

interface LambdaInterface{
	void performe();
}