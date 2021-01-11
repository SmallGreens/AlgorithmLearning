package Sorting;

public class SimpleInsertSort extends Sort{
    @Override
    public void sort(int[] a) {
        int len = a.length;
        for(int i = 0; i < len - 1; i++){
            int tmp = a[i+1], index = i;   // 将第 i + 1 个数字插入到 子数组（从0到i）中

            while(index >= 0 && a[index] > tmp){
                swapTimes++;
                compareTimes++;
                a[index + 1] = a[index];
                index --;
            }
            a[index + 1] = tmp;
        }
    }
}
