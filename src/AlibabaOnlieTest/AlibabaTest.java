import java.util.*;
import java.util.List;
public class AlibabaTest {
/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt(((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
    }
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        double xMin = Double.MIN_VALUE;
        double xMax = Double.MAX_VALUE;
        double yMin = Double.MIN_VALUE;
        double yMax = Double.MAX_VALUE;
        for(int i = 0; i < xList.size(); i++){
            if(xMin > xList.get(i)){
                xMin = xList.get(i);
            }
            if(xMax < xList.get(i)){
                xMax = xList.get(i);
            }
            if(yMin > yList.get(i)){
                yMin = yList.get(i);
            }
            if(yMax < yList.get(i)){
                yMax = yList.get(i);
            }
        }
        String result = "";
        if(x >= xMin && x <= xMax && y >= yMin && y <= yMax){
            result = "yes,0";
        }else{
            double tmp = Double.MAX_VALUE;
            for(int i = 0; i < xList.size(); i++){
                double distance = distance(xList.get(i), yList.get(i), x, y);
                if(tmp > distance){
                    tmp = distance;
                }
            }
            result = "no," + (int)tmp;
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