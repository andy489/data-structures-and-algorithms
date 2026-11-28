// https://leetcode.com/problems/unique-3-digit-even-numbers/

var totalNumbers = function(digits) {
    const freq = new Array(10).fill(0);
    for (const d of digits) freq[d]++;
    let count = 0;
    for (let num = 100; num <= 998; num += 2) {
        const h = Math.floor(num / 100);
        const t = Math.floor(num / 10) % 10;
        const u = num % 10;
        freq[h]--; freq[t]--; freq[u]--;
        if (freq[h] >= 0 && freq[t] >= 0 && freq[u] >= 0) count++;
        freq[h]++; freq[t]++; freq[u]++;
    }
    return count;
};
