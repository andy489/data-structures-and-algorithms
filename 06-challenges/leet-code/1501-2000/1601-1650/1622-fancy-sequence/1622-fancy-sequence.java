// https://leetcode.com/problems/fancy-sequence/

// Solution: Lazy Propagation with Modular Inverse — O(log MOD) per append, O(1) others
class Fancy {
    private static final long MOD = 1_000_000_007L;
    private List<Long> seq = new ArrayList<>();
    private long add = 0, mult = 1;

    public void append(int val) {
        long base = (val - add % MOD + MOD) % MOD * modPow(mult, MOD - 2) % MOD;
        seq.add(base);
    }

    public void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    public void multAll(int m) {
        mult = mult * m % MOD;
        add = add * m % MOD;
    }

    public long getIndex(int idx) {
        if (idx >= seq.size()) {
            return -1;
        }
        return (seq.get(idx) * mult % MOD + add) % MOD;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
