// https://leetcode.com/problems/binary-gap/

var binaryGap = function(n) {
    let last = -1, ans = 0, i = 0;
    while (n) {
        if (n & 1) {
            if (last !== -1) ans = Math.max(ans, i - last);
            last = i;
        }
        n >>= 1; i++;
    }
    return ans;
};
