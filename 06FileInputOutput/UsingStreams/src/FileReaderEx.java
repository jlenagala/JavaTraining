import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReaderEx {

	public static void main(String[] args) throws IOException {

		FileInputStream f = new FileInputStream(
				"D:\\JavaTraining\\06FileInputOutput\\UsingStreams\\TextFile\\ReaderText.txt");
		try {
			int i;
			while ((i = f.read()) != -1) {
				// System.out.println("nn"+i);
				char printChar = (char) i;
				System.out.print(printChar);

			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}

}
