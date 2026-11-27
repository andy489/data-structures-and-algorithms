// https://leetcode.com/problems/find-array-given-subset-sums/

// Solution: Recursive Divide and Conquer — O(n^2 * log n) time, O(n) space
class Solution {
    public int[] recoverArray(int n, int[] sums) {
        List<Integer> sumList = new ArrayList<>();
        for (int s : sums) {
            sumList.add(s);
        }
        Collections.sort(sumList);
        return solve(n, sumList);
    }

    private int[] solve(int n, List<Integer> sums) {
        if (n == 0) {
            return new int[0];
        }
        // diff = sums[last] - sums[last - 1] is the absolute value of some element
        int d = sums.get(sums.size() - 1) - sums.get(sums.size() - 2);
        // Split sums into two halves: with d and without d
        List<Integer> withD = new ArrayList<>();
        List<Integer> withoutD = new ArrayList<>();
        List<Integer> remaining = new ArrayList<>(sums);
        for (int i = sums.size() - 1; i >= 0 && withD.size() < sums.size() / 2; i--) {
            // greedy: match largest to largest - d
        }
        // Reset and use multiset approach
        TreeMap<Integer, Integer> multiset = new TreeMap<>();
        for (int s : sums) {
            multiset.merge(s, 1, Integer::sum);
        }
        withoutD.clear();
        withD.clear();
        for (int i = sums.size() - 1; i >= 0; i--) {
            int cur = sums.get(i);
            if (multiset.getOrDefault(cur, 0) == 0) {
                continue;
            }
            withD.add(cur);
            multiset.merge(cur, -1, (a, b) -> a + b <= 0 ? null : a + b);
            int prev = cur - d;
            multiset.merge(prev, -1, (a, b) -> a + b <= 0 ? null : a + b);
            withoutD.add(prev);
        }
        Collections.sort(withoutD);
        Collections.sort(withD);
        // Decide which is the half without d (the one containing 0)
        boolean zeroInWithout = Collections.binarySearch(withoutD, 0) >= 0;
        int[] rest;
        int elem;
        if (zeroInWithout) {
            rest = solve(n - 1, withoutD);
            elem = d;
        } else {
            rest = solve(n - 1, withD);
            elem = -d;
        }
        int[] result = new int[n];
        result[0] = elem;
        System.arraycopy(rest, 0, result, 1, rest.length);
        return result;
    }
}
