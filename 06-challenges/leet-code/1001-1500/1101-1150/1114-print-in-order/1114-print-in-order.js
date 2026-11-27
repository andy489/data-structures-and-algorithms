// https://leetcode.com/problems/print-in-order/

// Solution: Promise chaining — O(1) time, O(1) space
class Foo {
    constructor() {
        this.firstDone = new Promise(resolve => { this._resolveFirst = resolve; });
        this.secondDone = new Promise(resolve => { this._resolveSecond = resolve; });
    }

    async first(printFirst) {
        printFirst();
        this._resolveFirst();
    }

    async second(printSecond) {
        await this.firstDone;
        printSecond();
        this._resolveSecond();
    }

    async third(printThird) {
        await this.secondDone;
        printThird();
    }
}
