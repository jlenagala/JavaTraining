/**
 * 
 */
package showReleventDateTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

/**
 * @author Dell
 *
 */
public class ShowDateTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LocalDateTime t= LocalDateTime.now(ZoneId.of("GMT"));
		LocalDateTime t1= LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
		System.out.println(t);
		System.out.println(t1);
		
		int year,month,day,hour,min,sec;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a year : ");
		year=input.nextInt();
		System.out.print("Please enter a month : ");
		month=input.nextInt();
		System.out.print("Please enter a Day : ");
		day=input.nextInt();
		System.out.print("Please enter a Hour : ");
		hour=input.nextInt();
		System.out.print("Please enter a Min : ");
		min=input.nextInt();
		System.out.print("Please enter a Sec : ");
		sec=input.nextInt();
		System.out.println("Input Number is: "+year);

	}

}
