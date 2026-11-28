// https://leetcode.com/problems/lexicographically-smallest-generated-string/

var generateString = function(str1, str2) {
    const n = str1.length, m = str2.length;
    const word = new Array(n + m - 1).fill('a');
    // Stamp all T positions
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'T') {
            for (let j = 0; j < m; j++) {
                if (word[i + j] !== 'a' && word[i + j] !== str2[j]) return "";
                word[i + j] = str2[j];
            }
        }
    }
    // Fix F positions
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'F') {
            let match = true;
            for (let j = 0; j < m; j++) {
                if (word[i + j] !== str2[j]) { match = false; break; }
            }
            if (match) {
                const pos = i + m - 1;
                let forced = false;
                for (let k = Math.max(0, pos - m + 1); k <= Math.min(n - 1, pos); k++) {
                    if (str1[k] === 'T') { forced = true; break; }
                }
                if (forced) return "";
                word[pos] = String.fromCharCode(word[pos].charCodeAt(0) + 1);
            }
        }
    }
    // Validate T windows
    for (let i = 0; i < n; i++) {
        if (str1[i] === 'T') {
            for (let j = 0; j < m; j++) {
                if (word[i + j] !== str2[j]) return "";
            }
        }
    }
    return word.join('');
};
