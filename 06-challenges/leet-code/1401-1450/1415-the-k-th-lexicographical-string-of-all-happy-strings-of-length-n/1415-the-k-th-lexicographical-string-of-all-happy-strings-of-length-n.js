// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

var getHappyString = function(n, k) {
    const total = 3 * (1 << (n-1));
    if (k > total) return "";
    const res = [];
    let prev = '';
    for (let i = 0; i < n; i++) {
        const perChar = 1 << (n-1-i);
        for (const c of 'abc') {
            if (c === prev) continue;
            if (perChar >= k) { res.push(c); prev = c; break; }
            k -= perChar;
        }
    }
    return res.join('');
};
