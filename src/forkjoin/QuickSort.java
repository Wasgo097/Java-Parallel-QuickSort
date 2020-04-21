package forkjoin;

public class QuickSort implements Sort {
    private int split(int[] tab, int start, int koniec) {
        int i = (start + koniec) / 2;
        int pivot = tab[i];
        swap(tab, i, koniec);
        int j = start;
        for (i = start; i < koniec; i++) {
            if (tab[i] < pivot) {
                swap(tab, i, j);
                j++;
            }
        }
        tab[koniec] = tab[j];
        tab[j] = pivot;
        return j;
    }

    @Override
    public void sort(int[] tab) {
        sort(tab, 0, tab.length - 1);
    }

    private void sort(int[] tab, int start, int koniec) {
        int j = split(tab, start, koniec);
        if (start < j) {
            sort(tab, start, j - 1);
        }
        if (j + 1 < koniec) {
            sort(tab, j + 1, koniec);
        }
    }

    private void swap(int[] tab, int i, int j) {
        int tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }
}