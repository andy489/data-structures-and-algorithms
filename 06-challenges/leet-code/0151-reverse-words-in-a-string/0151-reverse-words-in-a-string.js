// https://leetcode.com/problems/reverse-words-in-a-string/

// Solution 1: Split + reverse — O(n) time, O(n) space
var reverseWords = function(s) {
    return s.trim().split(/\s+/).reverse().join(' ');
};

// Solution 2: Reverse all then reverse each word — O(n) time, O(n) space
var reverseWords2 = function(s) {
    const arr = s.trim().split('');
    const n = arr.length;

    const reverse = (lo, hi) => {
        while (lo < hi) {
            [arr[lo], arr[hi]] = [arr[hi], arr[lo]];
            lo++; hi--;
        }
    };

    reverse(0, n - 1);
    let start = 0, write = 0;
    while (start < n) {
        while (start < n && arr[start] === ' ') start++;
        if (start === n) break;
        if (write > 0) arr[write++] = ' ';
        let end = start;
        while (end < n && arr[end] !== ' ') arr[write++] = arr[end++];
        reverse(write - (end - start), write - 1);
        start = end;
    }
    return arr.slice(0, write).join('');
};
