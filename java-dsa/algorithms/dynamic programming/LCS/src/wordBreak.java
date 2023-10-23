//link to the problem statement: https://leetcode.com/problems/word-break/

import java.util.*;

public class wordBreak {
    List<String> list;
    HashMap<String,Boolean> hm;
    public boolean wordBreak1(String s, List<String> wordDict) {
        list=wordDict;
        hm=new HashMap<>();
        return word(s,0,""+s.charAt(0));
    }
    boolean word(String s,int index, String control){
        if(index>=s.length()-1){
            return list.contains(control);
        } else if(hm.containsKey(index+ " " + control.length())){
            return hm.get(index+" "+control.length());
        }else if(list.contains(control)==false){
            hm.put(index+" "+control.length(),word(s,index+1,control+s.charAt(index+1)));
            return hm.get(index+" "+control.length());
        } else {
            boolean a= word(s,index+1,control+ s.charAt(index+1));
            boolean b=word(s,index+1,s.charAt(index+1)+"");
            hm.put(index+ " " + control.length(),a||b);
            return hm.get(index+" "+control.length());
        }
    }

    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);
        while(true){
            System.out.println("1.Enter word in dict\n2.Exit lol\n");
            if(sc.nextInt()!=1) break;
            else {
                System.out.println("Please enter a word: ");
                l.add(sc1.nextLine());
            }
        }
        wordBreak ob=new wordBreak();
        System.out.println("Please enter word: ");
        System.out.println(ob.wordBreak1(sc1.next(),l));
    }
}
