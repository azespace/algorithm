package xm.space.array;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/05
 * Description: 长度最短的子数组
 **/
public class MinLengthChildrenArr {
    /** LeetCode 209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     */
    static int minLengthChildrenArr(int[] arr,int target){
        //1.双指针滑动窗口计算2个指针之间数据解题
        int left = 0;
        int targetLength = Integer.MAX_VALUE;
        int targetNum = 0;
        for (int i = 0; i < arr.length; i++) {
            //2.每次循环都加上之前的值 从而计算窗口之间的累加值
            targetNum += arr[i];
            //3.如果累加值大于目标 则计算指针间的距离 并将最左边的指针滑动一次,直到值小于目标值,窗口右边指针边界继续滑动。
            while(targetNum>=target){
                targetLength = Math.min(targetLength,i-left+1);
                targetNum -= arr[left++];
            }
        }
        return targetLength == Integer.MAX_VALUE ? 0:targetLength;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,7,8,5,6,2,4,3,4,3,3,5,5,1,1};
        System.out.println(minLengthChildrenArr(arr, 9));
    }
}
