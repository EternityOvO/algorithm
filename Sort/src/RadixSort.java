import java.util.Arrays;

//基数排序，按不同的条件 分多次塞入桶里
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={421,240,124,562,305,430,115};
        int[] result=sort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr){
        int[] result =new int[arr.length];
        for (int i = 0; i <3 ; i++) {
            int division =(int)Math.pow(10,i);//10的i次方
            int[] count =new int[10];
            for (int j = 0; j <arr.length; j++) {
                int num =arr[j]/division%10;

                count[num]++;

            }



            for (int m = 1; m < count.length; m++) {
                count[m]=count[m]+count[m-1];//累加数组，记录的是每个数字出现的最后一个应该在什么位置
            }

            for (int n = arr.length-1; n >=0; n--) {
                int num=arr[n]/division%10;
                result[--count[num]]=arr[n];  //--count[num]就是arr[n]应当放置的位置的索引

            }
            System.out.println(Arrays.toString(result));
            for (int j = 0; j <arr.length ; j++) {
                arr[j]=result[j];
            }
        }
        return result;

    }
}
