// https://leetcode.com/problems/print-foobar-alternately/

// Solution: Promise-based mutex — O(n) time, O(1) space
class FooBar {
    constructor(n) {
        this.n = n;
        this._fooResolve = null;
        this._barResolve = null;
        this.fooReady = Promise.resolve();
        this.barReady = new Promise(resolve => { this._barResolve = resolve; });
    }

    async foo(printFoo) {
        for (let i = 0; i < this.n; i++) {
            await this.fooReady;
            printFoo();
            this.fooReady = new Promise(resolve => { this._fooResolve = resolve; });
            this._barResolve();
        }
    }

    async bar(printBar) {
        for (let i = 0; i < this.n; i++) {
            await this.barReady;
            printBar();
            this.barReady = new Promise(resolve => { this._barResolve = resolve; });
            this._fooResolve();
        }
    }
}
