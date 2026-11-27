# https://leetcode.com/problems/design-twitter/

import heapq

class Twitter:
    def __init__(self):
        self.time = 0
        self.tweets: dict[int, list[tuple[int, int]]] = {}
        self.follows: dict[int, set[int]] = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.tweets.setdefault(userId, []).append((self.time, tweetId))
        self.time += 1

    def getNewsFeed(self, userId: int) -> list[int]:
        heap = []
        followees = self.follows.get(userId, set()) | {userId}
        for uid in followees:
            lst = self.tweets.get(uid, [])
            if lst:
                idx = len(lst) - 1
                t, tid = lst[idx]
                heapq.heappush(heap, (-t, tid, uid, idx))
        result = []
        while heap and len(result) < 10:
            neg_t, tid, uid, idx = heapq.heappop(heap)
            result.append(tid)
            if idx > 0:
                t, tid2 = self.tweets[uid][idx - 1]
                heapq.heappush(heap, (-t, tid2, uid, idx - 1))
        return result

    def follow(self, followerId: int, followeeId: int) -> None:
        self.follows.setdefault(followerId, set()).add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.follows.get(followerId, set()).discard(followeeId)
