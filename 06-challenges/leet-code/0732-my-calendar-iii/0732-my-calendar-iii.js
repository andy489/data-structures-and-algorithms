// https://leetcode.com/problems/my-calendar-iii/

var MyCalendarThree = function() {
    this.diff = new Map();
};

MyCalendarThree.prototype.book = function(startTime, endTime) {
    this.diff.set(startTime, (this.diff.get(startTime) || 0) + 1);
    this.diff.set(endTime, (this.diff.get(endTime) || 0) - 1);
    const keys = [...this.diff.keys()].sort((a, b) => a - b);
    let active = 0, maxK = 0;
    for (const k of keys) {
        active += this.diff.get(k);
        maxK = Math.max(maxK, active);
    }
    return maxK;
};
