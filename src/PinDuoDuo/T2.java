import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");
        Map<Character, Integer> map = new HashMap<>();
        for(String s : strings){
            char c1 = s.charAt(0);
            char c2 = s.charAt(s.length() - 1);
            if(map.containsKey(c1)){
                map.put(c1, map.get(c1) + 1);
            }else{
                map.put(c1, 1);
            }
            if(map.containsKey(c2)){
                map.put(c1, map.get(c2) + 1);
            }else{
                map.put(c1, 1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        boolean flag = true;
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> entry = iterator.next();
            if(entry.getValue() % 2 == 1){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("true");
        }else{
            System.out.println("false");
        }



    }

    public void sortt(){
        return;
    }
}
