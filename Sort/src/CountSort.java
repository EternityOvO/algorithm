import java.sql.Array;
import java.util.Arrays;

//计数排序
//such as 如果要对0-60 这一串数字进行排序，新建一个长度为61的数组，数组的index为0-60，对 数字进行遍历，对数字出现的次数在数组中进行计数。
// 最后对数组中的数进行遍历，比如索引为0的数字出现了5次，则输出5个0，索引为1的数字出现了3次，则在0后面输出三个1...
//可能存在的问题：数组空间的浪费；排序不稳定
public class CountSort {

    public static void main(String[] args) {
        int[] arr={2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};
        int[] result=sort(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] sort(int[] arr){
        int[] result=new int[arr.length];
        int[] count=new int[10];
        for (int i = 0; i <arr.length ; i++) {
            count[arr[i]]++;
        }
//        for (int i = 0,j=0; i < count.length; i++) {
//            while (count[i]-->0){
//                result[j++]=i;
//            }
//        }   这个方法 得到的结果不稳定

        for (int i = 1; i < count.length; i++) {
            count[i]=count[i]+count[i-1];//累加数组，记录的是每个数字出现的最后一个应该在什么位置
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            result[--count[arr[i]]]=arr[i];//为保持稳定，应该按原来数字出现的相对位置进行排列，比如1102102这个数组 第一个1对应1中的第一个，第二个1就要放在第二个

        }
        return result;
    }
}
