package Sorting;

public class HeapSort extends Sort {
    @Override
    public void sort(int[] a) {
        int len = a.length;
        // 堆排序，首先构造一个大顶堆
        buildHeapTree(a,len);

        // 将堆顶与最后一个元素交换，然后缩短堆的长度
        while(len > 0){
            swap(a,0,len-1);
            len--;
            adjustHeapTree(a,0,len);
        }
    }

    void buildHeapTree(int[] a, int len){
        for(int i = len/2 -1; i >=0; i--){
            adjustHeapTree(a, i,len);
        }
    }

    void adjustHeapTree(int[] a, int index, int length){
        int maxIndex = index;
        compareTimes += 2;
        // 找完全二叉树的两个子节点，看是否比根节点小。
        // 这里需要小心的是，由于 完全二叉树的编号是从1开始的，它的两个子节点为 2*i， 2*i+1。
        // 但是数组中，是从0开始编号，因此 第 i 个数组元素对应的其在完全二叉树中的左右孩子的节点分别为 2*i+1.2*i+2(可举例看一下~)
        if(index * 2 + 1 < length && a[index * 2+ 1] > a[maxIndex]) maxIndex = index * 2+1;
        if(index * 2 + 2 < length && a[index * 2 + 2] > a[maxIndex]) maxIndex = index * 2 + 2;
        if(maxIndex != index){
            swap(a,maxIndex,index);
            adjustHeapTree(a, maxIndex,length);
        }
    }
}
