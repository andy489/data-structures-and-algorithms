// https://leetcode.com/problems/my-calendar-i/

class MyCalendar {
    constructor() {
        this.events = [];
    }

    book(startTime, endTime) {
        for (const [s, e] of this.events) {
            if (Math.max(s, startTime) < Math.min(e, endTime)) return false;
        }
        this.events.push([startTime, endTime]);
        return true;
    }
}
