
import java.util.*;
import java.util.LinkedList;

class Solution {

    static class Location{
        int x;//列数
        int y;//行数
        Location(int x, int y){
            this.x =x;
            this.y = y;
        }
    }

    public static int count = 0;

    public static int totalNQueens(int n) {

        LinkedList list;
        list = new LinkedList<Location>();
        NQueen(list, 0 ,0, n);
        return count;
    }

    public static boolean isLegal(LinkedList<Location> list, Location loc){
        for(Location each : list){
            if(loc.x == each.x || loc.y == each.y){
                return false;
            }else if (Math.abs(loc.x - each.x) == Math.abs(loc.y - each.y)){
                return false;
            }
        }
        return true;
    }

    public static void NQueen(LinkedList<Location> list, int x, int y, int n){

        if (list.size() == n){
            count++;
            return;
        }

        for(int i = x; i <n; i++){
            Location loc = new Location(i, y);
            if(isLegal(list, loc)){
                list.offer(loc);
                NQueen(list, 0, y+1,n);
                list.pollLast();
            }
        }
    }
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        System.out.println(totalNQueens(16));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}