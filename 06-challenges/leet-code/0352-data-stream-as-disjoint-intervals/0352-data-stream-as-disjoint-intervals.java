// https://leetcode.com/problems/data-stream-as-disjoint-intervals/

// Solution: TreeMap Interval Merge — O(log n) add, O(n) getIntervals, O(n) space
class SummaryRanges {
    private final TreeMap<Integer, Integer> map = new TreeMap<>();

    public void addNum(int value) {
        Integer lo = map.floorKey(value);
        Integer hi = map.ceilingKey(value);

        if (lo != null && map.get(lo) >= value) {
            return;
        }

        int start = value, end = value;

        if (lo != null && map.get(lo) + 1 >= value) {
            start = lo;
            end = Math.max(end, map.get(lo));
            map.remove(lo);
        }
        if (hi != null && hi <= value + 1) {
            end = Math.max(end, map.get(hi));
            map.remove(hi);
        }

        map.put(start, end);
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int i = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            res[i][0] = e.getKey();
            res[i][1] = e.getValue();
            i++;
        }
        return res;
    }
}
