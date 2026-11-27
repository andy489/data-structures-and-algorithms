// https://leetcode.com/problems/powerful-integers/

var powerfulIntegers = function(x, y, bound) {
    const res = new Set();
    for (let xi = 1; xi <= bound; xi = x === 1 ? bound + 1 : xi * x) {
        for (let yj = 1; xi + yj <= bound; yj = y === 1 ? bound + 1 : yj * y) {
            res.add(xi + yj);
        }
    }
    return [...res];
};
