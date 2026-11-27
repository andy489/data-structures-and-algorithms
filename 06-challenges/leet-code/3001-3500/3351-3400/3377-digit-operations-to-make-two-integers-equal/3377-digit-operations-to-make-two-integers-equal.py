# https://leetcode.com/problems/digit-operations-to-make-two-integers-equal/

import heapq

class Solution:
    def minOperations(self, n: int, m: int) -> int:
        limit = 10001
        is_prime = [True] * limit
        is_prime[0] = is_prime[1] = False
        for i in range(2, int(limit ** 0.5) + 1):
            if is_prime[i]:
                for j in range(i * i, limit, i):
                    is_prime[j] = False

        if is_prime[n] or is_prime[m]:
            return -1

        dist = [float('inf')] * limit
        dist[n] = n
        heap = [(n, n)]  # (cost, number)

        while heap:
            cost, num = heapq.heappop(heap)
            if cost > dist[num]:
                continue
            if num == m:
                return cost
            digits = list(str(num))
            for i in range(len(digits)):
                orig = digits[i]
                # increase digit
                if orig < '9':
                    digits[i] = str(int(orig) + 1)
                    nxt = int(''.join(digits))
                    if not is_prime[nxt] and cost + nxt < dist[nxt]:
                        dist[nxt] = cost + nxt
                        heapq.heappush(heap, (dist[nxt], nxt))
                    digits[i] = orig
                # decrease digit (no leading zero)
                if orig > '0' and not (i == 0 and orig == '1'):
                    digits[i] = str(int(orig) - 1)
                    nxt = int(''.join(digits))
                    if not is_prime[nxt] and cost + nxt < dist[nxt]:
                        dist[nxt] = cost + nxt
                        heapq.heappush(heap, (dist[nxt], nxt))
                    digits[i] = orig

        return -1
