package Sorting;

public class BubbleSort extends Sort{
    public BubbleSort() {
    }

    public void sort(int[] arr){
        boolean isSorted = false;
        for(int i = 0; i < arr.length; i++){
            if(isSorted) break;
            isSorted = true;
            for(int j = 0; j < arr.length - i - 1; j++){
                compareTimes++;
                if(arr[j] > arr[j+1]){
                    isSorted = false;
                    swap(arr, j, j+1);
                }
            }
        }
    }


}
