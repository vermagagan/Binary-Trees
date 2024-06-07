public class Minpossibledistance
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
    public static int mindist(Node root, int n1, int n2)
    {
        Node lca = lca(root, n1, n2);
        int dist1 = lcadist(lca, n1);
        int dist2 = lcadist(lca, n2);

        return dist1+dist2+1;
    }
    public static Node lca(Node root, int n1, int n2)
    {
        if(root == null || root.data == n1 || root.data == n2)
            return root;

        Node foundleft = lca(root.left, n1, n2);
        Node foundright = lca(root.right, n1, n2);
        if(foundleft == null)
            return foundright;
        if(foundright == null)
            return foundleft;
        
        return root;
    }
    public static int lcadist(Node root, int n)
    {
        if(root == null)
            return -1;
        if(root.data == n)
            return 0;
        int foundleft = lcadist(root.left, n);
        int foundright = lcadist(root.right, n);
        if(foundleft == -1 && foundright == -1)
            return -1;

        else if(foundleft == -1)
            return foundright+1;

        else
            return foundleft+1;
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
        int n1=4,n2=7;
        System.out.println("Minimum distance between the Nodes is: "+mindist(root, n1, n2));
    }
}
