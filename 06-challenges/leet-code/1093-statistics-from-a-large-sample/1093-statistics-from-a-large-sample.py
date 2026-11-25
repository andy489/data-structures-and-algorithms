# https://leetcode.com/problems/statistics-from-a-large-sample/

class Solution:
    def sampleStats(self, count: list[int]) -> list[float]:
        mn = next((i for i in range(256) if count[i] > 0), 0)
        mx = next((i for i in range(255, -1, -1) if count[i] > 0), 0)
        mode = max(range(256), key=lambda i: count[i])
        total = sum(count)
        total_sum = sum(i * count[i] for i in range(256))
        mean = total_sum / total
        mid1, mid2 = (total + 1) // 2, (total + 2) // 2
        m1 = m2 = -1
        cumulative = 0
        for i in range(256):
            cumulative += count[i]
            if m1 == -1 and cumulative >= mid1:
                m1 = i
            if m2 == -1 and cumulative >= mid2:
                m2 = i
        return [float(mn), float(mx), mean, (m1 + m2) / 2.0, float(mode)]
