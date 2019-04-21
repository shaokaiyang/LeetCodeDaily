import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class VariantTest{

    public static int staticVar = 0;
    public int instanceVar = 0;

    public VariantTest(){
        staticVar++;
        instanceVar++;
        System.out.println("staticVar=" + staticVar + ",instanceVar="+ instanceVar);
    }
}

public class DuoTai {

    public static List<String> judge(int i){
        List<String> list;
        if(i == 0){
           list = new ArrayList<>();
           list.add("arrylist" + i);
           return list;
        }
        list = new LinkedList<>();
        list.add("linkedlist" + i);
        return list;
    }

    public static void main(String[] args){
        List<String> list = judge(0);
        List<String> list1 = judge(2);
//        System.out.println(list.toString());
//        System.out.println(list1.toString());

        VariantTest variantTest1 = new VariantTest();
        VariantTest variantTest2 = new VariantTest();
    }
}
