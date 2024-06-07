public class SumofNodes
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
    static int sum=0;
    public static int sumOfnodes(Node root)
    {
        if(root == null)
            return 0;
        sum = sum+root.data;
        sumOfnodes(root.left);
        sumOfnodes(root.right);
        return sum;
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
        System.out.println("Sum of nodes are:  "+sumOfnodes(root));
    }
}
