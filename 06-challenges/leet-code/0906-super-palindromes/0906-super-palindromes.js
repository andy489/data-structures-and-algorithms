// https://leetcode.com/problems/super-palindromes/

var superpalindromesInRange = function(left, right) {
    const L = BigInt(left), R = BigInt(right);
    let count = 0;
    const isPal = x => { const s = String(x); return s === s.split('').reverse().join(''); };
    for (let k = 1; k < 100000; k++) {
        const s = String(k);
        // odd
        let p = BigInt(s + s.slice(0, -1).split('').reverse().join(''));
        let sq = p * p;
        if (sq > R) break;
        if (sq >= L && isPal(sq)) count++;
        // even
        p = BigInt(s + s.split('').reverse().join(''));
        sq = p * p;
        if (sq > R) break;
        if (sq >= L && isPal(sq)) count++;
    }
    return count;
};
