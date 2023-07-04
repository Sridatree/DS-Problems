package array;

/*
 * Question link : https://leetcode.com/problems/merge-intervals/
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlappingSubintervals {

	public static void main(String[] args) {
		type1();
	}

	// optimized approach
	private static void type1() {
		// int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 11 }, { 9, 10 }, { 15, 18 } };
		int[][] intervals = { { 1, 4 }, { 3, 5 }, { 0, 2 } };
		// given than intervals are sorted by their starting time
		// else we have to sort it manually
		Arrays.sort(intervals, (first, second) -> Integer.compare(first[0], second[0]));
		List<int[]> newIntervals = new ArrayList<>();
		newIntervals.add(intervals[0]);
		int[] last = intervals[0];
		for (int i = 1; i < intervals.length; i++) {
			if (last[1] >= intervals[i][0]) {
				last[1] = Math.max(last[1], intervals[i][1]);
			} else {
				newIntervals.add(intervals[i]);
				last = intervals[i];
			}
		}
		int[][] answer = new int[newIntervals.size()][2];
		for (int i = 0; i < newIntervals.size(); i++) {
			answer[i] = newIntervals.get(i);
		}

	}

}
