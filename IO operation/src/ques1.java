import java.io.*;
import java.util.*;
public class ques1 {
    public static void main(String args[]) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name : ");
        String fname = sc.nextLine();
        File f = new File(fname);
        System.out.println("Enter the character to be counted : ");
        char ch = sc.nextLine().charAt(0);
        char chc = ch;
        BufferedReader br = new BufferedReader(new FileReader(f));
        int c = 0;
        int temp;
        do{
            temp = br.read();
            if(temp>=97 && temp<=122)
                temp=temp-32;
            if(ch>=97 && ch<=122)
                ch=(char) ((int)ch-32);
            if(temp==(int)ch)
                c++;
        }while(temp!=-1);
        System.out.println("File '"+fname+"' has "+c+" instances of letter "+chc);
    }
}
