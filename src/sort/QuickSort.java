package sort;

/**
 * Created by Sigal0Lab on 15/6/18.
 */
public class QuickSort {

    private Presence presence;

    public QuickSort() {

    }

    public QuickSort(Presence presence) {
        this.presence = presence;
    }

    public void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        if (start < 0) {
            throw new ArrayIndexOutOfBoundsException("start:" + start);
        }
        if (end < 0 || end > a.length - 1) {
            throw new ArrayIndexOutOfBoundsException("end: " + end);
        }

        int i = partition(a, start, end);

        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }

    private int partition(int[] a, int start, int end) {
        int i = start - 1;
        int j = start;
        int pivot = a[end];

        while (j <= end) {
            presence.showGraphics();
            if (a[j] <= pivot) {
                ++i;
                if (j != i) {
                    a[i] ^= a[j];
                    a[j] ^= a[i];
                    a[i] ^= a[j];
                }
            }
            j++;
        }
        return i;
    }
}
