// https://leetcode.com/problems/richest-customer-wealth/

var maximumWealth = function(accounts) {
    return Math.max(...accounts.map(row => row.reduce((a, b) => a + b, 0)));
};
