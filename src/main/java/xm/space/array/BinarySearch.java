package xm.space.array;

import java.util.Arrays;

/**
 * @description: 二分查找
 * @author: 小明长高高
 * @date: 2023/4/27 22:39
 **/
public class BinarySearch {
    /** LeetCode704
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * 你可以假设 nums 中的所有元素是不重复的。递增
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     */

    //经典写法  左闭右闭
    static int oftenCode(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        //1.如果是数组是左闭右闭区间，while判断的时候需要 <=
        //左闭右闭 则left <= right  right = middle-1
        //左闭右开 则left < right  right = middle
        while (left <= right){
            //2.找出中间位置 这样写可能会整数溢出(left+right)/2  下面是防止溢出的写法，A点左边的距离加上A点与B点的距离差除以2就是中间位置。(数学)
            int middle = left+(right-left)/2;
            //3.中间位置是目标值返回数据。
            if (arr[middle]==target) {
                //计算机整数除法是向下取整数的，所以在出现(left+right)是奇数的时候middle结果一定会偏左一点
                //那么如果是左闭右闭，则直接对指针左这种处理就可以了（middle索引的值一定不等于目标值所以-1或者+1）
                //如果是左闭右开，则最右边索引是不需要处理的，那么存在arr[middle]>target则right = middle 不再-1了
                //不减一可以让middle稍微偏右边一个指针从而保证所有数据计算到(在while (left < right)的情况下)
                return middle;
            }
            //中间值比目标值大，右边指针移动到中间值，比目标小，左边指针移动到中间值。
            //4.middle索引的值一定不等于目标值所以-1 下面同理
            if (arr[middle]>target){
                right = middle-1;
            }else {
                left = middle+1;
            }
        }
        return -1;
    }
    //经典写法  左闭右开
    static int oftenCodeRightClose(int[] arr,int target){
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            int middle = left+(right-left)/2;
            if (arr[middle] < target){
                left = middle+1;
            } else if (arr[middle] > target) {
                right = middle;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /** LeetCode35
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置，你可以假设数组中无重复元素
     * 输入: [1,3,5,6], 2
     * 输出: 1
     */
    static int returnIndex(int[] arr,int target){
        //相比较与上面的解法，这里区别在于不存在于数组中的时候需要返回该数据应该在索引中的位置。
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int middle = left + (right-left)/2;
            if (arr[middle] > target){
                right = middle - 1;
            }else if (arr[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        //首先一定不存在指针合并的情况，最后一次二分的时候一定是left紧靠着right的操作。
        //不存在于数据的时候最后一次二分的时候，如果走arr[middle] < target 最后直接让while条件left>right的情况下
        //这之前的middle是小于target的，然后走left = middle + 1了。然后则left一定就是目标索引的位置。
        return left;
    }

    /** LeetCode34
     *给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题
     * 输入：nums = [5,7,7,8,8,10], target = 8 target=5
     * 输出：[3,4] 输出[0,0]
     */
    static int[] startEndSearch(int[] arr,int target){
        //1.使用二分法找出来这个值，然后处理这个值的左右边界
        int targetIndex = oftenCode(arr,target);
        if (targetIndex == -1){
            return new int[]{-1,-1};
        }
        int left = targetIndex;
        int right = targetIndex;
        //2.找到左边界
        while(left-1>=0 && arr[left-1]==target) {
            left--;
        }
        //3.找到右边界
        while(right+1 <=arr.length-1  && arr[right+1]==target) {
            right++;
        }
        return new int[]{left,right};
    }

    /** LeetCode69
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5
     * 0 <= x <= 2 31次方 - 1
     */
    static int squareRootX(int x){
        int l = 0, r = x, ans = -1;
        //舍去小数部分代表在middle的左边 边界问题存在相等情况这里取 =
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //小于等于的情况 如果等于x了。那么下一次while一定不成立，则ans一定是算术平方根
            //如果是小数的边界了，则下一步也一定while一定不成立，在不成立之前的middle也一定是算术平方根
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /** LeetCode367
     * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
     * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
     * 不能使用任何内置的库函数，如 sqrt
     * 1 <= num <= 2 31次方 - 1
     */
    static boolean completeSquareNumber(int x){
        //经典二分法 一直找 middle的乘积等于x则返回true
        int l = 0 ,r = x;
        //存在右边界即相等的情况 需要 =
        while (l<=r){
            int middle = l + (r-l)/2;
            long target = middle * middle;
            if (target < x){
                l = middle +1;
            } else if (target > x) {
                r = middle -1 ;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,8,9,11,45,77,99};
        int[]arr1 = {1,1,2,2,3,4,4,5,5,6,6,6,7,7,7,7,10};
        System.out.println(oftenCode(arr, 99));
        System.out.println(oftenCodeRightClose(arr, 77));
        System.out.println(returnIndex(arr, 88));
        System.out.println(Arrays.toString(startEndSearch(arr1, 2)));
        System.out.println(completeSquareNumber(3));
        System.out.println(squareRootX(17));
        System.out.println(completeSquareNumber(10));
    }





















}
