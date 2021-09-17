//计算x的平方根，不用内置函数
public class Solution69 {
    public static int Solution69(int x) {

        if (x == 0) {
            return 0;
        } else {
            int left = 1, right = x, mid;
            while (left < right - 1) {
                mid = left + (right - left) / 2;
                if ((long)mid * mid == x) {
                    return mid;
                }
                if ((long)mid * mid> x) {
                    right = mid;
                }
                ;
                if ((long)mid * mid < x) {
                    left = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int x= 2147395599;
        int i = Solution69(x);
        System.out.println(i);

    }
}
