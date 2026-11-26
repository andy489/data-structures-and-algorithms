// https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/

var busyStudent = function(startTime, endTime, queryTime) {
    return startTime.filter((s,i) => s <= queryTime && queryTime <= endTime[i]).length;
};
