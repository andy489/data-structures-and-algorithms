// https://leetcode.com/problems/data-stream-as-disjoint-intervals/

// Solution: Sorted Array Interval Merge — O(n) add, O(n) getIntervals, O(n) space
class SummaryRanges {
    constructor() {
        this.intervals = [];
    }

    addNum(value) {
        const newInterval = [value, value];
        const result = [];
        let inserted = false;

        for (const [start, end] of this.intervals) {
            if (end + 1 < newInterval[0]) {
                result.push([start, end]);
            } else if (start - 1 > newInterval[1]) {
                if (!inserted) {
                    result.push(newInterval);
                    inserted = true;
                }
                result.push([start, end]);
            } else {
                newInterval[0] = Math.min(newInterval[0], start);
                newInterval[1] = Math.max(newInterval[1], end);
            }
        }

        if (!inserted) result.push(newInterval);
        this.intervals = result;
    }

    getIntervals() {
        return this.intervals;
    }
}
