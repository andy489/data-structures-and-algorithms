// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

var shortestBeautifulSubstring = function(s, k) {
    const n = s.length;
    let result = "";
    let minLen = n + 1;
    let left = 0, ones = 0;

    for (let right = 0; right < n; right++) {
        if (s[right] === '1') ones++;
        while (ones === k) {
            const sub = s.slice(left, right + 1);
            const len = right - left + 1;
            if (len < minLen || (len === minLen && sub < result)) {
                minLen = len;
                result = sub;
            }
            if (s[left] === '1') ones--;
            left++;
        }
    }
    return result;
};
