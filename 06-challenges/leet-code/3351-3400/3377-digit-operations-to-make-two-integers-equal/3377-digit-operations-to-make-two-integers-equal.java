// https://leetcode.com/problems/digit-operations-to-make-two-integers-equal/

// Solution: Dijkstra's Algorithm — O(D * 10^D * log(10^D)) time, O(10^D) space
class Solution {
    public int minOperations(int n, int m) {
        boolean[] isPrime = sieve(10001);
        if (isPrime[n] || isPrime[m]) {
            return -1;
        }
        int[] dist = new int[10001];
        java.util.Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = n;
        // min-heap: {cost, number}
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{n, n});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0], num = curr[1];
            if (cost > dist[num]) {
                continue;
            }
            if (num == m) {
                return cost;
            }
            String s = Integer.toString(num);
            char[] digits = s.toCharArray();
            for (int i = 0; i < digits.length; i++) {
                char orig = digits[i];
                // increase digit
                if (orig < '9') {
                    digits[i] = (char) (orig + 1);
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime[next] && cost + next < dist[next]) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{dist[next], next});
                    }
                    digits[i] = orig;
                }
                // decrease digit (no leading zero)
                if (orig > '0' && !(i == 0 && orig == '1')) {
                    digits[i] = (char) (orig - 1);
                    int next = Integer.parseInt(new String(digits));
                    if (!isPrime[next] && cost + next < dist[next]) {
                        dist[next] = cost + next;
                        pq.offer(new int[]{dist[next], next});
                    }
                    digits[i] = orig;
                }
            }
        }
        return -1;
    }

    private boolean[] sieve(int limit) {
        boolean[] isPrime = new boolean[limit];
        java.util.Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; (long) i * i < limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}
