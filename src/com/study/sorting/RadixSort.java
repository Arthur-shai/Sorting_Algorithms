package com.study.sorting;

import java.util.Arrays;

/**
 * 基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；
 *
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，
 * 再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。
 *
 * 算法描述
 * 步骤1：取得数组中的最大数，并取得位数；
 * 步骤2：arr为原始数组，从最低位开始取每个位组成radix数组；
 * 步骤3：对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 *
 * 稳定
 * 外排序
 *
 * 最佳情况：T(n) = O(n * k)
 * 最差情况：T(n) = O(n * k)
 * 平均情况：T(n) = O(n * k)
 * 空间复杂度：O(n+k)
 *
 * 基数排序有两种方法：
 * MSD 从高位开始进行排序
 * LSD 从低位开始进行排序
 * 基数排序 vs 计数排序 vs 桶排序
 *
 * 这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
 *
 * 基数排序： 根据键值的每位数字来分配桶
 * 计数排序： 每个桶只存储单一键值
 * 桶排序： 每个桶存储一定范围的数值
 * */

public class RadixSort {
    public static void main(String[] args) {
        int[] a = {10, 58, -10, 33, 20, 33, 24, 50};
        int maxDigit = getMaxDigit(a);
        radixSort(a,maxDigit);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    public static int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected static int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    public static int[] radixSort(int[] arr, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int j = 0; j < arr.length; j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], arr[j]);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    arr[pos++] = value;
                }
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
    public static int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
