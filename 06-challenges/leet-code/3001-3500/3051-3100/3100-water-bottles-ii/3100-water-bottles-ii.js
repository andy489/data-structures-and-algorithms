// https://leetcode.com/problems/water-bottles-ii/

var maxBottlesDrunk = function(numBottles, numExchange) {
    let total = numBottles, empties = numBottles;
    while (empties >= numExchange) {
        empties -= numExchange; empties++; total++; numExchange++;
    }
    return total;
};
