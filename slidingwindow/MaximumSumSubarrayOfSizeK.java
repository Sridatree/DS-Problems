package slidingwindow;

/*
 * Problem link : 
 * https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 */
public class MaximumSumSubarrayOfSizeK {

	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		int arr[] = { 500, 1, 1, 2, 10, 2, 3, 1, 0, 10 };
		int k = 4;
		int n = arr.length;
		int max = Integer.MIN_VALUE, sum = 0;
		int left = 0, right = 0;
		// we are letting the window until the the window size becomes k
		while (right < k) {
			sum = sum + arr[right++];
		}
		// once it become k, in the next iteration it's coming to else
		// so if the window size is 4
		// then now left will be 0 and right will be 4
		// and sum is arr[0]+arr[1]+arr[2]+arr[3]
		// we are checking for the first window
		max = Integer.max(max, sum);
		// now left =0 and right =k
		while (right < n) {
			// now we will calculate sum our current window
			// where right=k and left=1
			// so now we will add arr[4] and subtract arr[0]
			// thus sum is arr[1]+arr[2]+arr[3]+arr[4]
			sum = sum + arr[right] - arr[left];
			// checking for the current window
			max = Integer.max(max, sum);
			left++;
			right++;
		}
		System.out.println(max);
	}

}
