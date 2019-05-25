import java.util.*;
import java.util.List;
public class AlibabaTest {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        double xMin = Double.MIN_VALUE;
        double xMax = Double.MAX_VALUE;
        double yMin = Double.MIN_VALUE;
        double yMax = Double.MAX_VALUE;
        List<Double> xTmp = xList;
       xList.sort(new Comparator<Double>() {
           @Override
           public int compare(Double o1, Double o2) {
               return (int)(o1-o2);
           }
       });
       System.out.println(xList);

        for(int i = 0; i < xList.size(); i++){
            if(xList.get(i) < xMin){
                xMin = xList.get(i);
            }else{
                xMax = xList.get(i);
            }
            if(yList.get(i) < xMin){
                xMin = yList.get(i);
            }else{
                xMax = yList.get(i);
            }
        }
        String result = "";
        if(x >= xMin && x <= xMax && y >= yMin && y <= yMax){
            result = "yes,0";
        }else{
            int tmp = 0;
            result = "no," + tmp;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}