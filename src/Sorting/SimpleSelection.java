package Sorting;

public class SimpleSelection extends Sort {
    @Override
    public void sort(int[] a) {
        if(a.length == 0) return;
        int maxIndex = a.length - 1;
        for(int i = 0; i < a.length; i++){
            // 找 0 到 （len - i） 中元素的最大值
            for(int j = 0; j < a.length - i - 1; j++){
                compareTimes++;
                if(a[j] > a[maxIndex]) maxIndex = j;
            }
            if(maxIndex != a.length - i - 1) swap(a, maxIndex, a.length - i - 1);
            maxIndex = a.length - i - 2;
        }
    }
}


