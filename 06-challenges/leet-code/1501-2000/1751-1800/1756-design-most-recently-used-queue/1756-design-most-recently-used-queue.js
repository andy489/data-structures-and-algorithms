// https://leetcode.com/problems/design-most-recently-used-queue/

class MRUQueue {
    constructor(n) {
        this.queue = Array.from({length: n}, (_, i) => i + 1);
    }

    fetch(k) {
        const val = this.queue.splice(k - 1, 1)[0];
        this.queue.push(val);
        return val;
    }
}
