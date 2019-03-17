/**
 * description:去掉三连重复（aaa）的最后一个，两对（aabb）的最后一个，而且符合最后匹配，
 * 所以直接从左开始模拟，两个bool，
 * 一个表示当前位前1，2位是否相等，另一个表示当前位的前2，3位是否相同。
 */


import java.util.*;

public class Main implements Runnable{

    private final int mod = 1000000007, max = 200005;

    public static void main(String[] args) {
        new Thread(null, new Main(), "thread-1", 1024*1024*10).start();
    }

    @Override
    public void run() {
        try{
            solve();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void solve(){
        Scanner cin = new Scanner(System.in);
        int N = Integer.parseInt(cin.nextLine());
        StringBuilder sb = null;
        for(int i=0; i<N; ++i){
            sb = new StringBuilder();
            String source = cin.nextLine();
            //pIsDouble 表示（i-1,i-2）相同，ppIsDouble表示（i-2,i-3）相同
            boolean pIsDouble = false, ppIsDouble = false;
            int n = source.length();
            char pre = ' ';

            for(int j=0; j<n; j++){
                //满足三连不输出
                if(pIsDouble && source.charAt(j) == pre){
                    continue;
                    //满足两对不输出
                }else if(!pIsDouble && ppIsDouble && source.charAt(j) == pre) {
                    continue;
                }else{
                    //所有记录前移
                    ppIsDouble = pIsDouble;
                    if(pre == source.charAt(j)){
                        pIsDouble = true;
                    }else {
                        pIsDouble = false;
                    }
                    pre = source.charAt(j);
                    sb.append(source.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}

