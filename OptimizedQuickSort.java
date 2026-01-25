/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author Yasali
 */
public class OptimizedQuickSort {

    // Median-of-three pivot
    static int medianPivot(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        int a = arr[low], b = arr[mid], c = arr[high];

        if ((a > b) == (a < c)) return low;
        else if ((b > a) == (b < c)) return mid;
        else return high;
    }

    static int partition(int[] arr, int low, int high) {
        int pivotIndex = medianPivot(arr, low, high);
        int pivot = arr[pivotIndex];

        // Swap pivot with last element
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        // Swap pivot to correct position
        arr[high] = arr[i + 1];
        arr[i + 1] = pivot;

        return i + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length - 1);

        for (int x : arr)
            System.out.print(x + " ");
    }
}

