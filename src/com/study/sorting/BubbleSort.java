package com.study.sorting;

/**
*冒泡排序
 * * 1.1 算法描述
 * 步骤1: 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 步骤2: 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 步骤3: 针对所有的元素重复以上的步骤，除了最后一个；
 * 步骤4: 重复步骤1~3，直到排序完成。
 * *
 * * 稳定性：稳定
 * * 排序方式：内排序
 * * 算法分析
 * 最佳情况：T(n) = O(n)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
* */

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {10,33,58,20,33,24,50};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] bubbleSort(int[] array){
        if (array.length == 0){
            return array;
        }
        /*
        我觉得这个写法不论数据如何，其时间复杂度都会是O(n^2),因为不管怎样都会进行两次for循环
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;//对冒泡排序进行优化，检查数据是否本身已经有序
            for (int j = 0; j < array.length - 1 - i; j++) {
                //升序
                if (array[j] > array[j+1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    sorted = false;//如果有数据进行交换，那么说明数据还没达到有序
                }
            }
            if(sorted)break;
        }
         */
        for (int end = array.length - 1; end > 0; end--) {
            int sortIndex = 1;
            for (int i = 1; i <= end; i++) {
                if (array[i] < array[i - 1]){
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    sortIndex = i;//记录最后交换的位置，如果初始数据部分有序，则不再扫描后面部分
                }
            }
            end = sortIndex;
        }

        return array;
    }
}
