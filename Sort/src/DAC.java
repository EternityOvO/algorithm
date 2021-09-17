//分治算法 解决汉诺塔
public class DAC {

    public static void main(String[] args) {
        hanoiTower(2,'A','B','C');

    }

    //汉诺塔的移动方案
    //使用分治算法

    public  static void hanoiTower(int num,char a,char b,char c){//三个柱子,a、b、c
        //如果只有一个盘
        if (num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else{
            //如果我们有n>=2情况，我们总是可以看作是两个盘 1.最下面的盘  2.上面的所有盘子看成是一个盘
            //1.先把最上面的盘A->B,移动过程会使用到C
            hanoiTower(num-1,a,c,b);
            //2.把最下边的盘A->C
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //3.把B塔的所有塔从B->C,移动过程使用到A
            hanoiTower(num-1,b,a,c);
        }
    }


}
