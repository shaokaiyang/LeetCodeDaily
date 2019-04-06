import java.util.ArrayList;
import java.util.List;

public class KuoHaoGen {

    public static List gen(int n){
        List<String> result = new ArrayList<>();
        kuoHaoGen(result, "", 0, 0, n);
        return result;
    }

    public static void kuoHaoGen(List<String> result, String sub, int left, int right, int n){
        if(left == n && right == n){
            result.add(sub);
            return;
        }
        if(left < n){
            kuoHaoGen(result,sub+'(', left+1, right, n);
        }
        if(left > right){
            kuoHaoGen(result, sub+'）', left, right+1, n);
        }
    }

    public static void main(String[] args){
        List result = gen(6);
        System.out.println(result);

    }
}
