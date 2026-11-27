// https://leetcode.com/problems/filling-bookcase-shelves/

// Solution: Dynamic Programming — O(n²) time, O(n) space
var minHeightShelves = function(books, shelfWidth) {
    const n = books.length;
    const dp = new Array(n + 1).fill(Infinity);
    dp[0] = 0;
    for (let i = 1; i <= n; i++) {
        let width = 0;
        let maxH = 0;
        for (let j = i; j >= 1; j--) {
            width += books[j - 1][0];
            if (width > shelfWidth) {
                break;
            }
            maxH = Math.max(maxH, books[j - 1][1]);
            dp[i] = Math.min(dp[i], dp[j - 1] + maxH);
        }
    }
    return dp[n];
};
