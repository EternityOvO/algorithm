import java.util.ArrayList;
import java.util.List;

public class Solution704 {
    public static int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while (left<=right){   //注意此处的等号
            int mid=left + (right - left) / 2;//  如果使用left+right 当他们都很大时 容易越界
            if (nums[mid]>target){
                right=mid-1;
            }
            else if (nums[mid]<target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    //用递归的话 会导致栈溢出
//    private static int search(List<Integer> nums, int target, int leftIndex, int rightIndex){
//
//        int mid = (rightIndex+leftIndex) / 2;
//        if (nums.get(mid) == target) {
//            return mid;
//        }
//        if (nums.get(mid)< target){
//            return search(nums,target,mid+1,nums.size()-1);
//        }
//        else if (nums.get(mid)> target){
//            return search(nums,target,0,mid-1);
//        }
//        else return -1;
//
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12,13,17};
        int target = 13;
        int search = search(nums, target);
        System.out.println(search);
    }
}

