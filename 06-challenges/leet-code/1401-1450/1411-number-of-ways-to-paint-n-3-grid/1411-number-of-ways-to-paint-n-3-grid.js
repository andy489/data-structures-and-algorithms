// https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid/

var numOfWays = function(n) {
    const MOD = 1000000007n;
    let aba = 12n, abc = 6n;
    for (let i = 1; i < n; i++) {
        [aba, abc] = [(3n*aba + 2n*abc) % MOD, (2n*aba + 2n*abc) % MOD];
    }
    return Number((aba + abc) % MOD);
};
