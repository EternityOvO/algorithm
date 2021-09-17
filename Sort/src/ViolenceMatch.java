//暴力匹配算法  匹配str1中是否包含str2字符串
public class ViolenceMatch {

    public static void main(String[] args) {
        //测试
        String str1="123456789";
        String str2="4569";
        int i = violenceMatch(str1, str2);
        System.out.println(i);


    }
    //暴力匹配算法

    public static int violenceMatch(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();

        int s1Len=s1.length;
        int s2Len=s2.length;

        int i=0;// i索引 指向s1
        int j=0;// j索引 指向s2
        while (i<s1Len&&j<s2Len){
            if (s1[i]==s2[j]){//匹配成功
                i++;
                j++;
            }else {//匹配没有成功
                i=i-(j-1);
                j=0;
            }
        }
        while (i<s1Len){
            return i-j;
        }
        return -1;
    }
}
