// https://leetcode.com/problems/decode-ways/

var numDecodings = function(s) {
    if (s[0] === '0') return 0;
    let prev2 = 1, prev1 = 1;
    for (let i = 2; i <= s.length; i++) {
        let curr = 0;
        if (s[i - 1] !== '0') curr += prev1;
        const two = parseInt(s.substring(i - 2, i));
        if (two >= 10 && two <= 26) curr += prev2;
        [prev2, prev1] = [prev1, curr];
    }
    return prev1;
};
