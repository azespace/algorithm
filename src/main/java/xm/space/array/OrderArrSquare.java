package xm.space.array;

import java.util.Arrays;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/04
 * Description: 有序数组的平方
 **/
public class OrderArrSquare {
    /** LeetCode 977
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。其实就是递增数组
     * 示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
     * 示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
     */
    static int[] orderArrSquare(int[] arr){
        //1.双指针做 最左边索引 和 最右边索引重合即结束
        int left = 0;
        int right = arr.length-1;
        //2.新的数组和索引
        int[] newArr = new int[arr.length];
        int index = arr.length-1;
        //3.做小索引与最大索引进行判断谁大谁就是最大的 因为他们是递增的，整数那么谁的平方大谁就是最大的，因为负数越小越大 0就是最大的，整数 最大就是最大。
        while (left <= right){
            int leftMax = arr[left]*arr[left];
            int rightMax = arr[right]*arr[right];
            if (leftMax>rightMax){
                newArr[index--] = leftMax;
                left++;
            }else{
                newArr[index--] = rightMax;
                right--;
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        int[] arr = {-8,-1,-1,0,2,4,8};
        System.out.println(Arrays.toString(orderArrSquare(arr)));
    }
}
