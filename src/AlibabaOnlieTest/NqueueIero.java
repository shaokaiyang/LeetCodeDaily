public class NqueueIero {

    public static final int MAX_QUEUE = 16;
    //记录总的合理情况数
    public static int count = 0;
    //记录第N行摆放的皇后位置，索引代表行号，值代表列号
    public static int[] queen = new int[MAX_QUEUE+1];

    NqueueIero(){
        for(int i = 0; i < MAX_QUEUE+1; i++){
            queen[i] = 0;
        }
    }

    public boolean check(int loc){
        for(int i = 1; i < loc; i++){
            if(queen[i] == queen[loc] || Math.abs(queen[i] - queen[loc]) == Math.abs(i - loc)){
                return false;
            }
        }
        return true;
    }

    public void getResult(int N){
        //从第一行开始进行寻找
        int loc = 1;
        //模拟向上回溯的过程
        while(loc >= 1){
            //尝试摆放皇后
            queen[loc]++;
            //如果该行搜索到最后也没有找到合适的位置，回溯到上一行
            if(queen[loc] == N+1){
                loc--;
            }else if(check(loc)){
                //如果到达最后一行
                if(loc == N){
                    //计数
                    count++;
                    //回溯
                    loc--;
                }else{
                    //向下寻找
                    loc++;
                    //回溯，清除本行的影响
                    queen[loc] = 0;
                }
            }
        }
        return;
    }

    public static void main(String[] args){
        NqueueIero nqueueIero = new NqueueIero();
        long start = System.currentTimeMillis();
        nqueueIero.getResult(16);
        System.out.println(count);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
