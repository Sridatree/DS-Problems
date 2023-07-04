package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AggresiveCows {

	// Given an array of length �N�, where each element denotes the position of a
	// stall. Now you have �N� stalls and an integer �K� which denotes the number of
	// cows that are aggressive. To prevent the cows from hurting each other, you
	// need to assign the cows to the stalls, such that the minimum distance between
	// any two of them is as large as possible. Return the largest minimum distance.
	public static void main(String[] args) {
		type1();
	}

	private static void type1() {
		List<Integer> stalls = new ArrayList<>(List.of(18, 27, 44, 77, 69, 19, 35, 83, 9, 64));
		// if the input is not sorted then we will sort the input increasing order
		Collections.sort(stalls);
		int k = 4;
		// low will be zero as at minimum we can place two cows in same stall
		// high will be difference between first and last stall
		int low = 0, high = stalls.get(stalls.size() - 1) - stalls.get(0), mid, answer = -1;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (allocationPossible(stalls, k, mid)) {
				answer = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		System.out.println(answer);

	}

	private static boolean allocationPossible(List<Integer> stalls, int k, int distance) {
		// number of cows that can be possible with this distance
		int cows = 1;
		int prevCow = stalls.get(0);
		for (int i = 1; i < stalls.size(); i++) {
			if (stalls.get(i) - prevCow >= distance) {
				cows++;
				prevCow = stalls.get(i);
			}
		}
		return cows >= k;
	}

}
