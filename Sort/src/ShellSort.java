public class ShellSort {
    //希尔排序
    //先分组，比如4个一组，比较分别每组的第一个、第二个...元素，之后再缩小分组，比如两个一组，再进行排序，最后把间隔缩小到1，进行排序
    public static void main(String[] args) {
        int[] arr = {9, 6, 11, 3, 5, 12, 8, 7, 10, 15, 14, 4, 1, 13, 2};
        sort(arr);
        print(arr);

    }

    public static void sort(int[] arr) {
        int h=1;
        while(h<arr.length/3) {
            h = h * 3 + 1;
        }
        for (int gap =h; gap > 0; gap=(gap-1)/3) {//一开始4个一组，每次间隔缩小一半
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        swap(arr, j, j - gap);
                    }
                }
            }
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
