import java.util.LinkedList;
import java.util.Queue;
public class PrintKthlevel
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
    public static void printKthlevel(Node root, int k)
    {
        int level=0;
        if(root == null)
                return;
            Queue <Node> q=new LinkedList<>();
            q.add(root);
            //q.add(null);
            while(!q.isEmpty())
            {
                Node currnode=q.remove();
                if(currnode == null)
                {
                    level++;
                    System.out.println();
                    if(q.isEmpty())
                        break;
                }
                else
                {
                    q.add(null);
                    if(level == k)
                        System.out.print(currnode.data+"  ");
                    if(currnode.left != null)
                        q.add(currnode.left);
                    if(currnode.right != null)
                        q.add(currnode.right);
                }
            }
        }
    public static void main(String[] args)
    {
        Node root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(2);
        root.left.left=new Node(3);
        root.left.right=new Node(4);
        root.right.left=new Node(5);
        root.right.right=new Node(6);

        int k=2;
        printKthlevel(root, k);
    }
}
