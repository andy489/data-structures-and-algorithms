// https://leetcode.com/problems/count-primes/

// Solution 1: Sieve of Eratosthenes — O(n log log n) time, O(n) space
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isComposite = new boolean[n];
        for (int i = 2; (long) i * i < n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;
            }
        }
        return count;
    }
}

// Solution 2: Linear Sieve (Sieve of Euler) — O(n) time, O(n) space
class Solution2 {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isComposite = new boolean[n];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
            for (int p : primes) {
                if ((long) i * p >= n) {
                    break;
                }
                isComposite[i * p] = true;
                if (i % p == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}

// Solution 3: Segmented Sieve — O(n log log n) time, O(√n) space
class Solution3 {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        int limit = (int) Math.sqrt(n);
        boolean[] isComposite = new boolean[limit + 1];
        List<Integer> smallPrimes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                smallPrimes.add(i);
                for (int j = i * i; j <= limit; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        int count = 0;
        for (int low = 2; low < n; low += limit) {
            int high = Math.min(low + limit, n);
            boolean[] block = new boolean[high - low];
            for (int p : smallPrimes) {
                int start = Math.max(p * p, ((low + p - 1) / p) * p);
                for (int j = start; j < high; j += p) {
                    block[j - low] = true;
                }
            }
            for (int i = 0; i < block.length; i++) {
                if (!block[i] && (low + i) >= 2) {
                    count++;
                }
            }
        }
        return count;
    }
}
