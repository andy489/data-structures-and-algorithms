// https://leetcode.com/problems/find-smallest-letter-greater-than-target/

var nextGreatestLetter = function(letters, target) {
    let lo = 0, hi = letters.length;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (letters[mid] <= target) lo = mid + 1;
        else hi = mid;
    }
    return letters[lo % letters.length];
};
