// https://leetcode.com/problems/my-calendar-ii/

// Solution: Double Booking Tracking — O(n) time, O(n) space
class MyCalendarTwo {
    private List<int[]> singles;
    private List<int[]> doubles;

    public MyCalendarTwo() {
        singles = new ArrayList<>();
        doubles = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] d : doubles) {
            if (start < d[1] && end > d[0]) {
                return false;
            }
        }
        for (int[] s : singles) {
            int lo = Math.max(s[0], start);
            int hi = Math.min(s[1], end);
            if (lo < hi) {
                doubles.add(new int[]{lo, hi});
            }
        }
        singles.add(new int[]{start, end});
        return true;
    }
}
