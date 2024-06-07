public class HeightofTree
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
    public static int heightTree(Node root)
    {
        if(root == null)
            return 0;
        int lh=heightTree(root.left);
        int rh=heightTree(root.right);
        return Math.max(lh,rh)+1;
    }
    public static void main(String args[])
    {
        Node root=new Node(1);
        root.left=new Node(0);
        root.left.left=new Node(4);
        root.right=new Node(3);
        System.out.println("Height of tree is: "+heightTree(root));
    }
}
