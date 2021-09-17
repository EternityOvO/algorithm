public class Solution35 {
    public int Solution35(int[] nums, int target) {
        int left=0,right=nums.length-1,mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<target){
                left=mid+1;
            }
            else if(nums[mid]>target){
                right=mid-1;
            }

        }
        return left;

    }
}
