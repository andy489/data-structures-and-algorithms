// https://leetcode.com/problems/random-pick-with-weight/

var Solution = function(w) {
    this.prefixSums = [];
    let total = 0;
    for (const weight of w) {
        total += weight;
        this.prefixSums.push(total);
    }
    this.totalWeight = total;
};

Solution.prototype.pickIndex = function() {
    const target = Math.floor(Math.random() * this.totalWeight) + 1;
    let lo = 0, hi = this.prefixSums.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (this.prefixSums[mid] < target) { lo = mid + 1; }
        else { hi = mid; }
    }
    return lo;
};
