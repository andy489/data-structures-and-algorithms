// https://leetcode.com/problems/maximum-number-of-balls-in-a-box/

var countBalls = function(lowLimit, highLimit) {
    const count = new Array(46).fill(0);
    let max = 0;
    for (let i = lowLimit; i <= highLimit; i++) {
        let s = 0, n = i;
        while (n > 0) {
            s += n % 10;
            n = Math.floor(n / 10);
        }
        max = Math.max(max, ++count[s]);
    }
    return max;
};
