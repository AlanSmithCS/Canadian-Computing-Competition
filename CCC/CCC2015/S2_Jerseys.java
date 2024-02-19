package CCC.CCC2015;

import java.util.*;
public class S2_Jerseys {
    static char[] sizes = {'S', 'M', 'L'};
    public static boolean valid(char Jersey_Size, char Player_Size) {
        int j = 0, p = 0;
        for (int k=0; k<sizes.length; k++) {
            if (sizes[k] == Jersey_Size) {
                j = k;
            }
            if (sizes[k] == Player_Size) {
                p = k;
            }
        }

        return p <= j; // return true if jersey size is less than player size
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number_of_jerseys = Integer.parseInt(scanner.nextLine());
        int number_of_athletes = Integer.parseInt(scanner.nextLine());
        System.out.println("DEBUG: ---------------------------- J:"+number_of_jerseys+", A:"+number_of_athletes);
        int fulfillable = 0; // number of fulfillable orders

        char[][] stock = new char[number_of_jerseys][2]; // contains available SML

        // get all available stock
        for (int j=0; j<number_of_jerseys; j++)
        {
            char size = scanner.nextLine().charAt(0);
            stock[j] = new char[]{size, 'O'}; // 'O' means not taken, 'X' means already assigned
        }

        for (int a=0; a<number_of_athletes; a++)
        {
            char size = scanner.next().charAt(0);
            int number = scanner.nextInt();

            if (stock[number][1] != 'X' && valid(stock[number][0], size)) {
                fulfillable++;
                stock[number][1] = 'X';
            }
        }
        System.out.println(fulfillable);
    }
}
