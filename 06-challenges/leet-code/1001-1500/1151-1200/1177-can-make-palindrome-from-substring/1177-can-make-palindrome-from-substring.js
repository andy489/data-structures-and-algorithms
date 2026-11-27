// https://leetcode.com/problems/can-make-palindrome-from-substring/

var canMakePaliQueries = function(s, queries) {
    const n = s.length;
    const prefix = new Int32Array(n + 1);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] ^ (1 << (s.charCodeAt(i) - 97));
    }
    return queries.map(([left, right, k]) => {
        const mask = prefix[right + 1] ^ prefix[left];
        let oddCount = 0;
        let m = mask;
        while (m) {
            oddCount += m & 1;
            m >>= 1;
        }
        return (oddCount >> 1) <= k;
    });
};
