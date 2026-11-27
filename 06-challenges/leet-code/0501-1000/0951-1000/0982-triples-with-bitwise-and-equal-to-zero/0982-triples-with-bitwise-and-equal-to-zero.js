// https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/

var countTriplets = function(nums) {
    const pairCount = new Int32Array(1 << 16);
    for (const a of nums) for (const b of nums) pairCount[a & b]++;
    let ans = 0;
    for (const c of nums) {
        for (let v = 0; v < (1 << 16); v++) {
            if (pairCount[v] && (v & c) === 0) ans += pairCount[v];
        }
    }
    return ans;
};
