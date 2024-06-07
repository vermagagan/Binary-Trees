public class DiameterofTree
{
    //Node class
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
    //Info Class
    static class  Info
    {
        int dia,ht;
        public Info(int dia, int ht)
        {
            this.dia=dia;
            this.ht=ht;
        }
    }
    public static Info diameter(Node root)
    {
        if(root == null)
            return new Info(0, 0);
        Info left = diameter(root.left);
        Info right = diameter(root.right);
        int diam = Math.max(Math.max(left.dia, right.dia), left.ht+right.ht+1);
        int height = Math.max(left.ht,right.ht)+1;
        return new Info(diam, height);
    }
    public static void main(String[] args)
    {
        Node root=new Node(1);
        root.left=new Node(0);
        root.left.left=new Node(4);
        root.right=new Node(3);
        System.out.println("Diameter of tree is: "+diameter(root).dia);
    }

}
