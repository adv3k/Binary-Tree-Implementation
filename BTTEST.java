import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class BTTEST {
    public static void main(String[] args)  {
        //get list of numbers from file
        try {
            File file = new File("treetest.txt");
            Scanner scan = new Scanner(file);
            ArrayList<Integer> arr = new ArrayList<Integer>();

            for(String item: scan.nextLine().split(",")) {
                arr.add(Integer.parseInt(item));
            }
            System.out.println(arr);

            BT<Integer> treetest = new BT<>();
            for (Integer item: arr) {
                treetest.add(item);
            }
            
            System.out.println(treetest.toString());
            System.out.println(treetest.inOrder());
            System.out.println(treetest.preOrder());
            System.out.println(treetest.balancedTree(arr, 0, arr.size()-1));

            scan.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
