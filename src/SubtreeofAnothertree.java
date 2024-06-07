public class SubtreeofAnothertree
{
    static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    public static Boolean isIdentical(Node root, Node sroot)
    {
        if(root == null && sroot == null)
            return true;
        else if(root == null || sroot == null || root.data != sroot.data)
            return false;
        if(!isIdentical(root.left, sroot.left))
            return false;
        if(!isIdentical(root.right, sroot.right))
            return false;
        return true;
    }
    public static Boolean isSubtree(Node root, Node sroot)
    {
        if(root == null)
            return false;
        if(root.data == sroot.data)
        {
            if(isIdentical(root, sroot))
                return true;
        }
        Boolean left=isSubtree(root.left, sroot);
        Boolean right=isSubtree(root.right, sroot);
        return left || right;
    }
    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

        Node sroot = new Node(2);
        sroot.left = new Node(4);
        sroot.right = new Node(5);
        System.out.println(isSubtree(root, sroot));
    }
}
