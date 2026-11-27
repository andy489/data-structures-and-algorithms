// https://leetcode.com/problems/day-of-the-year/

var dayOfYear = function(date) {
    const year = parseInt(date.substring(0, 4));
    const month = parseInt(date.substring(5, 7));
    const day = parseInt(date.substring(8));
    const days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    if (year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0)) {
        days[1] = 29;
    }
    let result = day;
    for (let i = 0; i < month - 1; i++) {
        result += days[i];
    }
    return result;
};
