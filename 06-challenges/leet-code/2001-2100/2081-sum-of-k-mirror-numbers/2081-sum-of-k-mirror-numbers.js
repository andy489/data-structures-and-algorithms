// https://leetcode.com/problems/sum-of-k-mirror-numbers/

// Solution: Enumerate Base-10 Palindromes — O(n * L) time, O(L) space
var kMirror = function(k, n) {
    const toBase = (num, base) => {
        if (!num) return '0';
        let s = '';
        while (num) { s = (num % base) + s; num = Math.floor(num / base); }
        return s;
    };
    const isPalin = (s) => s === [...s].reverse().join('');
    const genPalins = function*(len) {
        const half = Math.floor((len + 1) / 2);
        for (let h = 10**(half-1); h < 10**half; h++) {
            const s = String(h);
            const p = len % 2 === 0 ? s + [...s].reverse().join('') : s + [...s.slice(0,-1)].reverse().join('');
            yield parseInt(p);
        }
    };
    let total = 0, found = 0;
    for (let len = 1; found < n; len++) {
        for (const p of genPalins(len)) {
            if (isPalin(toBase(p, k))) { total += p; if (++found === n) return total; }
        }
    }
    return total;
};
