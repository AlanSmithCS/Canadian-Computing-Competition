package CCC.CCC2015;

import java.util.*;

/*
TEST 1:

4
3
M
S
S
L
L 3
S 3
L 1

OP: 1

TEST 2 same numbers and same sizes, more jerseys than players:

5
3
S
S
M
L
L
L 2
L 2
M 2

OP: 1
*/

public class S2_Jerseys {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int number_of_jerseys = Integer.parseInt(scanner.nextLine());
        int number_of_athletes = Integer.parseInt(scanner.nextLine());
        System.out.println("DEBUG: ---------------------------- J:"+number_of_jerseys+", A:"+number_of_athletes);
        int fulfillable = 0; // number of fulfillable orders

        HashMap<Character, Integer> stock = new HashMap<>(); // contains available SML
        HashMap<Integer, Integer> number_sieve = new HashMap<>(); // contains used up numbers on jerseys
        //      Size     : Jersey Numbers
        HashMap<Character, ArrayList<Integer>> demand = new HashMap<>();

        stock.put('S', 0);
        stock.put('M', 0);
        stock.put('L', 0);

        demand.put('S', new ArrayList<>());
        demand.put('M', new ArrayList<>());
        demand.put('L', new ArrayList<>());

        // get all available stock
        for (int j=0; j<number_of_jerseys; j++)
        {
            char size = scanner.nextLine().charAt(0);
            stock.put(size, stock.get(size)+1);
        }
        System.out.println("DEBUG: ---------------------------- Got all stock into hashmap");

        // get demand for numbers and sizes
        for (int a=0; a<number_of_athletes; a++)
        {
            char size = scanner.next().charAt(0);
            int number = scanner.nextInt();

            ArrayList<Integer> orderList = demand.get(size);
            orderList.add(number);

            demand.put(size, orderList);

            //workaround for leftover newline
            scanner.nextLine();
        }

        System.out.println("\tDEBUG: ------- STOCK   S: "+stock.get('S')+", M:"+ stock.get('M')+", L:"+ stock.get('L'));
        System.out.println("\tDEBUG: ------- DEMAND  S: "+demand.get('S').size()+", M:"+ demand.get('M').size()+", L:"+ demand.get('L').size());

        // Deal with orders from Most -> Least constrained (in this case: Biggest size -> Smallest Size)
        char[] steps = {'L', 'M', 'S'};

        int i=0; // marker of step
        for (char current_size : steps) { // L -> M -> S
            System.out.println("\nDEBUG: ---------------------------- size = "+ current_size);
            ArrayList<Integer> neededList = demand.get(current_size); // needed jerseys from order of that size

            for (int jersey_num : neededList) {
                System.out.println("\tDEBUG: ------------ Looking for Jersey: "+ jersey_num);
                if (Objects.isNull(number_sieve.get(jersey_num))) // check if jersey number is available (not null means taken)
                {
                    boolean found_jersey = false;
                    while (!found_jersey) {

                        // j represents jersey size indices that will fit
                        for (int j=i; j>=0; j--)
                        {
                            if (stock.get(steps[j]) > 0) { // if there are some remaining jerseys of a size that fit
                                stock.put(steps[j], stock.get(steps[j])-1);
                                fulfillable++;
                                found_jersey = true;
                                System.out.println("\tDEBUG: ------- FOUND JERSEY! S: "+stock.get('S')+", M:"+ stock.get('M')+", L:"+ stock.get('L'));
                                break;
                            }
                        }
                        if (stock.get('L') == 0) {
                            found_jersey = true; // didnt really find a jersey, i just named the var badly lol
                        }
                    }

                    number_sieve.put(jersey_num, 1); // put value so it doesnt return null
                }
            }
            i++;
        }
        System.out.print(fulfillable);
    }
}
