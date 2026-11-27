// https://leetcode.com/problems/minimum-possible-integer-after-at-most-k-adjacent-swaps-on-digits/

var minInteger = function(num, k) {
    const n = num.length;
    const bit = new Array(n + 1).fill(0);

    function update(i) {
        for (i++; i <= n; i += i & (-i)) bit[i]++;
    }

    function query(i) {
        let s = 0;
        for (i++; i > 0; i -= i & (-i)) s += bit[i];
        return s;
    }

    const pos = Array.from({length: 10}, () => []);
    for (let i = 0; i < n; i++) pos[Number(num[i])].push(i);
    const head = new Array(10).fill(0);

    const result = [];
    for (let i = 0; i < n; i++) {
        for (let d = 0; d <= 9; d++) {
            if (head[d] >= pos[d].length) continue;
            const j = pos[d][head[d]];
            const cost = j - query(j - 1);
            if (cost <= k) {
                k -= cost;
                head[d]++;
                update(j);
                result.push(String(d));
                break;
            }
        }
    }
    return result.join('');
};
