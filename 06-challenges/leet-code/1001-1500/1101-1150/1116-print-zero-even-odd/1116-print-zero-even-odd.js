// https://leetcode.com/problems/print-zero-even-odd/

// Solution: Promise-based semaphore — O(n) time, O(1) space
class ZeroEvenOdd {
    constructor(n) {
        this.n = n;
        this._zeroResolve = null;
        this._oddResolve = null;
        this._evenResolve = null;
        this.zeroReady = Promise.resolve();
        this.oddReady = new Promise(r => { this._oddResolve = r; });
        this.evenReady = new Promise(r => { this._evenResolve = r; });
    }

    async zero(printNumber) {
        for (let i = 1; i <= this.n; i++) {
            await this.zeroReady;
            printNumber(0);
            this.zeroReady = new Promise(r => { this._zeroResolve = r; });
            if (i % 2 === 1) {
                this._oddResolve();
                this.oddReady = new Promise(r => { this._oddResolve = r; });
            } else {
                this._evenResolve();
                this.evenReady = new Promise(r => { this._evenResolve = r; });
            }
        }
    }

    async even(printNumber) {
        for (let i = 2; i <= this.n; i += 2) {
            await this.evenReady;
            printNumber(i);
            this._zeroResolve();
        }
    }

    async odd(printNumber) {
        for (let i = 1; i <= this.n; i += 2) {
            await this.oddReady;
            printNumber(i);
            this._zeroResolve();
        }
    }
}
