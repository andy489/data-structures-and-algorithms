// https://leetcode.com/problems/prime-palindrome/

var primePalindrome = function(n) {
    function isPrime(x) {
        if (x < 2) return false;
        if (x < 4) return true;
        if (x % 2 === 0 || x % 3 === 0) return false;
        for (let i = 5; i * i <= x; i += 6) {
            if (x % i === 0 || x % (i + 2) === 0) return false;
        }
        return true;
    }
    function buildPal(half, len) {
        const s = String(half);
        return parseInt(s + s.slice(0, len % 2 === 1 ? s.length - 1 : s.length).split('').reverse().join(''));
    }
    for (let len = 1; len <= 9; len += 2) {
        const start = Math.pow(10, (len - 1) >> 1);
        const end = Math.pow(10, (len + 1) >> 1);
        for (let half = start; half < end; half++) {
            const pal = buildPal(half, len);
            if (pal >= n && isPrime(pal)) return pal;
        }
    }
    return -1;
};
