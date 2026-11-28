// https://leetcode.com/problems/make-three-strings-equal/

var findMinimumOperations = function(s1, s2, s3) {
    const minLen = Math.min(s1.length, s2.length, s3.length);
    let prefix = 0;
    for (let i = 0; i < minLen; i++) {
        if (s1[i] === s2[i] && s2[i] === s3[i]) {
            prefix++;
        } else {
            break;
        }
    }
    if (prefix === 0) return -1;
    return (s1.length - prefix) + (s2.length - prefix) + (s3.length - prefix);
};
