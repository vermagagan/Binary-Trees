public class MirrorTree
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
    public static Node mirrorTree(Node root)
    {
        if(root == null)
            return root;
        Node left = mirrorTree(root.left);
        Node right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
        
    }
    public static void inOrder(Node root)
    {
        if(root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data+"  ");
        inOrder(root.right);
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        inOrder(root);
        Node root2=mirrorTree(root);
        System.out.println();
        inOrder(root2);
    }
}
