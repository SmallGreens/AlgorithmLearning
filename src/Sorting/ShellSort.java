package Sorting;

public class ShellSort extends Sort{

    // gap = 2
    @Override
//    public void sort(int[] a) {
//        int len = a.length;
//        int gap = len/2;
//        while(gap > 0){
//            for(int i = gap; i < len; i++){
//                int tmp = a[i];
//                int index = i - gap;
//                while(index >= 0 && a[index] > tmp){
//                    compareTimes++;
//                    swapTimes++;
//                    a[index + gap] = a[index];
//                    index -= gap;
//                }
//                a[index+gap] = tmp;
//            }
//            gap /= 2;
//        }
//    }


    public void sort(int[] a) {
        int len = a.length;
        int gap = len/3;
        while(gap > 0){
            for(int i = gap; i < len; i++){
                int tmp = a[i];
                int index = i - gap;
                while(index >= 0 && a[index] > tmp){
                    compareTimes++;
                    swapTimes++;
                    a[index + gap] = a[index];
                    index -= gap;
                }
                a[index+gap] = tmp;
            }
            gap /= 3;
        }
    }
}
