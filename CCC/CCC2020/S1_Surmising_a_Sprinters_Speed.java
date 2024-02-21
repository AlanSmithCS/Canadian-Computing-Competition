package CCC.CCC2020;

/*
----- Problem Description
Trick E. Dingo is trying, as usual, to catch his nemesis the Street Sprinter. His past attempts
using magnets, traps and explosives have failed miserably, so he’s catching his breath to gather
observational data and learn more about how fast Street Sprinter is.
Trick E. Dingo and Street Sprinter both inhabit a single straight west-east road with a particularly
famous rock on it known affectionately as The Origin. Positions on this straight road are measured
numerically according to the distance from The Origin, and using negative numbers for positions
west of The Origin and positive numbers for positions east of The Origin.
The observations by Trick E. Dingo each contain two numbers: a time, and the value of Street
Sprinter’s position on the road at that time. Given this information, what speed must Street Sprinter
must be capable of?

----- Input Specification
The first line contains a number 2 ≤ N ≤ 100 000, the number of observations that follow. The
next N lines each contain an integer 0 ≤ T ≤ 1 000 000 000 indicating the time, in seconds, of
when a measurement was made, and an integer −1 000 000 000 ≤ X ≤ 1 000 000 000 indicating
the position, in metres, of the Street Sprinter at that time. No two lines will have the same value of T.
For 7 of the 15 available marks, N ≤ 1000.

----- Output Specification
Output a single number X, such that we can conclude that Street Sprinter’s speed was at least X
metres/second at some point in time, and such that X is as large as possible
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class S1_Surmising_a_Sprinters_Speed {
    public static void main(String[] args) {
        // v = s/t

        PriorityQueue<Integer> orderedTimes = new PriorityQueue<>(); // minHeap
        HashMap<Integer, Integer> corresponding_x = new HashMap<>(); // corresponding displacement for each time

        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine()); // Number of observations to follow

        int T, X;
        for (int i = 0; i < N; i++) {
            T = scan.nextInt();
            X = scan.nextInt();

            orderedTimes.add(T);
            corresponding_x.put(T, X);

            scan.nextLine(); // workaround for unaccounted for newline
        }

        int nextTime, currentDisplacement, nextDisplacement;
        double max_v=0, current_v;

        int currentTime = orderedTimes.remove();

        for (int i = 0; i < N-1; i++) {
            currentDisplacement = corresponding_x.get(currentTime);

            nextTime = orderedTimes.remove();
            nextDisplacement = corresponding_x.get(nextTime);

            double theta_x = nextDisplacement - currentDisplacement;

            current_v = Math.abs(theta_x) / (nextTime - currentTime);

            if (current_v > max_v) {
                max_v = current_v;
            }
            currentTime = nextTime;
        }

        System.out.println(max_v);
    }
}