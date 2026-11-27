// https://leetcode.com/problems/count-collisions-on-a-road/
var countCollisions = function(directions) {
    const n = directions.length;
    let left = 0;
    while (left < n && directions[left] === 'L') {
        left++;
    }
    let right = n - 1;
    while (right >= 0 && directions[right] === 'R') {
        right--;
    }
    let collisions = 0;
    for (let i = left; i <= right; i++) {
        if (directions[i] !== 'S') {
            collisions++;
        }
    }
    return collisions;
};
