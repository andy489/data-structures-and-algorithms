# https://leetcode.com/problems/find-array-given-subset-sums/

class Solution:
    def recoverArray(self, n: int, sums: List[int]) -> List[int]:
        sums.sort()
        result = []
        while len(sums) > 1:
            d = sums[-1] - sums[-2]
            # Split into two halves
            cnt = Counter(sums)
            without_d = []
            with_d = []
            for s in sorted(cnt.keys(), reverse=True):
                while cnt[s] > 0:
                    with_d.append(s)
                    cnt[s] -= 1
                    cnt[s - d] -= 1
                    without_d.append(s - d)
            without_d.sort()
            # 0 is in sums; check which half contains 0
            if 0 in without_d:
                sums = without_d
                result.append(d)
            else:
                sums = with_d
                result.append(-d)
        return result
