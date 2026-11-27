// https://leetcode.com/problems/maximize-distance-to-closest-person/

var maxDistToClosest = function(seats) {
    const n = seats.length;
    let ans = 0, last = -1;
    for (let i = 0; i < n; i++) {
        if (seats[i] === 1) {
            ans = last === -1 ? i : Math.max(ans, Math.floor((i - last) / 2));
            last = i;
        }
    }
    return Math.max(ans, n - 1 - last);
};
