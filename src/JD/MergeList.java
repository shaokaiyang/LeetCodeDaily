import java.util.*;

public class MergeList {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            Set<Integer> set = new TreeSet<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int i = 0; i < n; i++){
                set.add(scanner.nextInt());
            }
            for(int i = 0; i < m; i++){
                set.add(scanner.nextInt());
            }
            Iterator<Integer> iterator = set.iterator();
            while(iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
            System.out.println();

        }
    }


}
