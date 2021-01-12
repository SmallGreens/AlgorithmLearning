package Sorting;
public class MergeSort extends Sort{
    int[] res;
    @Override
    public void sort(int[] a) {
        res = new int[a.length];
        mergeSort(a,0,a.length-1);
    }
    // 排序
    private void mergeSort(int[] a, int start, int end){
        if(end == start) return;
        int mid = start + (end - start)/2;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,end);
    }
    // 合并数组
    private void merge(int[] a, int start, int end){
        int mid = start + (end - start)/2; // e.g. 0,1,2, end = 2, start = 0, 0 + 2/2 = 1,
        int preIndex = start, postIndex = mid + 1, index = start;
        while(preIndex <= mid && postIndex <= end){
            if(a[preIndex] < a[postIndex]) res[index++] = a[preIndex++];
            else res[index++] = a[postIndex++];
            compareTimes++;
        }
        while(preIndex <= mid) res[index++] = a[preIndex++];
        while(postIndex <= end) res[index++] = a[postIndex++];
        // ！！这一步必须添加！！ ref: https://www.cnblogs.com/chengxiao/p/6194356.html
        if (end + 1 - start >= 0) System.arraycopy(res, start, a, start, end + 1 - start);
    }
}