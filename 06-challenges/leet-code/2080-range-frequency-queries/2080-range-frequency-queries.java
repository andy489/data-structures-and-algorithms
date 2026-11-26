// https://leetcode.com/problems/range-frequency-queries/

// Solution: Binary Search on Precomputed Indices — O(n) build, O(log n) query
class RangeFreqQuery {
    private Map<Integer, List<Integer>> indices = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) { indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i); }
    }

    public int query(int left, int right, int value) {
        List<Integer> list = indices.getOrDefault(value, Collections.emptyList());
        int lo = lowerBound(list, left), hi = upperBound(list, right);
        return hi - lo;
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
