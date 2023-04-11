import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BTTEST {
    public static void main(String[] args)  {
        try {
            File file = new File("bsttest.txt");
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
            ArrayList<Integer> inOrd = treetest.inOrder();
            System.out.println(inOrd);
            treetest.balancedTree(inOrd);
            System.out.println(treetest.preOrder());

            scan.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}

