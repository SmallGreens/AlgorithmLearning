package unionFind;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Matt
 * @date 2021/1/18 11:38
 */
public class BasicUnionFind {
    private final int[] parent;
    public BasicUnionFind(int size) {
        parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = -1;
        }
    }

    public int[] getParent() {
        return parent;
    }

    public Map<String, Integer> findRoot(int x){
        Map<String, Integer> map = new HashMap<>();
        int rank = 0;
        int root = x;
        while(parent[root] != -1){
            root = parent[root];
            rank++;
        }
        map.put("root", root);
        map.put("rank", rank);
        return map;
    }

    //将两个结点进行合并的函数
    public boolean union(int x, int y){
        int rootX = findRoot(x).get("root");
        int rankX = findRoot(x).get("rank");
        int rootY = findRoot(y).get("root");
        int rankY= findRoot(y).get("rank");

        if(rootX == rootY){
            // have circle!!
            return true;
        }
        if(rankX > rankY){
            parent[rootY] = rootX;
        }else{
            parent[rootX] = rootY;
        }
        return false;
    }

    public boolean findCircle(int[][] data){
        boolean haveCircle = false;
        try {
            for(int[] d : data){
                boolean tmp = union(d[0],d[1]);
                if(haveCircle || tmp) haveCircle = true;
            }
            return haveCircle;

        } catch (Exception e) {
            System.out.println("data format wrong!" + e.toString());
            e.printStackTrace();
        }
        return haveCircle;
    }
}
