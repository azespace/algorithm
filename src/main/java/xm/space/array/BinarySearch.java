package xm.space.array;

/**
 * @description: 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 你可以假设 nums 中的所有元素是不重复的。递增
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间
 * @author: 小明长高高
 * @date: 2023/4/27 22:39
 **/
public class BinarySearch {
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

    public static void main(String[] args) {
        int[]arr = {1,2,8,9,11,45,77,99};
        System.out.println(oftenCode(arr, 99));
        System.out.println(oftenCodeRightClose(arr, 77));
    }

}
