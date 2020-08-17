import java.io.Serializable;  // a marker interface and do not contain any method to be defined
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class practice {
	static public class Initializers implements Serializable{   // if we want to serialize it is necessary to implement this mark
		private static final long serialVersionUID = 101;
		static int count;
		int i;                     // if we dont want to make variable serializable mark it as transient
		static {
			System.out.println("static initializer block called");
			System.out.println("value of count = " + count);
		}
		{
			i = count + 1;
			count++;
		}
		Initializers(){
			System.out.println("constructor");
			System.out.println("value of count and i for this particular instance");
			System.out.println(count + " " + i);
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Initializers obj1 = new Initializers();
		FileOutputStream fos = new FileOutputStream("seriazing.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj1);
		oos.close();
		FileInputStream fis = new FileInputStream("seriazing.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Initializers obj2 = (Initializers) ois.readObject();
		System.out.println(obj2.i);
		ois.close();
		System.gc();
	}

}