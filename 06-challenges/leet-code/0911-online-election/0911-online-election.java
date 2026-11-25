// https://leetcode.com/problems/online-election/

// Solution: Precompute Leaders + Binary Search — O(n) build, O(log n) query
class TopVotedCandidate {
    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        int n = persons.length;
        leaders = new int[n];
        int[] votes = new int[n];
        int lead = -1;
        for (int i = 0; i < n; i++) {
            votes[persons[i]]++;
            if (lead == -1 || votes[persons[i]] >= votes[lead]) {
                lead = persons[i];
            }
            leaders[i] = lead;
        }
    }

    public int q(int t) {
        int lo = 0, hi = times.length - 1;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (times[mid] <= t) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return leaders[lo];
    }
}
