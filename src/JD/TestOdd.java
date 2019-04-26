import java.util.*;
public class TestOdd {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        int[] nums = {1,2,3,4,5};
        //list.addAll(Arrays.asList(nums));
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) % 2 != 0){
                result.add(list.get(i));
            }
        }
        System.out.println(result.toString());
    }

}
