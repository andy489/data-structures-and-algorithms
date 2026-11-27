// https://leetcode.com/problems/take-gifts-from-the-richest-pile/

// Solution: Max-Heap (sorted array simulation) — O((n + k) log n) time, O(n) space
var pickGifts = function(gifts, k) {
    // Use a max-heap via sorted array for simplicity given small constraints
    gifts.sort((a, b) => b - a);
    for (let i = 0; i < k; i++) {
        gifts[0] = Math.floor(Math.sqrt(gifts[0]));
        // Re-sort: insert gifts[0] back in sorted position
        let j = 0;
        while (j + 1 < gifts.length && gifts[j] < gifts[j + 1]) {
            [gifts[j], gifts[j + 1]] = [gifts[j + 1], gifts[j]];
            j++;
        }
    }
    return gifts.reduce((sum, g) => sum + g, 0);
};
