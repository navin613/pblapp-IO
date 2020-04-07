package ques3;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ques3 {
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
        Map<String,Integer> m = new TreeMap<>();
        
        String str;
        while((str=br.readLine())!=null){
            str.trim();
            String [] wd = str.split(" ");
            for(String words : wd){
                if(!m.containsKey(words)){
                    m.put(words,1);
                }
                else
                    m.put(words,m.get(words)+1);
            }
        }
        
        Set<Entry<String,Integer>> set = m.entrySet();
        Iterator<Entry<String,Integer>> it = set.iterator();
        
        while(it.hasNext()){
            Entry <String,Integer> me = it.next();
            bw.write(me.getKey()+ " : "+me.getValue()+"\n");
        }
        br.close();
        bw.close();
    }
}
