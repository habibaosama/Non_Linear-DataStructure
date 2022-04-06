package Dictionary;

import java.util.ArrayList;

public class TestingTime {

    AVLTreeDic tree =new  AVLTreeDic();

    public  void test() {
        ArrayList<String> list = new ArrayList<>();
        RandomString random = new RandomString();
        int n=100000;
        long startInsert = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            String s = random.randomString();
            list.add(s);
            tree.insert(s);

        }
        long endInsert = System.currentTimeMillis();
        System.out.println("execution time for  AVL insertion : " + (endInsert - startInsert) + "ms\n");

        long startDelete = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            double ss = Math.floor(Math.random() * (n - 1));
            tree.delete(list.get((int) ss));
        }
        long endDelete = System.currentTimeMillis();
        System.out.println("execution time  for AVL deletion : " + (endDelete - startDelete) + "ms\n");
    }
}

