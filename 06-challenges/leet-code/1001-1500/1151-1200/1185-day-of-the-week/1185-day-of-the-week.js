// https://leetcode.com/problems/day-of-the-week/

// Solution: Day Count from Anchor Date — O(1) time, O(1) space
var dayOfTheWeek = function(day, month, year) {
    const DAYS = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const MONTH_DAYS = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

    function isLeap(y) {
        return (y % 4 === 0 && y % 100 !== 0) || (y % 400 === 0);
    }

    let total = 0;
    for (let y = 1971; y < year; y++) {
        total += isLeap(y) ? 366 : 365;
    }
    for (let m = 1; m < month; m++) {
        total += MONTH_DAYS[m - 1];
        if (m === 2 && isLeap(year)) {
            total++;
        }
    }
    total += day;
    return DAYS[(4 + total) % 7];
};

// Solution 2: Tomohiko Sakamoto's Algorithm — O(1) time, O(1) space
var dayOfTheWeek2 = function(day, month, year) {
    const DAYS = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    const T = [0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4];
    if (month < 3) {
        year--;
    }
    const d = (year + Math.floor(year / 4) - Math.floor(year / 100) + Math.floor(year / 400) + T[month - 1] + day) % 7;
    return DAYS[d];
};
