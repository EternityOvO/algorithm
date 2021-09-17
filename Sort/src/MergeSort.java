public class MergeSort {

    //归并排序
    public static void main(String[] args) {
        int[] arr = {1, 4, 7, 8, 3, 6, 9};
        sort(arr,0,arr.length);
    }

    public static void sort(int[] arr,int left,int right) {
        if (left==right){
            return;
        }
        //分成两半，左边排序，右边排序，左右两边进行merge
        int mid =left+(right-left)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        merge(arr,left,mid+1,right);
    }

    static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound) {//左指针leftPtr指向左边的index,右指针rightPtr指向右边的index,
                                                                        // 右边界rightBound指向右边的最右边
        //把数组分为左右两个部分
        int mid = arr.length / 2;
        int[] temp = new int[rightBound-leftPtr+1];

        int i = leftPtr;
        int j = rightPtr;
        int k = 0;
        //当左右两边都没有遍历完时
        while (i <= rightPtr-1 && j <= rightBound) {
            temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
        }

        //当左右两边有一边已经遍历处理完了，就直接把另一部分丢到temp数组的后面
        while (i <= rightPtr-1) {
            temp[k++] = arr[i++];
        }

        while (j <= rightBound) {
            temp[k++] = arr[j++];
        }

        for (int l = 0; l <temp.length ; l++) {
            arr[l]=temp[l];
        }

    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }
    }


}
