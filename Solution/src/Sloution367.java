public class Sloution367 {
    public boolean Sloution367(int num) {
        if (num == 1) {
            return true;
        } else {
            int left = 1, right = num, mid;
            while (left < right - 1) {
                mid = left + (right - left) / 2;
                if ((long) mid * mid == num) {
                    return true;
                }
                if ((long) mid * mid > num) {
                    right = mid;
                }
                ;
                if ((long) mid * mid < num) {
                    left = mid;
                }
            }
            return false;
        }
    }

}
