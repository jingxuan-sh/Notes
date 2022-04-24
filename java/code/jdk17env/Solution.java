class Solution {
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int p, int r) {
        if (p >= r) return;

        int q = partition(array, p, r);
        quickSort(array, p, q - 1);
        quickSort(array, q + 1, r);
    }

    private static int partition(int[] array, int p, int r) {
        int x = array[r];
        int i = p - 1;
        int j = p;
        while (j < r) {
            if (array[j] <= x) {
                swap(array, ++i, j);
            }
            j++;
        }
        swap(array, ++i, r);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 23, 12, 35, 7};
        quickSort(array);
        System.out.println(array);
}
