// https://leetcode.com/problems/decode-ways-ii/

var numDecodings = function(s) {
    const MOD = BigInt(1e9 + 7);
    let prev2 = 1n;
    let prev1 = s[0] === '*' ? 9n : (s[0] === '0' ? 0n : 1n);
    for (let i = 1; i < s.length; i++) {
        const cur = s[i], pre = s[i - 1];
        const single = cur === '*' ? 9n : (cur === '0' ? 0n : 1n);
        let two = 0n;
        if (pre === '*' && cur === '*') {
            two = 15n;
        } else if (pre === '*') {
            two = cur <= '6' ? 2n : 1n;
        } else if (cur === '*') {
            two = pre === '1' ? 9n : (pre === '2' ? 6n : 0n);
        } else {
            const twoNum = parseInt(pre) * 10 + parseInt(cur);
            two = (twoNum >= 10 && twoNum <= 26) ? 1n : 0n;
        }
        const curr = (single * prev1 + two * prev2) % MOD;
        prev2 = prev1;
        prev1 = curr;
    }
    return Number(prev1);
};
