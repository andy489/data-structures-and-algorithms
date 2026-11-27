# https://leetcode.com/problems/invalid-transactions/

from collections import defaultdict

class Solution:
    def invalidTransactions(self, transactions: list[str]) -> list[str]:
        parsed = []
        by_name = defaultdict(list)
        for i, t in enumerate(transactions):
            name, time, amount, city = t.split(',')
            parsed.append((name, int(time), int(amount), city))
            by_name[name].append(i)
        result = []
        for i, (name, time, amount, city) in enumerate(parsed):
            if amount > 1000:
                result.append(transactions[i])
                continue
            if any(
                abs(time - parsed[j][1]) <= 60 and city != parsed[j][3]
                for j in by_name[name] if j != i
            ):
                result.append(transactions[i])
        return result
