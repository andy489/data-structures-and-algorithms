// https://leetcode.com/problems/my-calendar-ii/

var MyCalendarTwo = function() {
    this.singles = [];
    this.doubles = [];
};

MyCalendarTwo.prototype.book = function(start, end) {
    for (const [s, e] of this.doubles) {
        if (start < e && end > s) return false;
    }
    for (const [s, e] of this.singles) {
        const lo = Math.max(s, start), hi = Math.min(e, end);
        if (lo < hi) this.doubles.push([lo, hi]);
    }
    this.singles.push([start, end]);
    return true;
};
