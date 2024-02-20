package CCC.CCC2022;

import java.util.*;

public class S1_Good_Fours_and_Good_Fives
{
    public static void main(String[] args) {
        //                    0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20
        int[] combinations = {0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 3};
        // 4a + 5b = N
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        int possible = 0;
        for (int a=0; a<=N/4; a++) {
            if ((N-4*a) % 5 == 0) {
                for (int b=0; b<=N/5; b++) {
                    if (4*a + 5*b == N) {
                        possible++;
                    }
                }
            }
        }

        System.out.println(possible);
    }
}
