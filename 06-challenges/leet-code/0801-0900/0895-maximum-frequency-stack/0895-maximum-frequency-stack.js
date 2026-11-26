// https://leetcode.com/problems/maximum-frequency-stack/

class FreqStack {
    constructor() {
        this.freq = new Map();
        this.group = new Map();
        this.maxFreq = 0;
    }

    push(val) {
        const f = (this.freq.get(val) || 0) + 1;
        this.freq.set(val, f);
        this.maxFreq = Math.max(this.maxFreq, f);
        if (!this.group.has(f)) this.group.set(f, []);
        this.group.get(f).push(val);
    }

    pop() {
        const stack = this.group.get(this.maxFreq);
        const val = stack.pop();
        if (!stack.length) this.maxFreq--;
        this.freq.set(val, this.freq.get(val) - 1);
        return val;
    }
}
