// https://leetcode.com/problems/design-twitter/

// Solution: HashMap + Max-Heap Merge — O(k log k) getNewsFeed, O(1) others, O(u·t) space
class Twitter {
    private int time = 0;
    private final Map<Integer, List<int[]>> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> follows = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        Set<Integer> all = new HashSet<>(followees);
        all.add(userId);

        for (int uid : all) {
            List<int[]> list = tweets.getOrDefault(uid, Collections.emptyList());
            if (!list.isEmpty()) {
                int idx = list.size() - 1;
                int[] t = list.get(idx);
                pq.offer(new int[]{t[0], t[1], uid, idx});
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            int[] top = pq.poll();
            res.add(top[1]);
            int prevIdx = top[3] - 1;
            if (prevIdx >= 0) {
                List<int[]> list = tweets.get(top[2]);
                int[] t = list.get(prevIdx);
                pq.offer(new int[]{t[0], t[1], top[2], prevIdx});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        follows.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
