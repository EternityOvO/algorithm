import org.omg.CORBA.MARSHAL;

import static java.lang.Math.max;

//动态规划  背包问题
public class Dynamic_bag {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 4000};//物品的价格
        int m = 4;
        int n = val.length;


        //创建二维数组
        //v[i][j]表示在前i个物品中能够装入容量为j的背包中的最大价值，such as v[2][2]表示前两种物品放入容量为2的背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录放商品的情况，定义一个二维数组
        int[][] path = new int[n + 1][m + 1];
        //初始化第一行和第一列
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < val.length + 1; i++) {
            v[0][i] = 0;
        }

//        根据前面的公式来动态规划
        for (int i = 1; i < v.length; i++) {//不处理第一行
            for (int j = 1; j < v[0].length; j++) {//不处理第一列
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];//此处i是从1开始的，所以w和val都要从i-1开始
                } else {
                    //为了记录商品存放到背包的情况，我们不能简单的使用上面的公式，需要使用if-else来处理
//                        v[i][j]= Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }
        for (int i = 0; i < v.length; i++) {//v.length 是行数
            System.out.println(v.length);
            for (int j = 0; j < v[i].length; j++) {
            }

            System.out.println();

        }
        //输出最后我们是放入的哪些商品
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;//列的最大下标
        while (i > 0 && j > 0) {//从path数组的最后开始找{
            if (path[i][j] == i) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i - 1];//w[i-1]
            }
            i--;

        }
//
    }
}
