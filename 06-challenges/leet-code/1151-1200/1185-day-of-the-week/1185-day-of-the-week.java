// https://leetcode.com/problems/day-of-the-week/

// Solution: Day Count from Anchor Date — O(1) time, O(1) space
class Solution {
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] MONTH_DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int total = 0;
        for (int y = 1971; y < year; y++) {
            total += isLeap(y) ? 366 : 365;
        }
        for (int m = 1; m < month; m++) {
            total += MONTH_DAYS[m - 1];
            if (m == 2 && isLeap(year)) {
                total++;
            }
        }
        total += day;
        // Jan 1 1971 was Friday (index 5), total=1 → (4 + 1) % 7 = 5 ✓
        return DAYS[(4 + total) % 7];
    }

    private boolean isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}

// Solution 2: Tomohiko Sakamoto's Algorithm — O(1) time, O(1) space
class Solution2 {
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] T = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

    public String dayOfTheWeek(int day, int month, int year) {
        if (month < 3) {
            year--;
        }
        int d = (year + year / 4 - year / 100 + year / 400 + T[month - 1] + day) % 7;
        return DAYS[d];
    }
}
