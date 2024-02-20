package CCC.CCC2022;

import java.util.*;

public class S1_Good_Fours_and_Good_Fives
{
    public static void main(String[] args) {
        // 4a + 5b = N
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        int possible = 0;
        for (int a=0; a<=N/4; a++) {
            for (int b=0; b<=N/5; b++) {
                if (4*a + 5*b == N) {
                    possible++;
                }
            }
        }
        System.out.println(possible);
    }
}
