// https://leetcode.com/problems/lfu-cache/

class LFUCache {
    constructor(capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToVal = new Map();
        this.keyToFreq = new Map();
        this.freqToKeys = new Map();
    }

    get(key) {
        if (!this.keyToVal.has(key)) {
            return -1;
        }
        this._incrementFreq(key);
        return this.keyToVal.get(key);
    }

    put(key, value) {
        if (this.capacity <= 0) {
            return;
        }
        if (this.keyToVal.has(key)) {
            this.keyToVal.set(key, value);
            this._incrementFreq(key);
            return;
        }
        if (this.keyToVal.size >= this.capacity) {
            this._evict();
        }
        this.keyToVal.set(key, value);
        this.keyToFreq.set(key, 1);
        if (!this.freqToKeys.has(1)) {
            this.freqToKeys.set(1, new Map());
        }
        this.freqToKeys.get(1).set(key, null);
        this.minFreq = 1;
    }

    _incrementFreq(key) {
        const freq = this.keyToFreq.get(key);
        this.keyToFreq.set(key, freq + 1);
        this.freqToKeys.get(freq).delete(key);
        if (this.freqToKeys.get(freq).size === 0) {
            this.freqToKeys.delete(freq);
            if (this.minFreq === freq) {
                this.minFreq++;
            }
        }
        if (!this.freqToKeys.has(freq + 1)) {
            this.freqToKeys.set(freq + 1, new Map());
        }
        this.freqToKeys.get(freq + 1).set(key, null);
    }

    _evict() {
        const minFreqKeys = this.freqToKeys.get(this.minFreq);
        const evictKey = minFreqKeys.keys().next().value;
        minFreqKeys.delete(evictKey);
        if (minFreqKeys.size === 0) {
            this.freqToKeys.delete(this.minFreq);
        }
        this.keyToVal.delete(evictKey);
        this.keyToFreq.delete(evictKey);
    }
}
