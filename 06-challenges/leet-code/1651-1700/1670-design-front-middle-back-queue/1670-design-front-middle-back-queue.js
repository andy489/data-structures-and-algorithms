// https://leetcode.com/problems/design-front-middle-back-queue/

var FrontMiddleBackQueue = function() {
    this.left = [];
    this.right = [];
};

FrontMiddleBackQueue.prototype._balance = function() {
    if (this.left.length > this.right.length) {
        this.right.unshift(this.left.pop());
    } else if (this.right.length > this.left.length + 1) {
        this.left.push(this.right.shift());
    }
};

FrontMiddleBackQueue.prototype.pushFront = function(val) {
    this.left.unshift(val);
    this._balance();
};

FrontMiddleBackQueue.prototype.pushMiddle = function(val) {
    if (this.left.length === this.right.length) {
        this.right.unshift(val);
    } else {
        this.left.push(val);
    }
};

FrontMiddleBackQueue.prototype.pushBack = function(val) {
    this.right.push(val);
    this._balance();
};

FrontMiddleBackQueue.prototype.popFront = function() {
    if (this.left.length === 0 && this.right.length === 0) {
        return -1;
    }
    const val = this.left.length > 0 ? this.left.shift() : this.right.shift();
    this._balance();
    return val;
};

FrontMiddleBackQueue.prototype.popMiddle = function() {
    if (this.left.length === 0 && this.right.length === 0) {
        return -1;
    }
    return this.left.length === this.right.length ? this.left.pop() : this.right.shift();
};

FrontMiddleBackQueue.prototype.popBack = function() {
    if (this.right.length === 0) {
        return -1;
    }
    const val = this.right.pop();
    this._balance();
    return val;
};
