import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterEx {

	public static void main(String[] args) throws IOException {
		FileOutputStream b = new FileOutputStream("D:\\JavaTraining\\06FileInputOutput\\UsingStreams\\TextFile\\WriterText.txt");
		String str="welcome to java- writer";
		b.write(str.getBytes());
		System.out.println("File is printed");
		b.close();
	}

}
