// https://leetcode.com/problems/number-of-days-between-two-dates/

// Solution: Day counting — O(1) time, O(1) space
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(daysFrom1971(date1) - daysFrom1971(date2));
    }
    private int daysFrom1971(String date) {
        int y = Integer.parseInt(date.substring(0,4));
        int m = Integer.parseInt(date.substring(5,7));
        int d = Integer.parseInt(date.substring(8,10));
        int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
        int days = d;
        for (int i = 0; i < m-1; i++) days += months[i];
        if (m > 2 && isLeap(y)) days++;
        for (int i = 1971; i < y; i++) days += isLeap(i) ? 366 : 365;
        return days;
    }
    private boolean isLeap(int y) { return y%4==0 && (y%100!=0 || y%400==0); }
}
