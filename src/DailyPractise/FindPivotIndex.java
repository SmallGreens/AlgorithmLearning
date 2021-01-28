package DailyPractise;

import java.util.Arrays;

/**
 * @author Matt
 * @date 2021/1/28 11:08
 *
 * Leetcode: 724. 寻找数组的中心索引
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 */
public class FindPivotIndex {
    // only work for positive value
    public int pivotIndex1(int[] nums) {
        if(nums.length < 3) return -1;
        int pre = 0, post = nums.length - 1;    // 标记遍历到的前后的指针
        int sumPre = nums[pre], sumPost = nums[post];
        while(pre < post){
            if(sumPre < sumPost) sumPre += nums[++pre];
            else if(sumPre > sumPost) sumPost += nums[--post];
            else if(pre + 2 == post) return pre + 1;
            else sumPre += nums[++pre];
        }
        return -1;
    }

    /**
     * 记数组的全部元素之和为 total，当遍历到第 i 个元素时，记它左侧的数字的和 为 sum，
     * 则右侧的和为：`total - sum - nums[i]`。
     * 如果 i 为中心索引，则有 `sum == total - sum - nums[i]`
     * 即 `2 * sum + nums[i] == total`。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = {-1,-1,-1,-1,-1,0};
        System.out.println(findPivotIndex.pivotIndex(nums));
    }
}
