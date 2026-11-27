// https://leetcode.com/problems/building-h2o/

// Solution: Promise-based semaphores — O(n) time, O(1) space
class H2O {
    constructor() {
        this._hCount = 0;
        this._oCount = 0;
        this._hResolvers = [];
        this._oResolvers = [];
    }

    _tryRelease() {
        if (this._hCount >= 2 && this._oCount >= 1) {
            this._hCount -= 2;
            this._oCount -= 1;
            this._hResolvers.shift()();
            this._hResolvers.shift()();
            this._oResolvers.shift()();
        }
    }

    hydrogen(releaseHydrogen) {
        return new Promise(resolve => {
            this._hResolvers.push(() => { releaseHydrogen(); resolve(); });
            this._hCount++;
            this._tryRelease();
        });
    }

    oxygen(releaseOxygen) {
        return new Promise(resolve => {
            this._oResolvers.push(() => { releaseOxygen(); resolve(); });
            this._oCount++;
            this._tryRelease();
        });
    }
}
