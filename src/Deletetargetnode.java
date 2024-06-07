public class Deletetargetnode
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
    public static void inOrder(Node root)
    {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+"  ");
        inOrder(root.right);
    }
    public static void deleteTarget(Node root,int target)//Traversing the Targets here
    {
        if(root == null)
            return;
        
        Node parent=root;
        deleteTarget(root.left, target);
        deleteTarget(root.right, target);
        Boolean left=isTarget(root.left, target);
        Boolean right=isTarget(root.right, target);
        if(left)
            parent.left = null;
        if(right)
            parent.right = null;
    }
    public static Boolean isTarget(Node root, int target)//Finding the targe
    {
        if(root == null)
            return true;
        
        if(root.data == target && root.left == null && root.right == null)
            return true;
        return false;
    }
    public static void preOrder(Node root)
    {
        if(root == null)
            return;
        System.out.print(root.data+"  ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        inOrder(root);
        System.out.println();
        int target = 3;
        deleteTarget(root, target);
        inOrder(root);
        System.out.println();
        preOrder(root);
    }
}
