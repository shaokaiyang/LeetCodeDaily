import java.util.*;

public class Nqueen {

    private static int count = 0;
    private static int NQUEEN = 0;
    private static int[] que;
    Nqueen(int x){
        this.NQUEEN = x;
        this.que = new int[x+1];
    }

    /**
     *
     * @param row: 当前所在的行数
     * @param col：所有的列
     * @param pie： 左下角位置
     * @param na： 右下角位置，即不允许皇后在一条斜率为1或者-1的斜线上
     */
    public static void nqueen1(int row, int col ,int pie, int na){
        // 递归终止条件
        if(row >= NQUEEN){
            count ++;
            return;
        }
        // 选取一行中可以防止皇后的位置
        int bits = (~(col|pie|na)) & ((1 << NQUEEN)-1);
        while(bits > 0){
            // 在能够放置皇后的位置中选择一个位置，每次从最后的位置选取
            int p = bits & -bits;
            // 往下一层递归
            nqueen1(row+1, (col|p), (pie|p) << 1, (na|p) >>1);
            // 将该行可防止皇后的最后一位去掉，表示该位置已经尝试过
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
