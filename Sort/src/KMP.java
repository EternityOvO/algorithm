public class KMP {
    public static void main(String[] args) {
        String str1="BBC ABCDAB ABCDABCDABDE";
        String str2="ABCDABCD";
    }

    /*
    * @param str1 源字符串
    * @param str2 子串
    * @param next 部分匹配表，是字串对应的部分匹配表
    * @return 如果是-1就是没有匹配 否则返回第一个匹配的位置
    * */
    public static int kmpSearch(String str1,String str2,int[] next){
                //遍历str1
        for (int i = 0,j=0; i < str1.length(); i++) {
            //需要处理str1.charAt(i)!=str2.charAt(j)
            //KMP算法核心点
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){//此处str.length-1才是j对应的索引
                return i-j+1;
            }
        }
        return -1;

    }

    //获取到一个字符串（子串）的部分匹配值
    public static  int[] kmpNext(String dest){
        //创建一个next数组保存部分匹配值
            int[] next=new int[dest.length()];
            next[0] =0;//如果字符串是长度为1部分匹配值就是0;
            for (int i=0,j=0;i<dest.length();i++){
                //当dest.charAt(i)!=dest.charAt(j)，我们需要冲next[j-1]获取新的j
                //直到我们发现有dest.chatAt(i)==dest.charAt(j)成立才退出
                //这是kmp算法的核心
                while (j>0&&dest.charAt(i)!=dest.charAt(j)){
                    j=next[j-1];
                }
                if (dest.charAt(i)==dest.charAt(j)){
                    j++;
                }
                next[i]=j;
            }
            return next;
    }
}
