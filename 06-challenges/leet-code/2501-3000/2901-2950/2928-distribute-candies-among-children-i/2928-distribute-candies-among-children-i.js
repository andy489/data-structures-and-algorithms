// https://leetcode.com/problems/distribute-candies-among-children-i/

var distributeCandies = function(n, limit) {
    let count = 0;
    for (let i = 0; i <= limit; i++) {
        for (let j = 0; j <= limit; j++) {
            const k = n - i - j;
            if (k >= 0 && k <= limit) {
                count++;
            }
        }
    }
    return count;
};
