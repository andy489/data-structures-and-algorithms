# https://leetcode.com/problems/subdomain-visit-count/

from collections import defaultdict

class Solution:
    def subdomainVisits(self, cpdomains: list[str]) -> list[str]:
        counts = defaultdict(int)
        for entry in cpdomains:
            count, domain = entry.split()
            count = int(count)
            parts = domain.split('.')
            for i in range(len(parts)):
                counts['.'.join(parts[i:])] += count
        return [f"{v} {k}" for k, v in counts.items()]
