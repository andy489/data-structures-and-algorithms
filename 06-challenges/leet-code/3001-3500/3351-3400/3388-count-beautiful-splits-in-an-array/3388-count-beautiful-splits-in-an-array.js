// https://leetcode.com/problems/count-beautiful-splits-in-an-array/

var beautifulSplits = function(nums) {
    const n = nums.length;
    // lcp[i][j] = LCP length of nums[i:] and nums[j:]
    const lcp = Array.from({length: n + 1}, () => new Int32Array(n + 1));
    for (let i = n - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (nums[i] === nums[j]) {
                lcp[i][j] = lcp[i + 1][j + 1] + 1;
            }
        }
    }

    let count = 0;
    for (let i = 1; i < n - 1; i++) {
        for (let j = i + 1; j < n; j++) {
            const len1 = i, len2 = j - i, len3 = n - j;
            const condA = len1 <= len2 && lcp[0][i] >= len1;
            const condB = len2 <= len3 && lcp[i][j] >= len2;
            if (condA || condB) count++;
        }
    }
    return count;
};
