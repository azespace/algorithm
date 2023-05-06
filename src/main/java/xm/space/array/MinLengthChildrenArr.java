package xm.space.array;

import java.util.HashMap;
import java.util.Map;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/05
 * Description: 长度最短的子数组
 **/
public class MinLengthChildrenArr {
    /**
     * LeetCode 209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     */
    static int minLengthChildrenArr(int[] arr, int target) {
        //1.双指针滑动窗口计算2个指针之间数据解题
        int left = 0;
        int targetLength = Integer.MAX_VALUE;
        int targetNum = 0;
        for (int i = 0; i < arr.length; i++) {
            //2.每次循环都加上之前的值 从而计算窗口之间的累加值
            targetNum += arr[i];
            //3.如果累加值大于目标 则计算指针间的距离 并将最左边的指针滑动一次,直到值小于目标值,窗口右边指针边界继续滑动。
            while (targetNum >= target) {
                targetLength = Math.min(targetLength, i - left + 1);
                targetNum -= arr[left++];
            }
        }
        return targetLength == Integer.MAX_VALUE ? 0 : targetLength;
    }

    /**
     * LeetCode 904
     * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i]是第i棵树上的水果种类 。
     * fruits[1] = 4 表示这棵树上的水果都属于第4号水果。也就是找出只有2种类型水果的的连续的子数组的最大值。
     * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
     * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
     * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
     * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
     * 示例 1：
     * 输入：fruits = [1,2,1]
     * 输出：3
     * 解释：可以采摘 [1,2,2] 这三棵树。  如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
     * 示例 2：
     * 输入：fruits = [1,2,3,2,2]
     * 输出：4
     * 解释：可以采摘 [2,3,2,2] 这四棵树。如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
     * 提示：1 <= fruits.length <= 105   0 <= fruits[i] < fruits.length
     */
    static int fruitsWindow(int[] arr) {
        //1.定义滑动窗口的左指针,以及窗口最大值
        int length = arr.length;
        int left = 0;
        int leftToRightMaxNums = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int right = 0; right < length; ++right) {
            //2.右指针每走一次都放入哈希表 并且统计次数,getOrDefault方法为MAP方法 获取key的值不存在key返回则为0否则返回key
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            //4.这次指针出现第三个不一样的，不符合题意 处理左指针。
            while(map.size()>2){
                //难点在这里
                //6.减去一次存储的key的值，并且做完这个动则指针右滑一次 如果为0表示该数需要移除了，进入下一个滑动窗口
                map.put(arr[left],map.get(arr[left])-1);
                if (map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                //5.左指针滑一下
                ++left;
            }
            //3.此时种类一直都没大于2 所以计算比较2个指针间的距离就是最大的，直到计算结束
            leftToRightMaxNums = Math.max(leftToRightMaxNums,right-left+1);
        }
        return leftToRightMaxNums;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 7, 8, 5, 6, 2, 4, 3, 4, 3, 3, 5, 5, 1, 1};
        int[] arr1 = {3, 3, 3, 1, 4, 3, 3, 3, 2, 2, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(minLengthChildrenArr(arr, 9));
        System.out.println(fruitsWindow(arr1));
    }
}
