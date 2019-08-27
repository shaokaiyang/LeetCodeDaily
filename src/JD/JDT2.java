import java.util.*;

/**
 * 思路：构建一个图，根据每个点的度数进行剔除；
 * 根据度数从大到小的顺序剔除，如果遇到度数相同的优先剔除男生；
 */
public class JDT2 {
    static class Person{
        int id;
        int cnt;
        List<Integer> list = new ArrayList<>();
        public void setId(int id){
            this.id = id;
        }
        public void setCnt(int cnt){
            this.cnt = cnt;
        }
        public void setList(int n){
            this.list.add(n);
        }
        public List getList(){
            return this.list;
        }
        public int getId(){
            return this.id;
        }
        public int getCnt(){
            return this.cnt;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Person[] people = new Person[2*n+1];
        for(int i = 1; i <= 2*n; i++){
            people[i].setId(i);
            people[i].setCnt(0);
        }
        for(int i = 0; i < m; i ++){
            int tmp1 = in.nextInt();
            int tmp2 = in.nextInt();
            people[tmp1].setCnt(people[tmp1].getCnt()+1);
            people[tmp1].setList(tmp2);
            people[tmp2].setCnt(people[tmp2].getCnt()+1);
            people[tmp2].setList(tmp1);
        }

        List<Integer> result = new ArrayList<>();
        int max = 1;
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getCnt() - o1.getCnt();
            }
        });


    }
}
