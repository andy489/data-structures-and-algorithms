// https://leetcode.com/problems/random-point-in-non-overlapping-rectangles/

var Solution = function(rects) {
    this.rects = rects;
    this.prefixSums = [];
    let cumulative = 0;
    for (const r of rects) {
        cumulative += (r[2] - r[0] + 1) * (r[3] - r[1] + 1);
        this.prefixSums.push(cumulative);
    }
    this.total = cumulative;
};

Solution.prototype.pick = function() {
    const target = Math.floor(Math.random() * this.total);
    let lo = 0, hi = this.rects.length - 1;
    while (lo < hi) {
        const mid = (lo + hi) >> 1;
        if (this.prefixSums[mid] <= target) lo = mid + 1;
        else hi = mid;
    }
    const rect = this.rects[lo];
    const offset = target - (lo > 0 ? this.prefixSums[lo - 1] : 0);
    const width = rect[2] - rect[0] + 1;
    return [rect[0] + offset % width, rect[1] + Math.floor(offset / width)];
};
