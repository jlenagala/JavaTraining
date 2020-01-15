import java.util.Scanner;

public class FrogEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int choice;
		int time = 0;
		int distance = 0;

		Scanner inputVar = new Scanner(System.in);
		System.out.print("	1. Time (s) \n 	2. Distance (m) \n What do you want to calculate? (1 or 2) : ");
		choice = inputVar.nextInt();
		/*
		 * when times enter
		 */
		if (choice == 1) {

			System.out.print("1 Enter Time (s) : ");
			time = inputVar.nextInt();
			if (time < 0) {
				System.out.println("Please enter valid time entries");
			}
			if (time / 9 != 0) {
				distance = (time / 8) * 9;
				time = time % 8;
			}

			while (time != 0) {
				distance = distance + 5;
				time = time - 1;

				if (time >= 1) {
					distance = distance + 3;
					time = time - 2;

					if (time >= 2) {
						distance = distance + 1;
						time = time - 5;
					}
					if (time <= 5) {

						break;

					}
				}

			}

			System.out.println(distance);

		}
		/*
		 * When distance enter
		 */
		else if (choice == 2) {

			System.out.print("2 Enter Distance (m) : ");
			distance = inputVar.nextInt();
			if (distance < 0) {
				System.out.println("Please enter valid distance entries");
			}
			if (distance / 9 != 0) {
				time = (distance / 9) * 8;
				distance = distance % 9;
			}

			while (distance > 4) {
				time = time + 1;

				distance = distance - 5;

				if (distance > 3) {
					time = time + 2;
					distance = distance - 3;

					if (distance > 1) {
						time = time + 5;
						distance = distance - 1;
					}
					if (distance < 5) {
						break;
					}
				}
			}

			System.out.println(time);

		} else {
			System.out.println("Please enter valid input. (1 or 2)");
		}
	}

}
