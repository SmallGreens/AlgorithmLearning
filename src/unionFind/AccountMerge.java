package unionFind;

import java.util.*;

/**
 * @author Matt
 * @date 2021/1/18 13:22
 *
 * LeetCode practise: https://leetcode-cn.com/problems/accounts-merge/
 *
 */
public class AccountMerge {
    int[] p;
    public static void main(String[] args) {
        AccountMerge am = new AccountMerge();
        List<List<String>> list = new ArrayList<>();

        // 初始化测试数据
        String[][] strs = {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
        for(String[] str: strs){
            list.add(Arrays.asList(str));
        }

        List<List<String>> res = am.accountsMerge(list);
        // 查看运行结果
        for (List<String> l:res){
            System.out.println(l.toString());
        }
        // check parent 数组
        System.out.println(Arrays.toString(am.p));

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        // emailCount 这个参数相当于是给 email 进行编号
        int emailsCount = 0;

        // Step1: 记录所有的 email 值，为他们分别编号。放置到 emailToIndex 中
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    // 先使用，后++，从零开始计数
                    emailToIndex.put(email, emailsCount++);
                    // 记录 email 对应的用户名
                    emailToName.put(email, name);
                }
            }
        }

        // Step2: 找到 emails 之间的关系，关系放置在 uf.parent 这个数组中
        UnionFind uf = new UnionFind(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            // 将同一个账户中的邮箱地址 使用并查集 关联起来
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                // 将 nextIndex 的父节点设置为 firstIndex
                uf.union(firstIndex, nextIndex);
            }
        }

        // Step3: 合并, 将具有相同 根结点的 email 元素进行合并，放置在 indexToEmails 对象中。key 为 根结点的 index
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }

        // Step4： 按照规定格式整合 用户名，并返回
        List<List<String>> merged = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        p = uf.parent;

        return merged;
    }
}

class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        // 初始值都用本身进行赋值
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // 合并，将 index2 的根结点 接到 index1 的根结点上，即 index1 的根结点为父节点
    public void union(int index1, int index2) {
        parent[find(index2)] = find(index1);
    }

    public int find(int index) {
        if (parent[index] != index) {
            // 递归，找到最深的顶层根结点
            // 在这一步中，顺便将 tree 进行了扁平化处理，就是将所有子节点都拉到了深度为2的位置
            parent[index] = find(parent[index]);
        }
        return parent[index];
    }
}
