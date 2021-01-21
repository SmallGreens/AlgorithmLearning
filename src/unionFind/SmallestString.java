package unionFind;

import java.util.*;

/**
 * @author Matt
 * @date 2021/1/19 11:57
 *
 * LeetCode: https://leetcode-cn.com/problems/smallest-string-with-swaps/
 *
 * 1月11日 Leetcode everyDay practise.
 */
public class SmallestString {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        if(s.length() == 0){
            return s;
        }

        // 首先构建连通关系
        UnionFind uf = new UnionFind(s.length());
        for(List<Integer> list : pairs){
            uf.union(list.get(0),list.get(1));
        }

        System.out.println(Arrays.toString(uf.getParent()));
        System.out.println(Arrays.toString(uf.getRank()));

        // 以 root 值为纽带，构建一个 map。key 为 root，value 为 priorityQueue 存放相同 root 的字符串中的元素
        Map<Integer, Queue<Character>> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            int root = uf.find(i);
            if(map.containsKey(root)){
                map.get(root).offer(s.charAt(i));
            }else{
                Queue<Character> queue = new PriorityQueue<>();
                queue.offer(s.charAt(i));
                map.put(root,queue);
            }
        }

        // 再按顺序遍历一次，一次获取新字符串中元素
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); ++i){
            int root = uf.find(i);
            stringBuilder.append(map.get(root).poll());
        }



        return stringBuilder.toString();


    }

    private static class UnionFind {

        private final int[] parent;
        /**
         * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
         */
        private final int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                parent[rootY] = rootX;
            }
        }

        /**
         * 这个 find 可以在寻找根结点的同时，将寻找过程所经过的链路上的所有结点 全部降至秩为1（也就是直接连接到根结点）
         *
         *  例子1：
         *  连接关系：{0,1},{2,3},{1,2}， 则parent 数组为：{1, 3, 3, 3，4}，rank 数组为：{1, 2, 1, 3, 1}
         *  即位号为1的元素深度为2，因为它具有一个子节点为0，位号为1的元素的父节点为3，所以位号为3的元素秩为 3.
         *  这时候，如果添加一个连接关系，修改连接关系为： {0,1},{2,3},{1,2},{4,0}，
         *  在执行 find(0) 的时候，会将 0 的父节点设置为 3， 从而让 parent数组变为 {3, 3, 3, 3, 3}
         *  也就是除3外，秩全部都归为了 1，形象的感觉是将链拉平了。
         *
         *  但是本程序中并没有做秩更新的操作，相关的影响需要后续分析！
         */
        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int[] getParent() {
            return parent;
        }

        public int[] getRank() {
            return rank;
        }
    }

    public static void main(String[] args) {
        Integer[][] connection = {{0,1},{2,3},{1,2},{0,4}};
        List<List<Integer>> list = new ArrayList<>();
        for(Integer[] c:connection){
            list.add(Arrays.asList(c));
        }
        SmallestString smallestString = new SmallestString();
        String s = smallestString.smallestStringWithSwaps("dcabgfeh", list);
        System.out.println(s);
    }
}
