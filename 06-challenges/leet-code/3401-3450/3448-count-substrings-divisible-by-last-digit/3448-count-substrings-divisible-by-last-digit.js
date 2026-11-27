// https://leetcode.com/problems/count-substrings-divisible-by-last-digit/
var countSubstrings = function(s) {
    const n = s.length;
    let total = 0;
    for (let r = 0; r < n; r++) {
        const d = parseInt(s[r]);
        if (d === 0) continue;
        let num = 0, pow10 = 1;
        for (let l = r; l >= 0; l--) {
            const digit = parseInt(s[l]);
            num = (num + digit * pow10) % d;
            pow10 = pow10 * 10 % d;
            if (num === 0) total++;
        }
    }
    return total;
};
