public class KthlevelTree
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void KthlevelofTree(Node root, int k,int level)
    {
        if(root == null)
            return;
        if(level == k)
            System.out.print(root.data+"  ");
        KthlevelofTree(root.left, k, level+1);
        KthlevelofTree(root.right, k, level+1);
    }
    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(6);
        root.left.right = new Node(4);
        root.right = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(0);
        int k=2;
        KthlevelofTree(root, k ,0);
    }
}
