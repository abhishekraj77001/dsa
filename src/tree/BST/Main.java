package tree.BST;


import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static Node sortedArrayToBST(int[] nums) {
        return constructBST(nums,0,nums.length-1);
    }

    static Node constructBST(int[] nums,int left,int right)
    {
       if(left>right)
           return null;

       int mid=(left+right)/2;
       Node root=new Node(nums[mid]);
       root.left=constructBST(nums,left,mid-1);
        root.right=constructBST(nums,mid+1,right);

       return root;
    }

    public static void levelOrderTraversal(Node root)
    {
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                Node currNode=queue.poll();
                System.out.print(" "+currNode.data+" ");
                if(currNode.left!=null) queue.offer(currNode.left);
                if(currNode.right!=null) queue.offer(currNode.right);
            }
            System.out.println();
        }
    }

    // TC - O(log n) , SC- O(log n) or O(H) , height of the tree
    public Node searchBST(Node root, int val) {
        if(root==null)
            return null;

        if(root.data>val)
            return searchBST(root.left,val);
        else if(root.data<val)
            return searchBST(root.right,val);
        else
            return root;
    }

    public static int minValue(Node root) {
        // Write your code here.
        if(root==null)
            return -1;
        while(root.left!=null)
            root=root.left;

        return root.data;
    }

    public static void main(String[] args) {

        Node root=sortedArrayToBST(new int[]{-10,-3,0,5,9});
        levelOrderTraversal(root);

    }

}
