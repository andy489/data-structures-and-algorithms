# https://leetcode.com/problems/get-watched-videos-by-your-friends/

from collections import deque, Counter

class Solution:
    def watchedVideosByFriends(self, watchedVideos, friends, id: int, level: int) -> list[str]:
        visited = {id}
        q = deque([id])
        for _ in range(level):
            for _ in range(len(q)):
                cur = q.popleft()
                for f in friends[cur]:
                    if f not in visited:
                        visited.add(f)
                        q.append(f)
        cnt = Counter(v for person in q for v in watchedVideos[person])
        return sorted(cnt, key=lambda v: (cnt[v], v))
