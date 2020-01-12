import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class toOverride extends BufferedReader {

	public toOverride(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int read() throws IOException {
//		for(int i=0;i<=20;i++) {
//		System.out.println(super.read());}

		int value = super.read();
		if (value >= 97 && value <= 122) {
			value = value - 32;
			// sSystem.out.println("simple"+value);
		}

		return value;

	}

}
