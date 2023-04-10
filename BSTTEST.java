import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class BSTTEST {
    public static void main(String[] args)  {
        //get list of numbers from file
        try {
            File file = new File("bsttest.txt");
            Scanner scan = new Scanner(file);
            ArrayList<Integer> arr = new ArrayList<Integer>();

            for(String item: scan.nextLine().split(",")) {
                arr.add(Integer.parseInt(item));
            }
            //System.out.println(arr);

            BT<Integer> treetest = new BT<>();
            for (Integer item: arr) {
                treetest.add(item);
            }
            System.out.println(treetest.toString());
            
            scan.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        

        //do inorder traversal and put into array (then print)
        //read arr to create a balanced BST
        //perform a preorder traversal on the balanced BST and then print
    }
}