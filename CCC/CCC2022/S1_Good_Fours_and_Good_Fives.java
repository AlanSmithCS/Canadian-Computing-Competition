package CCC.CCC2022;

import java.util.*;

public class S1_Good_Fours_and_Good_Fives
{
    static HashMap<Integer, Integer> memo; // Memoized solutions
    public static int get_combinations(int N)
    {
        if (! Objects.isNull(memo.get(N))) {
            return memo.get(N);
        }
        else if (N < 4) {
            memo.put(N, 0);
            return 0;
        }
        else {
            int L = N-5;
            int R = N-4;
            int combi = get_combinations(L) + get_combinations(R);
            memo.put(N, combi);
            return combi;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        memo.put(4, 1);
        memo.put(5, 1);

        int N = Integer.parseInt(scan.nextLine());

        System.out.println(get_combinations(N));
    }
}
