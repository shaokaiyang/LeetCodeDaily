/**
 * @author sky
 * @date 2019/03/05
 * description:画家小Q又开始他的艺术创作。小Q拿出了一块有NxM像素格的画板, 画板初始状态是空白的,用’X’表示。
 *   小Q有他独特的绘画技巧,每次小Q会选择一条斜线, 如果斜线的方向形如’/’,即斜率为1,小Q会选择这条斜线中的一段格子,都涂画为蓝色,用’B’表示;如果对角线的方向形如’\’,即斜率为-1,小Q会选择这条斜线中的一段格子,都涂画为黄色,用’Y’表示。
 *   如果一个格子既被蓝色涂画过又被黄色涂画过,那么这个格子就会变成绿色,用’G’表示。
 *   小Q已经有想画出的作品的样子, 请你帮他计算一下他最少需要多少次操作完成这幅画。
 * input:每个输入包含一个测试用例。
 *   每个测试用例的第一行包含两个正整数N和M(1 <= N, M <= 50), 表示画板的长宽。
 *   接下来的N行包含N个长度为M的字符串, 其中包含字符’B’,’Y’,’G’,’X’,分别表示蓝色,黄色,绿色,空白。整个表示小Q要完成的作品。
 * output:输出一个正整数, 表示小Q最少需要多少次操作完成绘画。
 * solution：通过上面的求解步骤，我们很容易找出解题思路：从上往下，从左往右遍历画板像素，根据当前像素的类型与其左上和右上的类型判断操作次数增加值。
 */

import java.util.Scanner;

public class PainterQ {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n, m, sum = 0;
       String temp = scanner.nextLine();
       n = Integer.valueOf(temp.split(" ")[0]);
       m = Integer.valueOf(temp.split(" ")[1]);
        char[][] str = new char[51][51];

        for(int i = 0; i < n; i++){
            temp = scanner.nextLine();
            for(int j = 0; j < temp.length(); j++){
                str[i][j] = temp.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(str[i][j] == 'B'){
                    //对于斜率为1的线来说，若B出现在第一行或者最后一列都需要单独划线；如果B出现在中间，其右上如果不是B或G的时候需要划线；
                    if(i ==0 || j == m-1 || (str[i-1][j+1] != 'B' && str[i-1][j+1] != 'G')){
                        sum++;
                    }
                }else if (str[i][j] == 'Y'){
                    //对于斜率为-1的线来说，若Y出现在第一行或者第一列都需要单独划线；如果Y出现在中间，其左上如果不是B或者G的时候需要划线；
                    if(i == 0 || j == 0 || (str[i-1][j-1] != 'Y' && str[i-1][j-1] != 'G')){
                        sum++;
                    }
                }else if (str[i][j] == 'G'){
                    //如果G出现在第一行需要划两条线
                    if(i == 0){
                        sum += 2;
                        continue;
                    }
                    //如果G出现在第一列，那么只可能画斜率为-1的线，且只能画一条
                    //如果G出现在最后一列，那么只可能画斜率为1的线，且只能画一条
                    if(j == 0 || j == m-1){
                        sum++;
                    }
                    //如果在中间，左上不为G或者Y时需要加1；或者右上不为G或者B时需要加1
                    if(j > 0 && j < m-1 && ((str[i-1][j-1] != 'Y' && str[i-1][j-1] != 'G') || (str[i-1][j+1] != 'B' && str[i-1][j+1] != 'G'))){
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }

}
