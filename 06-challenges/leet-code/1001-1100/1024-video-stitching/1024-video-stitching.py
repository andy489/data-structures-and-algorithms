# https://leetcode.com/problems/video-stitching/

class Solution:
    def videoStitching(self, clips: list[list[int]], time: int) -> int:
        max_end = [0] * (time + 1)
        for s, e in clips:
            if s <= time:
                max_end[s] = max(max_end[s], e)
        count = cur_end = next_end = 0
        for i in range(time):
            next_end = max(next_end, max_end[i])
            if i == cur_end:
                if next_end <= cur_end:
                    return -1
                count += 1
                cur_end = next_end
        return count
