package com.study.sorting;

/**
 *  快速排序 的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 *  则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 算法描述
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * 步骤1：从数列中挑出一个元素，称为 “基准”（pivot ）；
 * 步骤2：重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 步骤3：递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 内排序
 * 不稳定
 * 最佳情况：T(n) = O(nlogn)
 * 最差情况：T(n) = O(n2)
 * 平均情况：T(n) = O(nlogn)
 *
 * */

public class QuickSort {
    public static void main(String[] args) {

        int[] a = {10, 58, 20, 33, 24, 50, 33};
        quickSort(a,0,a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

    public static int[] quickSort(int[] array, int left, int right){
        if(array.length < 1 || left < 0 || right >= array.length || left > right)return null;
        int smallIndex = partition(array,left,right);
        if(smallIndex > left){
            quickSort(array,left,smallIndex - 1);
        }
        if(smallIndex < right){
            quickSort(array,smallIndex +1,right);
        }
        return array;
    }

    public static int partition(int[] array, int left, int right){
        int privot = (int)(left + Math. random()*(right - left + 1));
        int smallIndex = left - 1;
        swap(array,privot,right);
        for (int i = left; i <= right; i++) {
            if(array[i] <= array[right]){
                smallIndex++;
                if(i > smallIndex){
                    swap(array,i,smallIndex);
                }
            }
        }
        return smallIndex;
    }

    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
