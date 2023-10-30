import java.util.*;
import java.util.HashMap;
public class HashMap_object_demo {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter new value to be entered in Hashmap:");
        int a=sc.nextInt(); //Entered 54
        HashMap<String,Integer> hash1=new HashMap<String,Integer>();
        hash1.put("Value 1",a);
        hash1.put("Value 2",24);
        hash1.put("Value 3",25);
        hash1.put("Value 4",55);
        System.out.println(hash1.containsValue(a)); //true
        System.out.print("Old size:"); // 4
        System.out.println(hash1.size());
        hash1.put("Value 5",a);
        System.out.print("New size:"); //5
        System.out.println(hash1.size());
        System.out.println(hash1.keySet()); //[Value 5, Value 3, Value 4, Value 1, Value 2]
        System.out.println(hash1.values()); //[54, 25, 55, 54, 24]
        System.out.println(hash1.containsKey(a)); //false
        System.out.println(hash1.replace("Value 5",a+10)); //54(Old value which has now been replaced)
        System.out.print(hash1.get("Value 8")); //null
    }
}
