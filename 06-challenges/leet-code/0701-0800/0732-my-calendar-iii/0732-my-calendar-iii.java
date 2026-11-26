// https://leetcode.com/problems/my-calendar-iii/

// Solution: Difference Array (TreeMap) — O(n log n) time, O(n) space
class MyCalendarThree {
    private TreeMap<Integer, Integer> diff;

    public MyCalendarThree() {
        diff = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        diff.merge(startTime, 1, Integer::sum);
        diff.merge(endTime, -1, Integer::sum);
        int active = 0, maxK = 0;
        for (int delta : diff.values()) {
            active += delta;
            maxK = Math.max(maxK, active);
        }
        return maxK;
    }
}
