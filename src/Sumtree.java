public class Sumtree
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
    public static int sumTree(Node root)
    {
        if(root == null)
            return 0;

        int left=sumTree(root.left);
        int right=sumTree(root.right);
        int totalLeft = (root.left == null) ? 0: root.left.data;
        int totalRight = (root.right == null) ? 0: root.right.data;
        int temp = root.data;
        root.data = left+right+totalLeft+totalRight;
        return temp;
    }
    public static void preOrder(Node root)
        {
            if(root == null)
                return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
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
        System.out.println("The Sum tree is:  ");
        sumTree(root);
        preOrder(root);
    }
}
