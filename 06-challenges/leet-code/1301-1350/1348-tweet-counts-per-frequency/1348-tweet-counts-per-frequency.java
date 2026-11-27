// https://leetcode.com/problems/tweet-counts-per-frequency/

// Solution: HashMap + TreeMap — O(log n) per record, O(n) per query
class TweetCounts {
    Map<String, TreeMap<Integer, Integer>> tweets = new HashMap<>();
    public void recordTweet(String tweetName, int time) {
        tweets.computeIfAbsent(tweetName, k -> new TreeMap<>()).merge(time, 1, Integer::sum);
    }
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = freq.equals("minute") ? 60 : freq.equals("hour") ? 3600 : 86400;
        int buckets = (endTime - startTime) / delta + 1;
        List<Integer> res = new ArrayList<>(Collections.nCopies(buckets, 0));
        TreeMap<Integer, Integer> times = tweets.getOrDefault(tweetName, new TreeMap<>());
        for (Map.Entry<Integer, Integer> e : times.subMap(startTime, true, endTime, true).entrySet()) {
            int bucket = (e.getKey() - startTime) / delta;
            res.set(bucket, res.get(bucket) + e.getValue());
        }
        return res;
    }
}
