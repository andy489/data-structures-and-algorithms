// https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/

var makeStringGood = function(s) {
    const freq = new Array(26).fill(0);
    for (const c of s) freq[c.charCodeAt(0) - 97]++;

    const maxFreq = Math.max(...freq);
    let ans = s.length;

    for (let k = 0; k <= maxFreq; k++) {
        let cost = 0, carry = 0;
        for (let i = 0; i < 26; i++) {
            const f = freq[i] + carry;
            if (k === 0) {
                cost += freq[i];
                carry = 0;
            } else if (f > k) {
                carry = f - k;
            } else if (f < k) {
                cost += Math.min(k - f, freq[i]);
                carry = 0;
            } else {
                carry = 0;
            }
        }
        ans = Math.min(ans, cost);
    }
    return ans;
};
