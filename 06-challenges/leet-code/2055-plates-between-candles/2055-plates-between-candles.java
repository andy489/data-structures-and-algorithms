// https://leetcode.com/problems/plates-between-candles/

// Solution: Prefix Sums + Binary Search — O((n+q) log n) time, O(n) space
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefix = new int[n + 1];
        List<Integer> candles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '*' ? 1 : 0);
            if (s.charAt(i) == '|') { candles.add(i); }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int cl = lowerBound(candles, l), cr = upperBound(candles, r) - 1;
            if (cl < cr) { res[i] = prefix[candles.get(cr) + 1] - prefix[candles.get(cl)]; }
        }
        return res;
    }
    private int lowerBound(List<Integer> list, int val) {
        int lo = 0, hi = list.size();
        while (lo < hi) { int mid = (lo + hi) / 2; if (list.get(mid) < val) { lo = mid + 1; } else { hi = mid; } }
        return lo;
    }
    private int upperBound(List<Integer> list, int val) {
        int lo = 0, hi = list.size();
        while (lo < hi) { int mid = (lo + hi) / 2; if (list.get(mid) <= val) { lo = mid + 1; } else { hi = mid; } }
        return lo;
    }
}
