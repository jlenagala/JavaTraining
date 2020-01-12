import java.io.FileReader;
import java.io.IOException;

public class CapitalizeTextFile {

	public static void main(String[] args) throws IOException {

		FileReader f = new FileReader("D:\\JavaTraining\\05OverridingReadMethod\\TextFile\\ReaderText.txt");
		ToOverride b = new ToOverride(f);

		int i;
		while ((i = b.read()) != -1) {
			// System.out.println("nn"+i);
			char printChar = (char) i;
			System.out.print(printChar);

		}

		b.close();
	}

}
