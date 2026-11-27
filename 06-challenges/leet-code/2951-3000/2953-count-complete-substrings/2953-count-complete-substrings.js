// https://leetcode.com/problems/count-complete-substrings/
var countCompleteSubstrings = function(word, k) {
    function countInSegment(s) {
        let count = 0;
        const n = s.length;
        for (let m = 1; m <= 26; m++) {
            const windowSize = m * k;
            if (windowSize > n) {
                break;
            }
            const freq = new Array(26).fill(0);
            let satisfied = 0;
            for (let i = 0; i < windowSize; i++) {
                const c = s.charCodeAt(i) - 97;
                freq[c]++;
                if (freq[c] === k) {
                    satisfied++;
                } else if (freq[c] === k + 1) {
                    satisfied--;
                }
            }
            if (satisfied === m) {
                count++;
            }
            for (let i = windowSize; i < n; i++) {
                const addC = s.charCodeAt(i) - 97;
                freq[addC]++;
                if (freq[addC] === k) {
                    satisfied++;
                } else if (freq[addC] === k + 1) {
                    satisfied--;
                }
                const remC = s.charCodeAt(i - windowSize) - 97;
                freq[remC]--;
                if (freq[remC] === k - 1) {
                    satisfied--;
                } else if (freq[remC] === k) {
                    satisfied++;
                }
                if (satisfied === m) {
                    count++;
                }
            }
        }
        return count;
    }

    let total = 0;
    let start = 0;
    const n = word.length;
    while (start < n) {
        let end = start + 1;
        while (end < n && Math.abs(word.charCodeAt(end) - word.charCodeAt(end - 1)) <= 2) {
            end++;
        }
        total += countInSegment(word.slice(start, end));
        start = end;
    }
    return total;
};
