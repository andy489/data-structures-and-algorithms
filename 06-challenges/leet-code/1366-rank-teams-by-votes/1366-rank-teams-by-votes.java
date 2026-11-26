// https://leetcode.com/problems/rank-teams-by-votes/

// Solution: Custom Sort — O(n*m + m^2 log m) time, O(m^2) space
class Solution {
    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        Map<Character, int[]> cnt = new HashMap<>();
        for (char c : votes[0].toCharArray()) cnt.put(c, new int[m]);
        for (String vote : votes) {
            for (int i = 0; i < m; i++) cnt.get(vote.charAt(i))[i]++;
        }
        List<Character> teams = new ArrayList<>(cnt.keySet());
        teams.sort((a, b) -> {
            int[] ca = cnt.get(a), cb = cnt.get(b);
            for (int i = 0; i < m; i++) if (ca[i] != cb[i]) return cb[i] - ca[i];
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (char c : teams) sb.append(c);
        return sb.toString();
    }
}
