package binarysearch;

/*
 * Problem link :
 * https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1
 * 
 * */
public class FindMaximumInBitonicArray {

	public static void main(String[] args) {
		type2();
		type3();
	}

	private static void type3() {
		int arr[] = { 1, 15, 25, 45, 42, 21, 17, 12, 11 };
		int item = findMaximum(arr, arr.length);
		System.out.println(item);
	}

	private static int findMaximum(int arr[], int n) {
		int low = 1, high = n - 2;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			} else if (arr[mid - 1] > arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return arr[low];
	}

	private static void type2() {
		int arr[] = { 1, 15, 25, 45, 42, 21, 17, 12, 11 };
		int low = 0;
		int high = arr.length - 1;
		int index = findMaximumInBitonicArray(arr, low, high, arr.length);
		System.out.println(String.format("arr[%d] : %d", index, arr[index]));
	}

	private static int findMaximumInBitonicArray(int[] arr, int low, int high, int n) {
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (mid > 0 && mid < n - 1) {
				if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
					return mid;
				} else if (arr[mid] > arr[mid - 1]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (mid == 0) {
				return arr[0] > arr[1] ? 0 : 1;
			} else {
				return arr[n - 1] > arr[n - 2] ? n - 1 : n - 2;
			}
		}
		return -1;
	}

}
