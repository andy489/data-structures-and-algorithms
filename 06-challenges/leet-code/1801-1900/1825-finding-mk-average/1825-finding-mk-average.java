// https://leetcode.com/problems/finding-mk-average/

// Solution: Three SortedMaps + Deque — O(log n) per add, O(1) per query
class MKAverage {
    private final int m, k;
    private final Deque<Integer> window;
    private final TreeMap<Integer, Integer> lower, middle, upper;
    private long middleSum;
    private int lowerSize, middleSize, upperSize;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        window = new ArrayDeque<>();
        lower = new TreeMap<>();
        middle = new TreeMap<>();
        upper = new TreeMap<>();
        middleSum = 0;
        lowerSize = middleSize = upperSize = 0;
    }

    private void addTo(TreeMap<Integer, Integer> map, int val) {
        map.merge(val, 1, Integer::sum);
    }

    private void removeFrom(TreeMap<Integer, Integer> map, int val) {
        int cnt = map.get(val);
        if (cnt == 1) map.remove(val);
        else map.put(val, cnt - 1);
    }

    private int getMin(TreeMap<Integer, Integer> map) { return map.firstKey(); }
    private int getMax(TreeMap<Integer, Integer> map) { return map.lastKey(); }

    private void moveMinToMiddle() {
        int val = getMin(lower);
        removeFrom(lower, val);
        lowerSize--;
        addTo(middle, val);
        middleSum += val;
        middleSize++;
    }

    private void moveMaxToMiddle() {
        int val = getMax(upper);
        removeFrom(upper, val);
        upperSize--;
        addTo(middle, val);
        middleSum += val;
        middleSize++;
    }

    private void moveMinFromMiddle() {
        int val = getMin(middle);
        removeFrom(middle, val);
        middleSum -= val;
        middleSize--;
        addTo(lower, val);
        lowerSize++;
    }

    private void moveMaxFromMiddle() {
        int val = getMax(middle);
        removeFrom(middle, val);
        middleSum -= val;
        middleSize--;
        addTo(upper, val);
        upperSize++;
    }

    public void addElement(int num) {
        window.addLast(num);
        // Insert into appropriate partition
        if (lowerSize < k) {
            addTo(lower, num);
            lowerSize++;
        } else if (upperSize < k) {
            addTo(upper, num);
            upperSize++;
        } else {
            addTo(middle, num);
            middleSum += num;
            middleSize++;
        }

        // Rebalance
        if (lowerSize > 0 && middleSize > 0 && getMax(lower) > getMin(middle)) {
            int lo = getMax(lower), mi = getMin(middle);
            removeFrom(lower, lo); lowerSize--;
            removeFrom(middle, mi); middleSum -= mi; middleSize--;
            addTo(middle, lo); middleSum += lo; middleSize++;
            addTo(lower, mi); lowerSize++;
        }
        if (upperSize > 0 && middleSize > 0 && getMin(upper) < getMax(middle)) {
            int up = getMin(upper), mi = getMax(middle);
            removeFrom(upper, up); upperSize--;
            removeFrom(middle, mi); middleSum -= mi; middleSize--;
            addTo(middle, up); middleSum += up; middleSize++;
            addTo(upper, mi); upperSize++;
        }

        if (window.size() > m) {
            int old = window.pollFirst();
            if (lower.containsKey(old) && lower.get(old) > 0) {
                removeFrom(lower, old);
                lowerSize--;
                if (middleSize > 0) moveMinToMiddle();
                else if (upperSize > 0) moveMaxToMiddle();
            } else if (upper.containsKey(old) && upper.get(old) > 0) {
                removeFrom(upper, old);
                upperSize--;
                if (middleSize > 0) moveMaxToMiddle();
                else if (lowerSize > 0) moveMinToMiddle();
            } else {
                removeFrom(middle, old);
                middleSum -= old;
                middleSize--;
                if (lowerSize < k) moveMinFromMiddle();
                else if (upperSize < k) moveMaxFromMiddle();
            }
        }
    }

    public long calculateMKAverage() {
        if (window.size() < m) return -1;
        return middleSum / middleSize;
    }
}
