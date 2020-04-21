package forkjoin;
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    protected int split(int[] arr, int start, int end) {
        int i = (start + end) / 2;
        int pivot = arr[i];
        swap(arr, i, end);
        int j = start;
        for (i = start; i < end; i++)
            if (arr[i] < pivot) {
                swap(arr, i, j);
                j++;
            }
        arr[end] = arr[j];
        arr[j] = pivot;
        return j;
    }
    protected void sort(int[] arr, int start, int end) {
        int j = split(arr, start, end);
        if (start < j)
            sort(arr, start, j - 1);
        if (j + 1 < end)
            sort(arr, j + 1, end);
    }
    protected void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}