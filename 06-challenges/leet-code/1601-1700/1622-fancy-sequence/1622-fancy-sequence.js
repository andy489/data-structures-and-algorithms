// https://leetcode.com/problems/fancy-sequence/

const MOD = 1_000_000_007n;

function modPow(base, exp, mod) {
    let result = 1n;
    base %= mod;
    while (exp > 0n) {
        if (exp & 1n) result = result * base % mod;
        base = base * base % mod;
        exp >>= 1n;
    }
    return result;
}

class Fancy {
    constructor() {
        this.seq = [];
        this.add = 0n;
        this.mult = 1n;
    }

    append(val) {
        const base = (BigInt(val) - this.add + MOD) % MOD * modPow(this.mult, MOD - 2n, MOD) % MOD;
        this.seq.push(base);
    }

    addAll(inc) {
        this.add = (this.add + BigInt(inc)) % MOD;
    }

    multAll(m) {
        this.mult = this.mult * BigInt(m) % MOD;
        this.add = this.add * BigInt(m) % MOD;
    }

    getIndex(idx) {
        if (idx >= this.seq.length) return -1;
        return Number((this.seq[idx] * this.mult % MOD + this.add) % MOD);
    }
}
