import java.util.LinkedList;
import java.util.Queue;

public class Binarytree
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
    //binarytree subclass
    static class binarytrees
    {
        static int idx=-1; //to keep the count of nodes
        //Buildtree
        public Node buildtree(int nodes[])
        {
            idx++;
            if(nodes[idx] == -1)
                return null;
            Node Newnode=new Node(nodes[idx]);
            Newnode.left = buildtree(nodes);
            Newnode.right = buildtree(nodes);
            return Newnode;
        }
        //preorderwe
        public void preOrder(Node root)
        {
            if(root == null)
                return;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
        //inorder
        public void inOrder(Node root)
        {
            if(root == null)
                return;
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
        //postorder
        public void postOrder(Node root)
        {
            if(root == null)
                return;
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
        public void levelOrder(Node root)
        {
            if(root == null)
                return;

            Queue<Node> q=new LinkedList<>();
            q.add(root);
            while(!q.isEmpty())
            {
                int levelSize = q.size();

                for(int i=0; i<levelSize; i++)
                {
                    Node curr=q.poll();
                    System.out.print(curr.data+"  ");
                    if(curr.left != null)
                        q.add(curr.left);
                    if(curr.right != null)
                        q.add(curr.right);
                }
                System.out.println();
            }
        }
    }
    
    //main
    public static void main(String[] args)
    {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        binarytrees bt=new binarytrees();
        Node root = bt.buildtree(nodes);
        bt.preOrder(root);
        System.out.println();
        bt.inOrder(root);
        System.out.println();
        bt.postOrder(root);
        System.out.println();
        bt.levelOrder(root);
    }
}