package tree;

import java.util.*;

public class Main {


    // TC- O(n) , SC- O(H) , where H is height if the tree
    public static void inorderTraverse(Node root)
    {
        // base condition
        if(root==null)
            return;

        inorderTraverse(root.left);
        System.out.print(root.data+" ");
        inorderTraverse(root.right);
    }

    // TC- O(n) , SC- O(H) , where H is height if the tree
    public static void preorderTraverse(Node root)
    {
        // base condition
        if(root==null)
            return;

        System.out.print(root.data+" ");
        preorderTraverse(root.left);
        preorderTraverse(root.right);
    }

    // TC- O(n) , SC- O(H) , where H is height if the tree
    public static void postorderTraverse(Node root)
    {
        // base condition
        if(root==null)
            return;

        postorderTraverse(root.left);
        postorderTraverse(root.right);
        System.out.print(root.data+" ");
    }

    public static void inorderIterativeTraverse(Node root){
        if(root==null)
            return;

        Stack<Node> stack=new Stack<>();
        Node node=root;
        while (true)
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }else {
                if(stack.isEmpty())
                    break;

                Node curNode=stack.pop();
                System.out.print(curNode.data+" ");
                node=curNode.right;
            }
        }
    }

    public static void preorderIterativeTraverse(Node root){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            Node currNode=stack.pop();
            if(currNode.right!=null)
                stack.push(currNode.right);
            if(currNode.left!=null)
                stack.push(currNode.left);
            System.out.print(currNode.data+" ");
        }
    }

    public static void postorderIterativeTraverse(Node root){

        if(root==null)
            return;

        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty())
        {
            Node currNode=stack1.pop();
            stack2.push(currNode);
            if(currNode.left!=null) stack1.push(currNode.left);
            if(currNode.right!=null) stack1.push(currNode.right);
        }

        while (!stack2.isEmpty())
        {
            System.out.print(stack2.pop().data+" ");
        }
    }

    public static void postorderIterativeTraverseOptimal(Node root){
        Stack<Node> stack=new Stack<>();
        Node curr=root;
        while (curr!=null || !stack.isEmpty())
        {
            if(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }
            else {
                Node temp=stack.peek().right;
                if(temp==null)
                {
                    temp=stack.pop();
                    System.out.print(" "+temp.data+" ");
                    while (!stack.isEmpty() && stack.peek().right==temp)
                    {
                        temp=stack.pop();
                        System.out.print(" "+temp.data+" ");
                    }
                }else {
                    curr=temp;
                }
            }
        }
    }



    public static List<Integer>  inorderIterativeTraverse2(Node root)
    {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;

        Stack<Node> stack=new Stack<>();
        Node node=root;
        while (true)
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }else {
                if(stack.isEmpty())
                    break;

                Node currNode=stack.pop();
                list.add(currNode.data);
                node=currNode.right;
            }
        }
        return list;
    }

    public static void preorderIterativeTraverse2(Node root){
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            Node currNode=stack.pop();
            if(currNode.right!=null)
                stack.push(currNode.right);
            if(currNode.left!=null)
                stack.push(currNode.left);
            System.out.print(currNode.data+" ");
        }
    }

    public static void postorderIterativeTraverse2(Node root)
    {
        Stack<Node> stack1=new Stack<>();
        Stack<Node> stack2=new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty())
        {
            Node currNode=stack1.pop();
            stack2.push(currNode);
            if(currNode.left!=null) stack1.push(currNode.left);
            if(currNode.right!=null) stack1.push(currNode.right);
        }

        while (!stack2.isEmpty())
            System.out.print(stack2.pop().data+" ");
    }

    public static void postorderIterativeTraverse3(Node root){
        Stack<Node> stack=new Stack<>();
        Node curr=root;
        while (curr!=null || !stack.isEmpty())
        {
            if(curr!=null)
            {
                stack.push(curr);
                curr=curr.left;
            }else {
                Node temp=stack.peek().right;
                if(temp==null)
                {
                    temp= stack.pop();
                    System.out.print(" "+temp.data);
                    while (!stack.isEmpty() && temp==stack.peek().right)
                    {
                        temp=stack.pop();
                        System.out.print(" "+temp.data);
                    }
                }else
                    curr=temp;
            }
        }
    }

    // TC- O(N) , SC- O(n)
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrderList=new ArrayList<>();
        if (root == null) return levelOrderList;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int queueSize= queue.size();
            List<Integer> levelList=new ArrayList<>();
            for(int i=0;i<queueSize;i++)
            {
                Node currNode=queue.poll();
                levelList.add(currNode.data);

                if(currNode.left!=null)
                    queue.offer(currNode.left);

                if(currNode.right!=null)
                    queue.offer(currNode.right);

            }
            levelOrderList.add(levelList);
        }
        return levelOrderList;
    }

    // TC- O(N) , SC- O(n)
    public static int maxDepth(Node root) {
        int dep=0;
        if(root==null)
            return dep;

        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())
        {
            int curSize=queue.size();
            for(int i=0;i<curSize;i++)
            {
                Node cur=queue.poll();
                if(cur.left!=null) queue.offer(cur.left);
                if(cur.right!=null) queue.offer(cur.right);
            }
                dep++;
        }
        return dep;
    }

    // TC - O(n) , SC- O(H), h=height of the tree
    public static int maxDepthOptimal(Node root) {
        if(root==null)
            return 0;
        int lh=maxDepthOptimal(root.left);
        int rh=maxDepthOptimal(root.right);
        return 1+ Math.max(lh,rh);
    }


    public boolean isBalanced(Node root) {
        if(root==null)
            return true;
        int lefth=height(root.left);
        int righth=height(root.right);
        return Math.abs(lefth-righth)>1?false:true;
    }

    public int height(Node root)
    {
        if(root==null)
            return 0;
        int left=height(root.left);
        int right=height(root.right);

        return 1+ Math.max(left,right);
    }


    public boolean isBalanced2(Node root) {
        return height(root)!=-1;
    }

    public int height2(Node root)
    {
        if(root==null)
            return 0;
        int left=height(root.left);
        if(left==-1)return -1;
        int right=height(root.right);
        if(right==-1)return -1;

        if(Math.abs(left-right)>1)return -1;
        return 1+ Math.max(left,right);
    }

    public static int diameterOfBinaryTree(Node root) {
        if(root==null)
            return 0;

        int lh=height3(root.left);
        int rh=height3(root.right);

        return 1+Math.max(lh, rh);
    }

    static int height3(Node root)
    {
        if(root==null)
            return 0;

        int lh=height3(root.left);
        int rh=height3(root.right);
        return 1+Math.max(lh,rh);
    }

    int diameter=0;
    public int diameterOfBinaryTree2(Node root) {
        calculateDiameter(root);
        return diameter;
    }

    int calculateDiameter(Node root)
    {
        if(root==null)
            return 0;

        int lh=calculateDiameter(root.left);
        int rh=calculateDiameter(root.right);
        diameter=Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
//        root.right=new Node(3);
//
//        root.left.left=new Node(4);
//        root.left.right=new Node(5);
//
//        root.right.left=new Node(6);
//        root.right.right=new Node(7);

        //System.out.println(levelOrder(root));;

        System.out.println(diameterOfBinaryTree(root));

    }
}
