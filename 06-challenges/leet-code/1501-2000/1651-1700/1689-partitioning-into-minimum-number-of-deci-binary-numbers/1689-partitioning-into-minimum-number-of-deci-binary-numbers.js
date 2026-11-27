// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

var minPartitions = function(n) {
    return parseInt(Math.max(...n.split('').map(Number)));
};
