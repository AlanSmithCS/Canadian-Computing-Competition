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

package CCC.CCC2023;

import java.util.ArrayList;
import java.util.Scanner;
public class S1_Trianglane {
    static ArrayList<Triangle> wetList = new ArrayList<>();
    static Triangle[][] all_triangles;
    final int UP = 1;
    final int DOWN = -1;

    static class Triangle {
        int x, y;
        public static int getOrientation (int index_x, int index_y) {
            return (int) Math.pow(-1, index_x+index_y); // geometric sequence
        }
        int orientation;
        Triangle[] wet_Neighbors;
        public Triangle(int pos_x, int pos_y) {
            this.orientation = getOrientation(pos_x, pos_y);
            x = pos_x;
            y = pos_y;
        }
    }
    public static void getNextTriangles (int C, int row, Scanner scanner) {
        System.out.println("Enter your value for row "+row+":");

        // Get previous
        int previous_wet = scanner.nextInt();
        if (previous_wet == 1) {
            Triangle current = new Triangle(0, row);
            wetList.add(current);
        }

        for (int i=1; i<C; i++) {
            int current_wet = scanner.nextInt();
            if (current_wet == 1) {
                Triangle current = new Triangle(i, row);
                wetList.add(current);
            }
            previous_wet = current_wet;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your value for C:");
        int C = scanner.nextInt();
        int rows = 2;

        all_triangles = new Triangle[rows][C];

        for (int i=0; i<rows; i++) {
            getNextTriangles(C, i, scanner);
        }

        System.out.println("\nwetList size: " + wetList.size());
        for (Triangle t : wetList) {
            System.out.println("("+t.x+", "+t.y+": "+t.orientation+")");
        }
    }
}