// https://leetcode.com/problems/get-watched-videos-by-your-friends/

// Solution: BFS + Sort — O(n + E + V log V) time, O(n) space
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        boolean[] visited = new boolean[friends.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        visited[id] = true;
        for (int lv = 0; lv < level; lv++) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                for (int f : friends[cur]) {
                    if (!visited[f]) { visited[f] = true; q.offer(f); }
                }
            }
        }
        Map<String, Integer> freq = new HashMap<>();
        while (!q.isEmpty()) {
            for (String v : watchedVideos.get(q.poll())) freq.merge(v, 1, Integer::sum);
        }
        List<String> res = new ArrayList<>(freq.keySet());
        res.sort((a, b) -> freq.get(a).equals(freq.get(b)) ? a.compareTo(b) : freq.get(a) - freq.get(b));
        return res;
    }
}
