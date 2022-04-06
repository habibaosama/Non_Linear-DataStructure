import java.util.ArrayList;

public class Tree {
    private class Node{
        private int value;
        private Node left;
        private Node right;
        public Node(int value){
            this.value=value;
        }
        //to see value while debugging
        @Override
        public String toString(){
            return "Node" + value;
        }
    }
    private Node root;
    public void insert(int value){
        var node= new Node(value);
        if(root==null){
            root=node;
            return;
        }
        var current=root;
        while(true){
            if(value> current.value){
                if(current.right==null) {
                    current.right=node;
                    break;
                }
                current=current.right;
            }
            else{
                if(current.left==null){
                    current.left=node;
                    break;
                }
                current=current.left;
            }
        }
    }
    public boolean search(int value){
        var current=root;
        while(current!=null){
            if(value>current.value)
                current=current.right;
            else if(value< current.value)
                current=current.left;
            else
                return true;
        }
        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }
    private void traversePreOrder(Node root){
        if(root==null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }


    public int height(){
        return height(root);
    }
    private int height(Node root){
        if(root==null)
            return -1;
        if(isLeaf())
            return 0;

        return 1+Math.max(height(root.left),height(root.right));
    }
    private boolean isLeaf(){
        return root.left==null && root.right==null;
    }

    //O(log(n)) for binary search tree search only in left branch
    public int min(){
        if(root==null)
            throw new IllegalStateException();
        var current=root;
        var last=current;
        while(current!=null){
            last=current;
            current=current.left;
        }
        return last.value;
    }
    //O(n) normal binary tree
    private int min (Node root){
        if(isLeaf())
            return root.value;

        var left=min(root.left);
        var right=min(root.right);
        return Math.min(Math.min(left,right),root.value);
    }

    public boolean equals(Tree other){
        if (other==null)
                return false;
        return equals(root, other.root);
    }
    private boolean equals(Node first ,Node second){
        if(first==null && second ==null)
            return true;
        if(first!=null && second!=null)
            //preorder
            return first.value== second.value &&
                    equals(first.left, second.right) &&
                    equals(first.right,second.right);
        return false;
    }

    public boolean isBinarySearch(){
    return isBinarySearch(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBinarySearch(Node root , int min, int max){
        if (root==null)
            return true;

        if(root.value <min || root.value>max)
            //it is not in range
            return false;
        //understand by example
      return  isBinarySearch(root.left,min, root.value-1)
         && isBinarySearch(root.right,root.value+1, max);
    }

    //printing nodes at given distance from root
    public ArrayList getNodesFromDistance(int distance){
        ArrayList<Integer> list =new ArrayList<>();
        getNodesFromDistance(root,distance,list);
        return list;

    }
    private void getNodesFromDistance(Node root , int distance, ArrayList<Integer> list){
        if (root==null)
            return;

        if(distance==0)
            list.add(root.value);

        getNodesFromDistance(root.left ,distance-1,  list);
        getNodesFromDistance(root.right ,distance-1,  list);

    }

    public void traversalLevelOrder(){
        for(int i=0;i<=height();i++){
            for(var items:getNodesFromDistance(i))
                System.out.println(items);

        }
    }

}
