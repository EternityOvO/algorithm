
//快速排序
//将数组最后一个元素视为pivot标杆。在数组前面的元素中 分别从前和从后两边进行遍历，设置两个指针，前面遇到比pivot的数小的元素时不进行操作，指针加1
// 后面遇到比pivot的数大的元素时不进行操作，指针减1
//从前找到比pivot大的元素 ，从后找到比pivot小的元素，两者进行交换
public class QuickSort {
    public static void main(String[] args) {
        int[] arr={9,7,5,3,1,6};
        sort(arr,0,arr.length-1);
        print(arr);

    }

    public static void sort(int[] arr,int leftBound,int rightBound){
        if (leftBound>=rightBound) return;
        int mid=partition(arr,leftBound,rightBound);
        sort(arr,leftBound,mid-1);
        sort(arr,mid+1,rightBound);


    }

    //排序完成后，返回pivot的值，在pivot左边的值都小于它，右边都大于它，但是顺序并没有完全排完，需要递归，继续往下排序
    static int partition(int[] arr,int leftBound,int rightBound){
            int pivot=arr[rightBound];
            int left=leftBound;
            int right=rightBound-1;

            while (left<=right){
                while (left<=right&&arr[left]<=pivot){
                    left++;
                }
                while (left<=right&&arr[right]>pivot){
                    right--;
                }
                if (left<right){
                    swap(arr,left,right);
                }
            }
            swap(arr,left,rightBound);//到最后，left指向的是第一个比right大的元素，所以直接将left和最后一个元素替换
            return left;
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
