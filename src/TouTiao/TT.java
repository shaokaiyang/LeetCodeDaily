import java.util.*;
public class TT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int maxScore = 0;
        int tmp = 0;
        int[] score = new int[n];
        for(int i = 0; i < n; i++){
            score[i] = in.nextInt();
        }
//        for(int i = 0; i < n -1; i++){
//            for(int j = i + 1; j < n; j++){
//                tmp = score[i] + score[j] + i - j;
//                if(tmp > maxScore){
//                    maxScore = tmp;
//                }
//            }
//        }
        // int[] maxLeft = new int[n];
        int maxLeftScore = score[0];
        //
//        for(int i = 0; i < n; i++){
//            tmp = score[i] + i;
//            if(tmp > maxLeftScore){
//                maxLeft[i] = tmp;
//                maxLeftScore = tmp;
//            }else{
//                maxLeft[i] = maxLeftScore;
//            }
//        }
        // System.out.println(maxLeft.toString());
        for(int i = 1; i < n; i++){
            tmp = maxLeftScore + score[i] - i;
            if(tmp > maxScore){
                maxScore = tmp;
            }
            if(score[i] + i > maxLeftScore){
                maxLeftScore = score[i] + i;
            }
        }

        System.out.println(maxScore);
    }
}