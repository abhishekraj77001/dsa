package linkedlist;

import java.util.Arrays;
import java.util.HashSet;

public class LinkedList {

    Node head;

    // TC- BC-O(1), WC- O(N), SC- O(1)
    void add(int data)
    {
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }

        Node temp=head;
        while (temp.next!=null)
            temp=temp.next;

        temp.next=newNode;
    }

    // TC- O(1) , SC- O(1)
    void addFirst(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }

        newNode.next=head;
        head=newNode;
    }

    void addLast(int data)
    {
        // Logic will be same as add()
        add(data);
    }

    // TC- BC-O(1), A-WC- O(n) , SC- O(1)
    void remove(int data)
    {
        if (head==null)
            return;

        if (head.data==data)
        {
            head=head.next;
            return;
        }

        Node prev=null;
        Node curr=head;
        while (curr.next!=null)
        {
            if(curr.data==data)
            {
                prev.next=curr.next;
                return;
            }
            prev=curr;
            curr=curr.next;
        }

        if (curr.data==data)
            prev.next=null;
    }


    // TC- O(1), SC- O(1)
    void removeFirst()
    {
        if (head==null)
            return;

        if (head.next==null)
        {
            head=null;
            return;
        }

        head=head.next;
    }

    // TC- BC-O(1), O(n), SC- O(1)
    void removeLast()
    {
        if (head==null)
            return;

        if (head.next==null)
        {
            head=null;
            return;
        }

        Node prev=null;
        Node curr=head;
        while (curr.next!=null)
        {
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
    }

    // TC - O(n) , SC- O(1)
    int length(Node head)
    {
        Node temp=head;
        int count=0;
        while (temp!=null)
        {
            count++;
            temp=temp.next;
        }

        return count;
    }

    // Only if the length is Even
    // TC- O(log n) , SC - O(1)
    int lengthOptimal(Node head)
    {
        if(head==null)
            return 0;

        if(head.next==null)
            return 1;

        Node fast=head;
        int count=0;
        while (fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            count++;
        }

        return count*2;
    }

    // TC - O(N) + O(n/2)= O(N) , SC- O(1)
    int getMiddleElement(Node head)
    {
        // 1 2 3 4 5 6
        // m= 6/2 = 3, m+1
        int len= length(head);
        int mid=(len/2)+1;
        int count=0;
        Node temp=head;
        while (temp.next!=null)
        {
            count++;
            if (count==mid)
                return temp.data;

            temp=temp.next;
        }
        return -1;
    }


    // TC- O(log n) , SC- O(1)
    int getMiddleElementOptimal(Node head)
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }


    // TC- O(n) , SC- O(1)
    Node reverse()
    {
        if(head==null)
            return head;

        if(head.next==null)
            return head;

        Node prev=null,next;
        Node curr=head;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    // TC- O(n) , SC- O(n)
    Node reverseRecursive(Node head)
    {
        if(head==null || head.next==null)
            return head;

        Node revHead= reverseRecursive(head.next);

        head.next.next=head;
        head.next=null;

        return revHead;
    }

    // TC- O(n) , SC- O(n/k)
    Node reverseInKthGroup(Node head,int k)
    {
        int len=length(head);
        if (len<k)
            return head;

        int count=0;
        Node prev=null,next;
        Node curr=head;
        while (count<k)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        head.next=reverseInKthGroup(curr,k);
        return prev;
    }

    // TC- O(n)+ O(n-n)=O(n) , SC-  O(1)
    Node removeNthNodeFromEnd(Node head,int n)
    {
        if (head==null || head.next==null)
            return head;

        int len=length(head);

        if (len==n)
        {
            head=head.next;
            return head;
        }

        int preNode=len-n;
        Node temp=head;
        while (preNode>1)
        {
            temp=temp.next;
            preNode--;
        }

        temp.next=temp.next.next;

        return head;
    }

    // TC- O(n) , SC-O(n)
    boolean detectCycle(Node head)
    {
        HashSet<Node> dataSet=new HashSet<>();
        while (head!=null)
        {
            if(dataSet.contains(head))
                return true;

            dataSet.add(head);
            head=head.next;
        }
        return false;
    }

    // TC- O(n) , SC-O(1)
    boolean detectCycleOptimal(Node head)
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null)
        {
          slow=slow.next;
          fast=fast.next.next;

            if(fast==slow)
                return true;
        }
        return false;
    }

    // TC- O(n) , SC- O(n)
    Node getStartingPointOfCycle(Node head)
    {
        HashSet<Node> dataSet=new HashSet<>();
        while (head!=null)
        {
            if(dataSet.contains(head))
                return head;

            dataSet.add(head);
            head=head.next;
        }

        return null;
    }

    // TC- O(n) , SC- O(1)
    Node getStartingPointOfCycleOptimal(Node head)
    {
        Node slow=head;
        Node fast=head;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                break;
        }

        if (slow!=fast)
            return null;

        slow=head;
        while (slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
        }

        return slow;
    }

    // TC - O(n) , SC - O(1)
    int lengthOfCycleIfExists(Node head)
    {
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null)
        {
                slow=slow.next;
                fast=fast.next.next;

                if(slow==fast)
                    break;
        }

        if (slow!=fast)
            return 0;

        int count=1;
        slow=fast.next;
        while (slow!=fast)
        {
            slow=slow.next;
            count++;
        }

        return count;
    }

    // TC - O(n) , SC- O(1)
    void removeLoop(Node head)
    {
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                break;
        }

        if (slow!=fast)
            return;
        else {
            slow=head;
            if(slow==fast)
            {
                while (fast.next!=slow)
                    fast=fast.next;

                fast.next=null;
            }else {
                while (fast.next!=slow.next)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                fast.next=null;
            }
        }
    }


    // TC- O(n) , SC- O(1)
    void removeDuplicateFromSortedLL(Node head)
    {
       while (head!=null && head.next!=null)
       {
           if(head.data==head.next.data)
           {
               head.next=head.next.next;
           }else
               head=head.next;
       }
    }

    // TC- O(n), SC- O(n)
    void removeDuplicateFromUnSortedLL(Node head){
        if(head==null || head.next==null)
            return;

        HashSet<Integer> dataSet=new HashSet<>();
        Node prev=null;
        Node curr=head;
        while (curr!=null)
        {
            if(dataSet.contains(curr.data))
            {
                prev.next=curr.next;
                curr=curr.next;
            }else {
                prev=curr;
                dataSet.add(curr.data);
                curr=curr.next;
            }
        }
    }

    // TC- O(n) + o(n) + o(n log n) + o(n) = O(3n)+ O(n log n)= O(n)+O(n log n)= O(n), SC - O(1)
    void sortLL(Node head)
    {
        int len=length(head);
        int[] arr=new int[len];
        int index=0;
        Node temp=head;
        while (temp!=null)
        {
            arr[index++]=temp.data;
            temp=temp.next;
        }
        Arrays.sort(arr);
        Node dummyNode=new Node(-1);
        Node headRef=dummyNode;
        for (int data:arr)
        {
            headRef.next=new Node(data);
            headRef=headRef.next;
        }
        this.head=dummyNode.next;
    }

    // TC- O(n) + o(n) + o(n log n) + o(n) = O(3n)+ O(n log n)= O(n)+O(n log n)= O(n), SC - O(1)
    void sortLLUsingMergeSort(Node head)
    {
        int len=length(head);
        int[] arr=new int[len];
        int index=0;
        Node temp=head;
        while (temp!=null)
        {
            arr[index++]=temp.data;
            temp=temp.next;
        }
        mergeSort(arr,0,arr.length-1);
        Node dummyNode=new Node(-1);
        Node headRef=dummyNode;
        for (int data:arr)
        {
            headRef.next=new Node(data);
            headRef=headRef.next;
        }
        this.head=dummyNode.next;
    }

    void mergeSort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,high,mid);
        }
    }

    void merge(int[] arr,int low,int high,int mid)
    {
        int leftArraySize=(mid-low)+1;
        int rightArraySize=high-mid;

        int[] leftArr=new int[leftArraySize];
        int[] rightArr=new int[rightArraySize];

        int k=low;
        for (int i=0;i<leftArraySize;i++)
            leftArr[i]=arr[k++];

        k=mid+1;
        for (int i=0;i<rightArraySize;i++)
            rightArr[i]=arr[k++];

        int leftIndex=0,rightIndex=0,mainArrIndex=low;

        while (leftIndex<leftArraySize && rightIndex<rightArraySize)
        {
            if(leftArr[leftIndex]<rightArr[rightIndex])
                arr[mainArrIndex++]=leftArr[leftIndex++];
            else
                arr[mainArrIndex++]=rightArr[rightIndex++];
        }

        while (leftIndex<leftArraySize)
                arr[mainArrIndex++]=leftArr[leftIndex++];

        while (rightIndex<rightArraySize)
                arr[mainArrIndex++]=rightArr[rightIndex++];
    }

    Node sortLLUsingMergeSortWithoutArray(Node head){

        if(head==null || head.next==null)
            return head;

        Node middleNode=getMiddle(head);
        Node rightHead=middleNode.next;
        middleNode.next=null;

        head=sortLLUsingMergeSortWithoutArray(head);
        rightHead=sortLLUsingMergeSortWithoutArray(rightHead);

        return mergeList(head,rightHead);
    }

    Node getMiddle(Node head)
    {
        Node slow=head;
        Node fast=head.next;

        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    Node mergeList(Node leftHead,Node rightHead)
    {
        Node dummyNode=new Node(-1);
        Node tailNode=dummyNode;

        while (leftHead!=null && rightHead!=null)
        {
            if(leftHead.data<rightHead.data)
            {
                tailNode.next=leftHead;
                leftHead=leftHead.next;
            }
            else
            {
                tailNode.next=rightHead;
                rightHead=rightHead.next;
            }
            tailNode=tailNode.next;
        }

        if(leftHead!=null)
            tailNode.next=leftHead;

        if(rightHead!=null)
            tailNode.next=rightHead;

        return dummyNode.next;
    }


    // TC- O(n), SC- O(1)
    Node removeListElements(Node head,int k)
    {
        if(head==null)
            return head;

        if(head.next==null && head.data==k)
            return null;

        if(head.next==null && head.data!=k)
            return head;

        Node prev=null;
        Node curr=head;

        while (curr!=null)
        {
            if(curr.data==k)
            {
                if(curr==head)
                {
                    head=head.next;
                }else {
                    prev.next=curr.next;
                }
            }else
                prev=curr;

            curr=curr.next;
        }
        return head;
    }

    // TC- O(n) , SC- O(n)
    Node removeListElementsRecursive(Node head,int k){

        if(head==null)
            return head;

        head.next =removeListElementsRecursive(head.next,k);
        if(head.data==k)
            return head.next;
        else
            return head;
    }

    public static Node mergeKLists(Node[] lists) {

        Node mergedList=mergeTwoList(lists[0],lists[1]);
        for(int i=2;i<lists.length;i++)
        {
            mergedList=mergeTwoList(mergedList,lists[i]);
        }
        return mergedList;
    }

    private static Node mergeTwoList(Node list1,Node list2)
    {
        Node dummyNode=new Node(-1);
        Node tailNode=dummyNode;

        while(list1!=null && list2!=null)
        {
            if(list1.data<list2.data)
            {
                tailNode.next=list1;
                list1=list1.next;
            }else
            {
                tailNode.next=list2;
                list2=list2.next;
            }
            tailNode=tailNode.next;
        }

        if(list1!=null)
            tailNode.next=list1;


        if(list2!=null)
            tailNode.next=list2;

        return dummyNode.next;
    }

    // TC- O(n) + O(n) + O(n/2) = O(2n)+ O(n/2)= O(n), SC- O(n)
    boolean isLinkedListIsPalindrome(Node head)
    {

        int length=length(head);
        int[] arr=new int[length];

        Node temp=head;
        for(int i=0;i<length;i++)
        {
            arr[i]=temp.data;
            temp=temp.next;
        }

        int low=0,high=length-1;
        while (low<high)
        {
            if(arr[low]!=arr[high])
                return false;

            low++;
            high--;
        }

        return true;
    }

    // TC - O(n) + O(n/2) + O(n/2) = O(n) + O(n) = O(n), SC- O(1)
    boolean isLinkedListIsPalindromeOptimal(Node head){

        if(head==null || head.next==null)
            return false;

        // Get Middle
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
            // 1 2 1 2
        Node rightHead=slow.next;
        Node prev=null,next;
        Node curr=rightHead;
        while (curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node temp=head;
        while (prev!=null)
        {
            if(temp.data!=prev.data)
                return false;

            temp=temp.next;
            prev=prev.next;
        }
        return true;
    }

    // TC- O(n) , SC- O(n)
    Node sort0s1s2s(Node head)
    {

        int zero=0;
        int one=0;
        int two=0;

        Node temp=head;
        while (temp!=null)
        {
            switch (temp.data){
                case 0:
                    zero++; break;
                case 1:
                    one++; break;
                case 2:
                    two++; break;
            }
            temp=temp.next;
        }

        Node dummyNode=new Node(-1);
        Node tailNode=dummyNode;

        while (zero>0)
        {
            tailNode.next=new Node(0);
            tailNode=tailNode.next;
            zero--;
        }

        while (one>0)
        {
            tailNode.next=new Node(1);
            tailNode=tailNode.next;
            one--;
        }

        while (two>0)
        {
            tailNode.next=new Node(2);
            tailNode=tailNode.next;
            two--;
        }

        return dummyNode.next;
    }


    // TC - O(n+m) + O(n+m) = O(N+M), SC- O(1)
    Node addTwoNumber(Node list1,Node list2)
    {
        Node revList1=reverseRecursive(list1);
        Node revList2=reverseRecursive(list2);
        Node dummpNode=new Node(-1);
        Node tailNode=dummpNode;

        int carry=0;
        while (revList1!=null || revList2!=null || carry!=0)
        {
            int val1=revList1!=null?revList1.data:0;
            int val2=revList2!=null?revList2.data:0;

            int sum= val1+val2+carry;
            carry=sum/10;
            tailNode.next=new Node(sum%10);
            tailNode=tailNode.next;

            if(revList1!=null)
                revList1=revList1.next;

            if(revList2!=null)
                revList2=revList2.next;
        }

        return dummpNode.next;
    }

    // TC- O(n) , SC- O(1)
    Node oddEventLL(Node head)
    {

        if(head==null || head.next==null)
            return head;

        Node oddNode=new Node(-1);
        Node tailOddNode=oddNode;
        Node evenNode=new Node(-1);
        Node tailEvenNode=evenNode;

        int c=1;
        while (head!=null)
        {
            if(c%2==1)
            {
                tailOddNode.next=head;
                tailOddNode=tailOddNode.next;
            }else {
                tailEvenNode.next=head;
                tailEvenNode=tailEvenNode.next;
            }
            head=head.next;
            c++;
        }
        tailEvenNode.next=null;
        tailOddNode.next=evenNode.next;

        return oddNode.next;
    }

    // TC- O(n) , SC- O(1)
    public Node oddEvenListV2(Node head){
        if(head==null || head.next==null)
            return head;

        Node oddNode=head;
        Node evenNode=head.next;
        Node evenHead=evenNode;

        while (evenNode!=null && evenNode.next!=null)
        {
            oddNode.next=evenNode.next;
            oddNode=oddNode.next;

            evenNode.next=oddNode.next;
            evenNode=evenNode.next;
        }
        oddNode.next=evenHead;

        return head;
    }

    // TC- O(n+m) , SC- O(n)
    public Node getIntersectionFromTwoLL(Node list1,Node list2)
    {

        if (list1==null)
            return list1;

        if (list2==null)
            return list2;

        HashSet<Node> nodes=new HashSet<>();
        while (list1!=null)
        {
            nodes.add(list1);
            list1=list1.next;
        }

        while (list2!=null)
        {
            if(nodes.contains(list2))
                return list2;

            list2=list2.next;
        }

        return null;
    }


    // TC- O(n+m) , SC- O(1)
    public Node getIntersectionFromTwoLLOptimal(Node list1,Node list2)
    {

        int len1= length(list1);
        int len2= length(list2);

        if(len1!=len2){
            if(len1<len2)
               list2= movePointer(list2,len2-len1);
            else
                list1=movePointer(list1,len1-len2);
        }

        while (list1!=list2)
        {
            list1=list1.next;
            list2=list2.next;
        }

        return list1;
    }

    private Node movePointer(Node head,int n)
    {
        while (n>0)
        {
            head=head.next;
            n--;
        }
        return head;
    }

    // TC- O(n) + O(n/2) = O(n) , SC- O(1)
    public Node deleteMiddle(Node head)
    {
        int len=length(head);
        int mid=len/2;

        Node temp=head;
        while (mid>1)
        {
            temp=temp.next;
            mid--;
        }

        if(temp!=null)
            temp.next=temp.next.next;

        return head;
    }

    // TC- O(n), SC- O(1)
    public Node deleteMiddleOptimal(Node head)
    {
        if(head==null)
            return head;

        if(head.next==null)
            return null;

        Node prev=null,slow=head,fast=head;
        while (fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=slow.next;
        return head;
    }

    public Node rotateRight(Node head,int k)
    {
        int len=length(head);
        k=len%k;
        while (k>0)
        {
            Node curr=head;
            Node prev=null;
            while (curr.next!=null)
            {
                prev=curr;
                curr=curr.next;
            }
            prev.next=null;
            curr.next=head;
            k--;
        }
        return head;

    }

     void printList(Node head)
    {
        while (head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    //How to detect a loop in a linked list, and remove the node creating loop.
    void detectAndRemoveNode(Node head)
    {
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
                break;
        }

        if(slow!=fast)
            return;

        slow=head;
        while (fast.next!=slow.next)
        {
            slow=slow.next;
            fast=fast.next;
        }
        fast.next=null;
    }

    public static void main(String[] args) {

        LinkedList linkedList=new LinkedList();

        linkedList.head=new Node(1);
        linkedList.head.next=new Node(2);
        linkedList.head.next.next=new Node(3);
        linkedList.head.next.next.next=new Node(4);
        linkedList.head.next.next.next.next=linkedList.head.next.next;

        System.out.println(linkedList.detectCycle(linkedList.head));
        linkedList.detectAndRemoveNode(linkedList.head);
        System.out.println(linkedList.detectCycle(linkedList.head));
        linkedList.printList(linkedList.head);


    }

}
