import java.util.TreeMap;

//选择排序
public class SelectionSort {
    //遍历数组，首先拿索引为0的值与后面进行比较，如果后面的值比它要小则用取后面值继续进行比较，找到最小值与索引为0的值进行交换
    //以此类推，再从索引为1的值开始重复上面操作
    public static void main(String[] args) {
        int[] arr={5,3,6,8,1,7,9,4,2,2};


//        for (int i = 0; i <arr.length ; i++) {
//            System.out.print(arr[i]+" ");
//        }

        for (int k = 0; k <arr.length-1 ; k++) {
            int minPos=k;
            for (int j = k+1; j <arr.length ; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            int i = arr[k];
            arr[k]=arr[minPos];
            arr[minPos]=i;
        }

        for (int a:arr) {
            System.out.print(a+" ");
        }
    }
}
