
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class SameGrandfather {

    public static TreeNode sameGrandfather(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = sameGrandfather(root.left, p, q);
        TreeNode right = sameGrandfather(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

    public static TreeNode sameGrandfather2(TreeNode root, TreeNode p, TreeNode q){
       int min, max;
       if(p.val < q.val){
           min = p.val;
           max = q.val;
       }else {
           min = q.val;
           max = p.val;
       }
        if(root == null || (root.val < max && root.val > min)){
            return root;
        }
        if(root.val > max){
            return sameGrandfather2(root.left, p, q);
        }else{
            return sameGrandfather2(root.right, p, q);
        }
    }

    public  static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        TreeNode result = sameGrandfather2(root, root.left.left, root.left.right);
        System.out.println(result.val);
    }
}
