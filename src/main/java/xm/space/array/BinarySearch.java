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
    //经典写法
    static int oftenCode(int[] arr,int search){
        int left = 0;
        int right = arr.length-1;//如果是数组是左闭右闭区间
        while (left <= right){//left=right是有可能的，while判断的时候需要 <=
            //找出中间位置 这样写可能会溢出(left+right)/2  下面是防止溢出的写法，A点左边的 加上与右边的距离除以2就是中间位置。
            int middle = left+(right-left)/2;
            if (arr[middle]==search) {
                return middle;
            }
            //这里不减一或者加一会导致死循环，计算机整数除法是向下取整数的，二分查找最后一定会left等于right-1 (因为要找到中间值)。
            //那么出现left等于right-1 则目标值大那么就一定是left 目标值小就一定是right 也是二分查找最后确定值的关键。
            //那么如果不做减一或者加一 则 int middle = left+(right-left)/2; 就会永远是left 因为1/2等于0了 就会死循环了。
            if (arr[middle]>search){
                right = middle-1;//middle索引的值一定不等于目标值所以-1 下面同理
            }else {
                left = middle+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr = {1,2,8,9,11,45,77,99};
        System.out.println(oftenCode(arr, 99));
    }

}
