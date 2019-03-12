/**
 * description:某物流派送员p，需要给 a、b、c、d. 4个快递点派送包裹，请问派送员需要选择什么样的路线，
 * 才能完成最短路程的派送。假设如图派送员的起点坐标(0,0)，派送路线只能沿着图中的方格边行驶，
 * 每个小格都是正方形，且边长为1，如p(0,0)到d(3,1)的距离就是4。随机输入n个派送点坐标，
 * 求输出最短派送路线值（从起点开始完成n个点派送并回到起始点的距离）。
 * input: n个坐标点的坐标
 * output：距离
 */

import java.util.*;

class Point{
    //记录坐标值及是否遍历过
    int x;
    int y;
    boolean isVisited;

    public Point(int x, int y){
        this.x  = x;
        this.y = y;
        this.isVisited = false;
    }

    /**
     * 计算该点到指定点之间的距离
     * @param p
     * @return 两点距离
     */
    public int getDistance(Point p){
        return Math.abs(x - p.x) + Math.abs(y - p.y);
    }
}

public class DeliveryMethod {
    static Point startPoint = new Point(0,0);
    static int minPath = Integer.MAX_VALUE;

    /**
     * 定义给定点到其余点的最小路径方法，递归调用
     * @param p 给定的起始点
     * @param points 其余的点
     * @param  totalLen
     * @param  count 用来对遍历过的点计数
     */
    public static int caculate(Point p , Point[] points, int totalLen, int count){
        if(points.length == count){
            minPath = Math.min(minPath, totalLen + p.getDistance(startPoint));
            return minPath;
        }
        //遍历其余的点进行路径和计算
        for(int i = 0; i < points.length; i++){
            if(points[i].isVisited ==false){
                totalLen += points[i].getDistance(p);
                //若小于最小路径那么从这个点开始继续遍历
                if(totalLen < minPath){
                    points[i].isVisited = true;
                    caculate(points[i], points, totalLen, count+1);
                }
                //将路径和倒减，标志为false，进行下一个方案的计算
                totalLen -= points[i].getDistance(p);
                points[i].isVisited = false;
            }
        }
        return minPath;
    }

    public static void main(String[] args){
        int totalLen = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Point[] points = new Point[n];

        for(int i = 0; i < n; i++){
            String[] strings = scanner.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
        }

        minPath = caculate(startPoint, points, totalLen, count);
        System.out.println(minPath);
    }

}
