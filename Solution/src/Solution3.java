//无重复字符的最长字串

import java.util.HashMap;

public class Solution3 {
    public int lengthOfLongestSubstring1(String s) {
        //滑动窗口的方式 ，向右移动
        int left = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);//这一步 好好体会 为什么要取MAX值  //测试用例  abbc
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }



}
