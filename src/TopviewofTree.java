import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
public class TopviewofTree
{
    static class Node
    {
        int data;
        Node left,right;
        public Node(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class Info
    {
        Node currnode;
        int horidist;
        public Info(Node currnode, int horidist)
        {
            this.currnode=currnode;
            this.horidist=horidist;
        }
    }
    public static void topView(Node root)
    {
        Queue<Info> q=new LinkedList<>();
        HashMap<Integer, Node>map=new HashMap<>();
        int min=0,max=0;
        q.add(new Info(root, 0));
        q.add(null);
        while(!q.isEmpty())
        {
            Info currInfo = q.remove();
            if(currInfo == null)
            {
                if(q.isEmpty())
                    break;
                else
                    q.add(null);
            }
            else
            {
                if(!map.containsKey(currInfo.horidist))
                    map.put(currInfo.horidist,currInfo.currnode);
                if(currInfo.currnode.left != null)
                {
                    q.add(new Info(currInfo.currnode.left, currInfo.horidist-1));
                    min = Math.min(min, currInfo.horidist-1);
                }
                if(currInfo.currnode.right != null)
                {
                    q.add(new Info(currInfo.currnode.right, currInfo.horidist+1));
                    max=Math.max(max, currInfo.horidist+1);
                }
            }
        }
        for(int i=min;i<=max;i++)
        {
            System.out.print(map.get(i).data+"  ");
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

        topView(root);
    }
}
