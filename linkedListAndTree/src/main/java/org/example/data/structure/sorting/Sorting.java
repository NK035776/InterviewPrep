package org.example.data.structure.sorting;

import java.util.Arrays;

public class Sorting {

    public static void MergeSort(int[] a) {
        int length = a.length;
        int mid = length/2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];
        if (length/2 == 1) {
            return;
        }
        for(int i = 0; i <= mid - 1; i++) {
            left[i] = a[i];
        }
        for(int i = mid; i < length; i++) {
            right[i - mid] = a[i];
        }
        MergeSort(left);
        MergeSort(right);
        merge(left, right, a);

        System.out.println(Arrays.toString(a));
    }

    public static void merge(int[] L, int[] R, int[] a) {
        int nL = L.length;
        int nR = L.length;
        int iL =0,jR = 0,k =0;

        while (iL < nL && jR < nR) {
            if (L[iL] <= R[jR]) {
                a[k] = L[iL];
                iL++;
            } else {
                a[k] = R[jR];
                jR++;
            }
            k++;
        }
        while (iL < nL) {
            a[k] = L[iL];
            iL++; k++;
        }
        while (jR < nR) {
            a[k] = R[jR];
            jR++; k++;
        }
    }

    public static void QuickSort(int[] a, int start, int end) {

        if (start < end) {
            int pIndex = Partition(a, start, end);
            QuickSort(a, start, pIndex - 1);
            QuickSort(a, pIndex + 1, end);
        }

    }

    public static int Partition(int[] a, int start, int end) {
        int pivot = a[end];
        int pIndex = start;
        int tmp = 0;

        for (int i = 0; i <= end-1; i++) {
            if (a[i] <= pivot ) {
                //swap
                tmp = a[i];
                a[i] = a[pIndex];
                a[pIndex] = tmp;

                pIndex ++;
            }
        }
        // swap pivot to pIndex
        tmp = a[pIndex];
        a[pIndex] = a[end];
        a[end] = tmp;

        return pIndex;
    }

    void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}
