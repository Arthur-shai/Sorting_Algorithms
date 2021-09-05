package com.study.sorting;

/**
 * 算法描述：
 * 步骤1：选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 步骤2：按增量序列个数k，对序列进行k 趟排序；
 * 步骤3：每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。
 * 仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 内排序
 * 不稳定
 *
 *最佳情况：T(n) = O(nlog2 n)
 * 最坏情况：T(n) = O(nlog2 n)
 * 平均情况：T(n) =O(nlog2n)
 *
 * */

public class ShellSort {
    public static void main(String[] args) {
        int[] a = {10, 58, -10, 33, 20, 33, 24, 50};
        shellSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] shellSort(int[] array){
        int len = array.length;
        /*希尔排序的增量序列的选择与证明是个数学难题，我们选择的这个增量序列是比较常用的，
         也是希尔建议的增量，称为希尔增量，但其实这个增量序列不是最优的。
        在此我们选择增量gap=length/2，缩小增量继续以gap = gap/2的方式，
         这种增量选择我们可以用一个序列来表示，{n/2,(n/2)/2…1}，称为增量序列。*/
        int gap = len/2;
        while (gap > 0){
            for (int i = gap; i < len; i++){
                int tmp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && tmp < array[preIndex]){
                    array[i] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = tmp;
            }
            gap /= 2;
        }
        return array;
    }
}
