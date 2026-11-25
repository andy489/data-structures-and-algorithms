// https://leetcode.com/problems/last-stone-weight/

var lastStoneWeight = function(stones) {
    // Use sorted array as simple max heap for small n
    while (stones.length > 1) {
        stones.sort((a, b) => a - b);
        const y = stones.pop(), x = stones.pop();
        if (y !== x) stones.push(y - x);
    }
    return stones.length ? stones[0] : 0;
};
