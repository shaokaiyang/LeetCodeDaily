import java.util.*;

public class Main1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        int count0 = 0;
        int count1 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                count0++;
            }else{
                count1++;
            }
        }
        System.out.println(Math.abs((count0 - count1)));

    }


}
