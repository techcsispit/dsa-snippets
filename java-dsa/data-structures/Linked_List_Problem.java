//link to the problem statement: https://leetcode.com/problems/add-two-numbers/
 
import java.math.BigInteger;
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Linked_List_Problem {
    String revno(BigInteger a){
        String n=a+"";
        String r="";
        for(int i=n.length()-1;i>=0;i--){
            r=r+n.charAt(i);
        }
        return r;
    }
    ListNode intToLN(BigInteger a)throws NumberFormatException  {
        String a1 = revno(a);
        String a2=a1;
        ListNode l1 = new ListNode();
        while (a1 != "") {
            BigInteger a11=new BigInteger(a1);
            BigInteger two=new BigInteger("10");
            BigInteger rem = (a11.mod(two));
            if (a1.equals(a2)) {
                l1 = new ListNode((int)rem.intValue(),null);
            } else {
                l1 = new ListNode((int)rem.intValue(),l1);
            }
            a1=a1.substring(0,a1.length()-1);
        }
        return l1;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger n1=new BigInteger("0");
        BigInteger n2=new BigInteger("0");
        BigInteger ten=new BigInteger("10");
        int i=0;
        while(l1 != null){
            BigInteger temp=new BigInteger(l1.val+"");
            n1=n1.add(ten.pow(i++).multiply(temp));
            l1=l1.next;
        }
        String n11=n1+"";
        BigInteger n111=new BigInteger(n11);
        i=0;
        while(l2 != null){
            BigInteger temp=new BigInteger(l2.val+"");
            n2=n2.add((ten.pow(i++).multiply(temp)));
            l2=l2.next;
        }
        String n22=n2+"";
        BigInteger n222=new BigInteger(n22); 
        BigInteger sum=n111.add(n222);
        ListNode t=new ListNode();
        t=intToLN(sum);
        return t;
    }
}