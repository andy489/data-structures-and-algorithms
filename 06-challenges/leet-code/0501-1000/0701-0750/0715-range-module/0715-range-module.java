// https://leetcode.com/problems/range-module/

// Solution: Sorted List of Disjoint Intervals — O(n) per op, O(n) space
class RangeModule {
    private final TreeMap<Integer, Integer> intervals;

    public RangeModule() {
        intervals = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        Integer lo = intervals.floorKey(right);
        if (lo != null && intervals.get(lo) >= left) {
            left = Math.min(left, lo);
            right = Math.max(right, intervals.get(lo));
        }
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) >= left) {
            left = Math.min(left, start);
            right = Math.max(right, intervals.get(start));
        }
        intervals.subMap(left, right).clear();
        intervals.put(left, right);
    }

    public boolean queryRange(int left, int right) {
        Integer lo = intervals.floorKey(left);
        return lo != null && intervals.get(lo) >= right;
    }

    public void removeRange(int left, int right) {
        Integer lo = intervals.floorKey(right);
        if (lo != null && intervals.get(lo) > right) {
            intervals.put(right, intervals.get(lo));
        }
        Integer start = intervals.floorKey(left);
        if (start != null && intervals.get(start) > left) {
            intervals.put(start, left);
        }
        intervals.subMap(left, right).clear();
    }
}
