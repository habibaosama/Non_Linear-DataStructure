public class Main {
    public static void main (String[] args ){
        Tree tree =new Tree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(20);
        tree.insert(52);
        //System.out.println(tree.search(7));
        //tree.traversePreOrder();
      /*  var nodes=tree.getNodesFromDistance(2);
       for(var i:nodes)
           System.out.println(i);*/
        tree.traversalLevelOrder();

    }
}
