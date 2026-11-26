// https://leetcode.com/problems/reverse-string-ii/
// Solution: Chunk traversal — O(n) time, O(n) space
var reverseStr = function(s, k) {
    const chars = s.split('');
    const n = chars.length;
    for (let i = 0; i < n; i += 2 * k) {
        let left = i;
        let right = Math.min(i + k - 1, n - 1);
        while (left < right) {
            [chars[left], chars[right]] = [chars[right], chars[left]];
            left++;
            right--;
        }
    }
    return chars.join('');
};
