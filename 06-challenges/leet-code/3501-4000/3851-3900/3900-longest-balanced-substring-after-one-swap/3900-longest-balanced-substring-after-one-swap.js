// https://leetcode.com/problems/longest-balanced-substring-after-one-swap/
/**
 * @param {string} s
 * @return {number}
 */
var longestBalancedSubstring = function(s) {
    let total0 = 0, total1 = 0;
    for (const c of s) {
        if (c === '0') {
            total0++;
        } else {
            total1++;
        }
    }

    let best = 0;
    let cnt0 = 0, cnt1 = 0;
    let left = 0;

    for (let right = 0; right < s.length; right++) {
        if (s[right] === '0') {
            cnt0++;
        } else {
            cnt1++;
        }

        // Shrink window while imbalance > 2
        while (Math.abs(cnt0 - cnt1) > 2) {
            if (s[left] === '0') {
                cnt0--;
            } else {
                cnt1--;
            }
            left++;
        }

        const length = right - left + 1;
        if (cnt0 === cnt1) {
            best = Math.max(best, length);
        } else if (cnt0 - cnt1 === 2 && (total1 - cnt1) >= 1) {
            best = Math.max(best, length - 1);
        } else if (cnt1 - cnt0 === 2 && (total0 - cnt0) >= 1) {
            best = Math.max(best, length - 1);
        }
    }

    // Result must be even
    if (best % 2 !== 0) {
        best--;
    }
    return best;
};
