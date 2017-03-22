package com.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Jomon Thanuvelil Johny
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class CollectionUtil {

	public static ArrayList<String> union(Collection coll1, Collection coll2) {
		ArrayList<String> union = new ArrayList(coll1);
		union.addAll(new ArrayList(coll2));
		return union;
	}

	public static Collection intersect(Collection coll1, Collection coll2) {
		List intersection = new ArrayList(coll1);
		intersection.retainAll(new ArrayList(coll2));
		return intersection;
	}

	public static Collection nonOverLap(Collection coll1, Collection coll2) {
		Collection result = union(coll1, coll2);
		result.removeAll(intersect(coll1, coll2));
		return result;
	}

	public static ArrayList<String> diff(List<String> list1, List<String> list2) {
		ArrayList<String> diffList = new ArrayList<String>();

		String[] x = new String[list1.size()];
		String[] y = new String[list2.size()];

		x = list1.toArray(x);
		y = list2.toArray(y);
		// number of lines of each file
		int M = x.length;
		int N = y.length;

		// opt[i][j] = length of LCS of x[i..M] and y[j..N]
		int[][] opt = new int[M + 1][N + 1];

		// compute length of LCS and all subproblems via dynamic programming
		for (int i = M - 1; i >= 0; i--) {
			for (int j = N - 1; j >= 0; j--) {
				if (x[i].equals(y[j]))
					opt[i][j] = opt[i + 1][j + 1] + 1;
				else
					opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
			}
		}

		// recover LCS itself and add the non-matching lines to the diff list.
		// LCS :: Longest Common Subsequence
		int i = 0, j = 0;
		while (i < M && j < N) {
			if (x[i].equals(y[j])) {
				i++;
				j++;
			} else if (opt[i + 1][j] >= opt[i][j + 1]) {
				i++;
				// diffList.add(x[i++]);
			} else {
				diffList.add(y[j++]);
			}
		}

		// dump out one remainder of one string if the other is exhausted
		while (i < M || j < N) {
			if (i == M) {
				diffList.add(y[j++]);
			} else if (j == N) {
				i++;
				// diffList.add(x[i++]);
			}
		}
		return diffList;
	}

}
