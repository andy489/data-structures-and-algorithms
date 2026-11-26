// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

// Solution: Sort Both Arrays — O(n log n) time, O(1) space
var minMovesToSeat = function(seats, students) {
    seats.sort((a, b) => a - b);
    students.sort((a, b) => a - b);
    return seats.reduce((acc, s, i) => acc + Math.abs(s - students[i]), 0);
};
