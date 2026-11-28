// https://leetcode.com/problems/maximize-area-of-square-hole-in-grid/

var maximizeSquareHoleArea = function(n, m, hBars, vBars) {
    function maxConsecutive(bars) {
        bars.sort((a, b) => a - b);
        let maxRun = 1, run = 1;
        for (let i = 1; i < bars.length; i++) {
            if (bars[i] === bars[i - 1] + 1) {
                run++;
                maxRun = Math.max(maxRun, run);
            } else {
                run = 1;
            }
        }
        return maxRun;
    }
    const side = Math.min(maxConsecutive(hBars), maxConsecutive(vBars)) + 1;
    return side * side;
};
