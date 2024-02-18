/*
# Problem J4/S1: Trianglane

## Problem Description
Bocchi the Builder just finished constructing her latest project: a laneway consisting of two
rows of white equilateral triangular tiles. However, at the last moment, disaster struck! She
accidentally spilled black paint on some of the tiles. Now, some of the tiles are wet and the
other tiles are dry. Bocchi must place warning tape around the perimeters of all wet areas.
Can you help her determine how many metres of tape she needs?
The first triangular tile will point upwards. Each pair of adjacent tiles (that is, tiles that
share a common side) will point in opposite directions. Each tile has a side length of 1 metre.

## Input Specification
The first line of input will consist of one positive integer C, representing the number of
columns.
The next two lines will each consist of C integers separated by spaces. Each integer represents
the colour of a tile along the laneway, with 1 indicating that the tile is black (wet) and 0
indicating that the tile is white (dry).
The following table shows how the available 15 marks are distributed:

Marks   | Description                                                   | Bound
--------------------------------------------------------------------------------------
3       | The laneway is not very long, black tiles are never adjacent  | C ≤ 2 000
        | and the second row is fully white.                            |
--------------------------------------------------------------------------------------
3       | The laneway is not very long, black tiles may be adjacent     | C ≤ 2 000
        | and the second row is fully white.                            |
--------------------------------------------------------------------------------------
5       | The laneway is not very long, black tiles may be adjacent     | C ≤ 2 000
        | and may appear in the second row.                             |
--------------------------------------------------------------------------------------
4       | The laneway may be very long, black tiles may be adjacent     | C ≤ 200 000
        | and may appear in the second row.                             |
--------------------------------------------------------------------------------------

## Output Specification
Output a single integer representing the length of tape Bocchi needs, in metres.

### Sample Input 1
5
1 0 1 0 1
0 0 0 0 0
Output for Sample Input 1
9

## Sample Input 2
7
0 0 1 1 0 1 0
0 0 1 0 1 0 0
Output for Sample Input 2
11


*/

package CCC.CCC2015;

import CCC.Challenge;

import java.util.Scanner;
import java.util.Stack;

public class S1_Zero_That_Out extends Challenge {
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int number_of_lines = scanner.nextInt();
        int sum = 0;

        for (int i=0; i<number_of_lines; i++)
        {
            int current = scanner.nextInt();

            if (current == 0)
            {
                int sub = inputStack.pop();
                //System.out.println("Popped:" + sub);
                sum -= sub;
            }
            else
            {
                sum += current;
                inputStack.push(current);
                //System.out.println("Added:" + current);
            }
            //System.out.println("Current Sum:" + sum);
        }

        // Final sum
        System.out.println(sum);
    }
}