package Sorting;

public abstract class Sort {
    public int compareTimes = 0;
    public int swapTimes = 0;

    public abstract void sort(int[] a);

    void swap(int[] arr, int a, int b){
        swapTimes++;
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
