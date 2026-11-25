// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

var minKBitFlips = function(nums, k) {
    const n = nums.length;
    const flip = new Int8Array(n);
    let flipped = 0, ans = 0;
    for (let i = 0; i < n; i++) {
        if (i >= k) flipped ^= flip[i - k];
        if ((nums[i] ^ flipped) === 0) {
            if (i + k > n) return -1;
            flip[i] = 1;
            flipped ^= 1;
            ans++;
        }
    }
    return ans;
};
