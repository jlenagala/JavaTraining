import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderEx {

	public static void main(String[] args) throws IOException {
		
		FileReader f = new FileReader("D:\\JavaTraining\\06File\\TextFile\\ReaderText.txt");
		BufferedReader b = new BufferedReader(f);

		int i;
		while ((i = b.read()) != -1) {
			// System.out.println("nn"+i);
			char printChar = (char) i;
			System.out.print(printChar);

		}
		b.close();
	}

}
