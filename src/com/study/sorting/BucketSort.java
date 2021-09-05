package com.study.sorting;

import java.util.Arrays;

/**
 * 桶排序 是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。
 *
 * 桶排序 (Bucket sort)的工作的原理：
 * 假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排
 *
 * 9.1 算法描述
 * 步骤1：人为设置一个BucketSize，作为每个桶所能放置多少个不同数值（例如当BucketSize==5时，该桶可以存放｛1,2,3,4,5｝这几种数字，
 * 但是容量不限，即可以存放100个3）；
 * 步骤2：遍历输入数据，并且把数据一个一个放到对应的桶里去；
 * 步骤3：对每个不是空的桶进行排序，可以使用其它排序方法，也可以递归使用桶排序；
 * 步骤4：从不是空的桶里把排好序的数据拼接起来。
 *
 * 注意，如果递归使用桶排序为各个桶排序，则当桶数量为1时要手动减小BucketSize增加下一循环桶的数量，否则会陷入死循环，导致内存溢出。
 *
 * 外排序
 * 稳定
 *
 * 最佳情况：T(n) = O(n+k)
 * 最差情况：T(n) = O(n+k)
 * 平均情况：T(n) = O(n2)
 * 空间复杂度：O(n+k)
 *
 * */

public class BucketSort {
    public static void main(String[] args) {
        int[] a = {10, 58, -10, 33, 20, 33, 24, 50};
        bucketSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static int[] bucketSort(int[] arr){
        int bucketSize = 5;
        if (arr.length == 0) {
            return arr;
        }

        int minValue = arr[0];
        int maxValue = arr[0];
        for (int value : arr) {
            if (value < minValue) {
                minValue = value;
            } else if (value > maxValue) {
                maxValue = value;
            }
        }

        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketSize) + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((arr[i] - minValue) / bucketSize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }

        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            // 对每个桶进行排序，这里使用了插入排序
            bucket = InsertionSort.insertionSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }

        return arr;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    public static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
