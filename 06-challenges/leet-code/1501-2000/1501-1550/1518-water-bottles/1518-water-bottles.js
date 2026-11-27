// https://leetcode.com/problems/water-bottles/

var numWaterBottles = function(numBottles, numExchange) {
    let drunk = 0, empty = 0;
    while (numBottles > 0) {
        drunk += numBottles;
        empty += numBottles;
        numBottles = Math.floor(empty / numExchange);
        empty = empty % numExchange;
    }
    return drunk;
};
