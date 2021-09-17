import java.util.HashMap;

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        //先遍历数组，计算traget和数字之差，在map中添加key为value，value为索引
        HashMap<Integer,Integer>  map =new HashMap<>();//创建一个hashMap
        for (int i = 0; i <nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)){
                return new int[]{map.get(res),i};//如果map里有res值，则返回res的索引和当前数的索引
            }
            else map.put(nums[i],i);//如果map里没有res的值，则把nums[i]的值和索引 作为key，value存入map
        }
        return new int[0];
    }
}
