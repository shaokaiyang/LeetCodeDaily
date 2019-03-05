/**
 * @author sky
 * @date 2019/03/05
 * description:小Q的公司最近接到m个任务, 第i个任务需要xi的时间去完成, 难度等级为yi。
 *   小Q拥有n台机器, 每台机器最长工作时间zi, 机器等级wi。
 *   对于一个任务,它只能交由一台机器来完成, 如果安排给它的机器的最长工作时间小于任务需要的时间, 则不能完成,如果完成这个任务将获得200 * xi + 3 * yi收益。
 *   对于一台机器,它一天只能完成一个任务, 如果它的机器等级小于安排给它的任务难度等级, 则不能完成。
 *   小Q想在今天尽可能的去完成任务, 即完成的任务数量最大。如果有多种安排方案,小Q还想找到收益最大的那个方案。小Q需要你来帮助他计算一下。
 * input:输入包括N + M + 1行,
 *   输入的第一行为两个正整数n和m(1 <= n, m <= 100000), 表示机器的数量和任务的数量。
 *   接下来n行,每行两个整数zi和wi(0 < zi < 1000, 0 <= wi <= 100), 表示每台机器的最大工作时间和机器等级。
 *   接下来的m行,每行两个整数xi和yi(0 < xi < 1000, 0 <= yi<= 100), 表示每个任务需要的完成时间和任务的难度等级。
 * output:输出两个整数, 分别表示最大能完成的任务数量和获取的收益。
 * solution:首先，我们将这些数据存储在数组里，然后进行降序排序，为什么要进行排序呢？
 * 为了避免之后选择时复杂的判断，或者出现田忌赛马这样的事情；当对其进行排序之后，一切都变得简单了，
 * 我们只需要顺序的为每一个机器选择效益最大的那个任务，而且这时候，我们能够肯定， 当前任务之后，
 * 再没有比它更好的选择了（对其进行降序排序的好处，当然，我们对其等级先降序排序，再对其耗费时间进行降序排序）。
 *
 * 在对任务进行分配的时候，针对一个任务，首先找出在时间上能够完成这个任务的所有机器，并把这些机器按照他们的优先级进行分组；
 * 然后从任务的优先级开始寻找与其优先级最接近的机器，将任务分配到此机器上。这样做能够保证任务和机器在优先级上的最大匹配（优先级差别小）
 * 避免田忌赛马的情况出现，使得利益最大。并且在选择任务的时候优先选择时间多的任务，在时间相等时优先选择优先级大的任务，才能保证利益最大；
 * 因此提前需要对机器和任务按照时间进行降序排序。
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class MachineArrangement {
    //内部类用于记录机器和任务的性质
    static class Pair{
        int time;
        int diff;
        public Pair(int time, int diff){
            super();
            this.time = time;
            this.diff = diff;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int machineNumber = scanner.nextInt();
            int taskNumber = scanner.nextInt();
            Pair[] machines = new Pair[machineNumber];
            Pair[] tasks = new Pair[taskNumber];
            for(int i = 0; i < machineNumber; i++){
                machines[i] = new Pair(scanner.nextInt(),scanner.nextInt());
            }
            for(int i = 0; i < taskNumber; i++){
                tasks[i] = new Pair(scanner.nextInt(), scanner.nextInt());
            }
            //比较函数
            Comparator<Pair> cmp = new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    if(o1.time == o2.time){
                        return o2.diff - o1.diff;  //降序排序
                    }else{
                        return o2.time - o1.time;  //降序排序
                    }
                }
            };

            Arrays.sort(machines, cmp);
            Arrays.sort(tasks, cmp);
            long sum = 0;
            int count = 0;
            int j = 0;
            int[] dp = new int[101];
            for(int i = 0; i < taskNumber; i++){
                //记录所有在时间层面能够完成该任务的机器，并按照机器的优先级进行分组
                while(j < machineNumber && machines[j].time >= tasks[i].time){
                    dp[machines[j].diff]++;
                    j++;
                }
                //在能够按时完成该任务的机器中选择与该任务优先级最接近的机器来完成
                for(int k = tasks[i].diff; k < 101; k++ ){
                    if(dp[k] !=0){
                        dp[k]--;
                        sum += 200 * tasks[i].time + 3 * tasks[i].diff;
                        count ++;
                        break;
                    }
                }
            }
            System.out.println(count + " " + sum);
        }
        scanner.close();
        }
    }




