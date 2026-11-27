// https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/

var minOperations = function(s) {
    let cost0 = 0;
    for (let i = 0; i < s.length; i++) {
        if (Number(s[i]) !== i % 2) {
            cost0++;
        }
    }
    return Math.min(cost0, s.length - cost0);
};
