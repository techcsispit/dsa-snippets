/*Self-curated problem: Given a string of brackets, check whether the brackets are perfectly closed or not
    Example 1: "()()(())"  Brackets are perfectly closed
    Example 2: ")))))(((((" Brackets aren't perfectly closed
    Example 3: "(" Brackets aren't perfectly closed
*/
import java.util.Scanner;

class Brackets_string {

    void check(String str1) {
        int openbrack = 0;
        int closebrack = 0;
        String b = "";
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            b = b + ch;
            if (ch == '(') { //Counting series of open brackets in succession
                openbrack++;
            }
            if (ch == ')') { //Two cases when you encounter a closed bracket
                if (openbrack != closebrack) {
                    closebrack++;
                } else if (openbrack == closebrack) {
                    int a = b.length();
                    int count = 0;
                    int a1 = a;
                    for (int j = a - 1; j < str1.length(); j++) {
                        if (ch == ')') {
                            count++;
                        }
                        if (ch == '(') {
                            break;
                        }
                        a1++;
                    }
                    i = i + (a1 - i);
                    closebrack = closebrack + count;
                }
            }
        }
        if (openbrack == closebrack) {
            System.out.println("Brackets are perfectly closed.");
        } else {
            System.out.println("Brackets aren't perfectly closed.");
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a string full of brackets: ");
        String str=sc.nextLine();
        Brackets_string ob=new Brackets_string();
        ob.check(str);
    }
}


