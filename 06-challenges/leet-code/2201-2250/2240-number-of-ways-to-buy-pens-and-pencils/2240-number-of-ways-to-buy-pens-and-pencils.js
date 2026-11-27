// https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/

/**
 * @param {number} total
 * @param {number} cost1
 * @param {number} cost2
 * @return {number}
 */
var waysToBuyPensPencils = function(total, cost1, cost2) {
    let ways = 0;
    for (let pens = 0; pens * cost1 <= total; pens++) {
        ways += Math.floor((total - pens * cost1) / cost2) + 1;
    }
    return ways;
};
