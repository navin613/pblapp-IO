import java.io.*;
import java.util.*;

public class ques2 {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the input file name : ");
        String fname1 = sc.nextLine();
        File f1 = new File(fname1);
        System.out.println("Enter the output file name : ");
        String fname2 = sc.nextLine();
        File f2 = new File(fname2);
        BufferedReader br = new BufferedReader(new FileReader(f1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
        int temp = 0;
        while(temp!=-1){
            temp=br.read();
            bw.write((char)temp);
        }
    }
}
