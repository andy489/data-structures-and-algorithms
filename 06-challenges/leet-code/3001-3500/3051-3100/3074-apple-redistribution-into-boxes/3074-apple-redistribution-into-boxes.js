// https://leetcode.com/problems/apple-redistribution-into-boxes/

var minimumBoxes = function(apple, capacity) {
    const total = apple.reduce((a,b) => a+b, 0);
    capacity.sort((a,b) => b-a);
    let s = 0, count = 0;
    for (const c of capacity) {
        s += c; count++;
        if (s >= total) break;
    }
    return count;
};
