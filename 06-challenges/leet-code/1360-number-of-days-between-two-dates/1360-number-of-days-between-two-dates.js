// https://leetcode.com/problems/number-of-days-between-two-dates/

var daysBetweenDates = function(date1, date2) {
    return Math.abs(new Date(date1)-new Date(date2))/86400000|0;
};
