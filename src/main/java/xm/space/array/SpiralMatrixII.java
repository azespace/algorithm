package xm.space.array;

import java.util.ArrayList;
import java.util.List;

/**
 * There is plenty of fish in the sea
 *
 * @Author XM  2023/05/06
 * Description:螺旋矩阵II
 **/
public class SpiralMatrixII {
    /** LeetCode 59
     * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
     * 1 <= n <= 20
     */
    static int[][] spiralMatrixII(int n) {
        //1.定义四个零界点索引,上下左右。依次填充
        int l=0,r=n-1,t=0,b=n-1;
        //2.定义二维数组中最小值和最大值。
        int[][] arr = new int[n][n];
        int ele = 1,maxEle = n*n;
        //3.循环处理数据每次处理顺时针的一圈数据。
        while (ele<=maxEle){
            //4.先处理顶端的一排
            for (int i = l; i <= r; i++) {
                arr[t][i] = ele++;
            }
            //5.顶端的一排已处理完毕 所以指针需要+1一次。下面的其他同理
            t++;
            //6.处理最右边的一排数据 要注意从上到下变的是x轴所以是 arr[i][r]
            for (int i = t; i <= b; i++) {
                arr[i][r] = ele++;
            }
            r--;
            //7.处理最下面的一排数据
            for (int i = r; i >= l; i--) {
                arr[b][i] = ele++;
            }
            b--;
            //8.处理最左边的一排数据
            for (int i = b; i >= t; i--) {
                arr[i][l] = ele++;
            }
            l++;
        }
        return arr;
    }

    /** LeetCode 54
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * 提示：
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    static List<Integer> spiralMatrixPrint(int[][] matrix) {
        //1.找出左右上下边界
        int x = matrix.length;
        int y = matrix[0].length;
        List<Integer> list = new ArrayList<>(256);
        int l=0,r=y-1,t=0,b=x-1;
        //2. 每个数组空间当作一个元素依次放入数组中。元素长度作为判断条件,要注意正方形和非正方形不同。非正方形层数少一次，数据可能会出现问题
        int ele = 1;
        while(ele <= x*y){
            //3.一定要判断ele <= x*y 涉及螺旋矩阵层数问题。
            for (int i = l; i <= r && ele <= x*y; i++) {
                list.add(matrix[t][i]);
                ele++;
            }
            t++;
            for (int i = t; i <= b && ele <= x*y; i++) {
                list.add(matrix[i][r]);
                ele++;
            }
            r--;
            for (int i = r; i >= l && ele <= x*y; i--) {
                list.add(matrix[b][i]);
                ele++;
            }
            b--;
            for (int i = b; i >= t && ele <= x*y; i--) {
                list.add(matrix[i][l]);
                ele++;
            }
            l++;
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] ints = spiralMatrixII(20);
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                if (ints[i][i1] <10 ){
                    System.out.print(ints[i][i1]+"     ");
                }else if( ints[i][i1] < 100 && ints[i][i1] > 9 ){
                    System.out.print(ints[i][i1]+"    ");
                }else{
                    System.out.print(ints[i][i1]+"   ");
                }
            }
            System.out.println();
        }
        int[][] ints1 = {{1,3,5,6},{22,45,78,21},{111,333,667,463}};
        List<Integer> integers = spiralMatrixPrint(ints1);
        System.out.println(integers);
    }
}
