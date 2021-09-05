package com.study.sorting;

import java.util.Arrays;

/**
 *  堆排序（Heapsort） 是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：
 *  即子结点的键值或索引总是小于（或者大于）它的父节点。
 *
 * 算法描述
 * 步骤1：将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 步骤2：将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
 * 步骤3：由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，
 * 得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 *
 * 内排序
 * 不稳定
 *
 * 最佳情况：T(n) = O(nlogn)
 * 最差情况：T(n) = O(nlogn)
 * 平均情况：T(n) = O(nlogn)
 *
 * */

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {10, 58, 33, 20, 33, 24, 50};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] heapSort(int[] arr){
        // 对 arr 进行拷贝，不改变参数内容
        //int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int len = arr.length;

        buildMaxHeap(arr, len);

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}