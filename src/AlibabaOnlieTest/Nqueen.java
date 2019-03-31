class Nqueen {

    int count=0;

    public int totalNQueens(int n) {

        DFS(0,0,0,0,n);
        return count;

    }

    public void DFS(int row, int col, int pie, int na,int n){
        if(row>=n){
            count++;
            return ;
        }
        int bits = (~(col|pie|na))&((1<<n)-1);
        while(bits>0){
            int p = bits & -bits;
            DFS(row+1, (col|p),(pie|p)<<1, (na|p)>>1,n);
            bits &= bits-1;
        }
    }

    public static void main(String[] args){
        Nqueen nqueen = new Nqueen();
        long start = System.currentTimeMillis();
        int num = nqueen.totalNQueens(8);
        System.out.println(num);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

