import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) throws IOException {
		FileWriter f = new FileWriter("D:\\JavaTraining\\06File\\TextFile\\WriterText.txt");
		BufferedWriter b = new BufferedWriter(f);

		b.write("welcome to java- writer");
		b.close();
	}

}
