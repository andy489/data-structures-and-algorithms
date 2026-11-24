// https://leetcode.com/problems/design-circular-queue/

var MyCircularQueue = function(k) {
    this.data = new Array(k);
    this.head = 0;
    this.tail = 0;
    this.size = 0;
    this.capacity = k;
};

MyCircularQueue.prototype.enQueue = function(value) {
    if (this.isFull()) return false;
    this.data[this.tail] = value;
    this.tail = (this.tail + 1) % this.capacity;
    this.size++;
    return true;
};

MyCircularQueue.prototype.deQueue = function() {
    if (this.isEmpty()) return false;
    this.head = (this.head + 1) % this.capacity;
    this.size--;
    return true;
};

MyCircularQueue.prototype.Front = function() {
    return this.isEmpty() ? -1 : this.data[this.head];
};

MyCircularQueue.prototype.Rear = function() {
    return this.isEmpty() ? -1 : this.data[(this.tail - 1 + this.capacity) % this.capacity];
};

MyCircularQueue.prototype.isEmpty = function() {
    return this.size === 0;
};

MyCircularQueue.prototype.isFull = function() {
    return this.size === this.capacity;
};
