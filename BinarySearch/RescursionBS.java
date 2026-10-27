package BinarySearch;

public class RescursionBS {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 5;
        int index = recu(arr, target, 0, arr.length - 1);
        System.out.println("Index of " + target + " is: " + index);
    }

    static int recu(int[] arr, int target, int s, int e) {
        if (s > e)
            return -1;
        int mid = s + (e - s) / 2;
        if (arr[mid] == target)
            return mid;
        if (arr[mid] < target) {
            return recu(arr, target, mid + 1, e);
        } else {
            return recu(arr, target, s, mid - 1);
        }

    }
}
