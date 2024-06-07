public class Univalued
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
    public static Boolean uniValued(Node root)
    {
        Node temp=root;
        if(root == null)
            return true;

        if(root.left != null&& root.left.data != temp.data)
            return false;
        uniValued(root.left);
        if(root.right != null && root.right.data != temp.data)
            return false;
        uniValued(root.right);
        return true;
        
    }
    public static void main(String[] args)
    {
        Node root=new Node(0);
        root.left=new Node(0);
        root.right=new Node(0);
        root.left.left=new Node(0);
        root.left.right=new Node(0);
        root.right.left=new Node(0);
        root.right.right=new Node(0);
        System.out.println(uniValued(root));
    }
}
