package xm.space.array;

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
    }
}
