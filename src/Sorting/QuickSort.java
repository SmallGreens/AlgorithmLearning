package Sorting;

public class QuickSort extends Sort{
    @Override
    public void sort(int[] a) {
        qSort(a, 0, a.length-1);
    }

    private void qSort(int[] a, int left, int right){
        if(left >= right) return;
        int p = partition(a, left, right);
        // 注意这里的边界！！一个右边界是 p -1，一个右边界是 p+1。
        // 一定要小心处理，如果写 p，报 stackoverflow 错误
        qSort(a, left, p-1);
        qSort(a,p+1, right);
    }

    private int partition(int[] a, int left, int right){
    //   int pivot = (int) (left + Math.random() * (right - left + 1));
    //    swap(a, pivot, right);
        int index = left - 1;
        for(int i = left; i < right; i++){
            compareTimes++;
            if(a[i] < a[right]){
                index++;
                swap(a, i, index);
            }
        }
        swap(a, index + 1, right);
        return index+1;
    }
}
