// https://leetcode.com/problems/corporate-flight-bookings/

// Solution: Difference Array — O(n + m) time, O(n) space
var corpFlightBookings = function(bookings, n) {
    const diff = new Array(n + 2).fill(0);
    for (const [first, last, seats] of bookings) {
        diff[first] += seats;
        diff[last + 1] -= seats;
    }
    const ans = [];
    let sum = 0;
    for (let i = 1; i <= n; i++) {
        sum += diff[i];
        ans.push(sum);
    }
    return ans;
};
