import java.util.*;

public class Nqueen {

    private static int count = 0;
    private static int NQUEEN = 0;
    private static int[] que;
    Nqueen(int x){
        this.NQUEEN = x;
        this.que = new int[x+1];
    }

    public static void nqueen1(int row, int col ,int pie, int na){
        if(row >= NQUEEN){
            count ++;
            return;
        }
        int bits = (~(col|pie|na)) & ((1 << NQUEEN)-1);
        while(bits > 0){
            int p = bits & -bits;
            nqueen1(row+1, (col|p), (pie|p) << 1, (na|p) >>1);
            bits &= bits - 1;
        }
    }

    public static boolean check(int loc){
        for(int i = 1; i < loc; i++){
            if(que[i] == que[loc] || Math.abs(que[i] - que[loc  ]) == Math.abs(i - loc)){
                return false;
            }
        }
        return true;
    }
    public static void nqueen2(){
        int loc = 1;
        while(loc >= 1){
            que[loc] ++;
            if(que[loc] == NQUEEN+1){
                loc --;
            }else if(check(loc)){
                if(loc == NQUEEN){
                    count ++;
                    loc --;
                }else{
                    loc ++;
                    que[loc] = 0;
                }
            }
        }

    }

    public static void main(String[] args){
        Nqueen nqueen = new Nqueen(9);
        //nqueen.nqueen1(0,0,0,0);
        nqueen.nqueen2();
        System.out.println(nqueen.count);
    }
}
