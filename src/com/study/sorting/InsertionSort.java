package com.study.sorting;

/**
 *  算法描述
 *
 * 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：
 * 步骤1: 从第一个元素开始，该元素可以认为已经被排序；
 * 步骤2: 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 步骤3: 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 步骤4: 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 步骤5: 将新元素插入到该位置后；
 * 步骤6: 重复步骤2~5。
 *
 * 稳定性：稳定
 * 内排序
 *
 *算法分析
 * 最佳情况：T(n) = O(n)
 * 最坏情况：T(n) = O(n2)
 * 平均情况：T(n) = O(n2)
 *
 * */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {10, 58, 33, 20, 33, 24, 50};
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] insertionSort(int array[]){
        if(array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];//抽出第i+1个元素
            int preIndex = i;
            //比较这个抽出的元素与前面已经拍好序的元素
            while (preIndex >= 0 && current < array[preIndex]){
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;//“+”是因为第i趟抽出来的是第i+1个元素
        }
        return  array;
    }
}
