import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class BTTEST {
    public static void main(String[] args)  {
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
            //System.out.println(treetest.inOrder());
            List<Integer> inOrd = new ArrayList<Integer>(treetest.inOrder());
            System.out.println(treetest.balancedTree(arr, 0, arr.size()-1));
            treetest.balancedTree(inOrd, 0, inOrd.size()-1);
            System.out.println(treetest.preOrder());

            scan.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
