// https://leetcode.com/problems/minimum-number-of-people-to-teach/

// Solution: Enumerate Language + Count Teaching — O(n · m) time, O(m) space
class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        Set<Integer>[] langSets = new Set[m];
        for (int i = 0; i < m; i++) {
            langSets[i] = new HashSet<>();
            for (int lang : languages[i]) {
                langSets[i].add(lang);
            }
        }

        Set<Integer> candidates = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            boolean canCommunicate = false;
            for (int lang : langSets[u]) {
                if (langSets[v].contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                candidates.add(u);
                candidates.add(v);
            }
        }

        if (candidates.isEmpty()) {
            return 0;
        }

        int minTeach = candidates.size();
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;
            for (int user : candidates) {
                if (!langSets[user].contains(lang)) {
                    cnt++;
                }
            }
            minTeach = Math.min(minTeach, cnt);
        }
        return minTeach;
    }
}
