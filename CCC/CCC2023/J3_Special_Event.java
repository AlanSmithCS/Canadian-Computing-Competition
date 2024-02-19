package CCC.CCC2023;

import java.util.Scanner;

public class J3_Special_Event {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine(); // workaround as nextInt leaves the leftover newline

                      // Day: 1  2  3  4  5
        int[] availability = {0, 0, 0, 0, 0};
                    // Index: 0  1  2  3  4

        for (int n=0; n<N; ++n) {
            String individual_availability = scan.nextLine();

            int i=0;
            for (char character : individual_availability.toCharArray()) {
                if (character == 'Y') {
                    availability[i] = availability[i] + 1;
                }

                i++;
            }
        }

        int max = 0; // assume max number of attendees is on day 1
        for (int day=1;  day<availability.length; day++) {
            if (availability[max] < availability[day]) {
                max = day;
            }
        }
        boolean flag = false;

        for (int day=0;  day<availability.length; day++) {
            if (availability[day] == availability[max]) {

                if (flag == true) {
                    System.out.print(",");
                }
                System.out.print(day+1); // index and days are offset by 1
                flag=true;
            }
        }
        System.out.print("\n"); // add newline
    }
}
