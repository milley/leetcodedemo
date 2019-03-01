package com.milley.structure.sorts;

public class MergeSort {
    // 归并排序算法，a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n - 1);
    }

    private static void mergeSortInternally(int[] a, int p, int r) {
        if (p >= r) return;
        int q = p + (r - p) / 2;
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        // 拷贝剩余的数组到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将临时数组tmp中的元素拷贝回a[p...r]
        for (i = 0; i <= r - p; i++) {
            a[p + i] = tmp[i];
        }
    }

    public static void printAll(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
