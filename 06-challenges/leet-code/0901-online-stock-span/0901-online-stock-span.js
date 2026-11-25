// https://leetcode.com/problems/online-stock-span/

var StockSpanner = function() {
    this.stack = [];
};

StockSpanner.prototype.next = function(price) {
    let span = 1;
    while (this.stack.length && this.stack[this.stack.length - 1][0] <= price) {
        span += this.stack.pop()[1];
    }
    this.stack.push([price, span]);
    return span;
};
