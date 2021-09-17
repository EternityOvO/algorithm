//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
            int[] a={9,6,5,3,1,3};
            sort(a);
            print(a);
    }
//从第一个开始跟后面比较，如果大，则交换位置
    static void sort(int[] a){
        for (int i = a.length-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j]>a[j+1]){
                    swap(a,j,j+1);
                }
            }
        }

    }

    static void swap(int[] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
