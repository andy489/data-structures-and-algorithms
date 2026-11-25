// https://leetcode.com/problems/longest-duplicate-substring/

var longestDupSubstring = function(s) {
    const n = s.length;
    const MOD = (1n << 61n) - 1n, BASE = 31n;
    const mul = (a, b) => (a * b) % MOD;
    const check = (len) => {
        let pw = 1n;
        for (let i = 0; i < len; i++) pw = mul(pw, BASE);
        let h = 0n;
        for (let i = 0; i < len; i++) h = (mul(h, BASE) + BigInt(s.charCodeAt(i)-96)) % MOD;
        const seen = new Map([[h, [0]]]);
        for (let i = len; i < n; i++) {
            h = (mul(h, BASE) + BigInt(s.charCodeAt(i)-96) - mul(pw, BigInt(s.charCodeAt(i-len)-96)) + MOD) % MOD;
            const sub = s.slice(i-len+1, i+1);
            if (seen.has(h)) {
                for (const pos of seen.get(h)) {
                    if (s.slice(pos, pos+len) === sub) return sub;
                }
            }
            if (!seen.has(h)) seen.set(h, []);
            seen.get(h).push(i-len+1);
        }
        return null;
    };
    let lo = 1, hi = n-1, res = "";
    while (lo <= hi) {
        const mid = (lo+hi)>>1;
        const dup = check(mid);
        if (dup) { res = dup; lo = mid+1; } else { hi = mid-1; }
    }
    return res;
};
