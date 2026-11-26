# https://leetcode.com/problems/tweet-counts-per-frequency/

from collections import defaultdict
import bisect

class TweetCounts:
    def __init__(self):
        self.tweets = defaultdict(list)

    def recordTweet(self, tweetName: str, time: int) -> None:
        bisect.insort(self.tweets[tweetName], time)

    def getTweetCountsPerFrequency(self, freq: str, tweetName: str, startTime: int, endTime: int):
        delta = {'minute': 60, 'hour': 3600, 'day': 86400}[freq]
        buckets = (endTime - startTime) // delta + 1
        res = [0] * buckets
        times = self.tweets[tweetName]
        lo = bisect.bisect_left(times, startTime)
        hi = bisect.bisect_right(times, endTime)
        for t in times[lo:hi]:
            res[(t - startTime) // delta] += 1
        return res
