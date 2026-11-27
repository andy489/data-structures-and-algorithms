# https://leetcode.com/problems/minimum-genetic-mutation/

from collections import deque

class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: list[str]) -> int:
        valid_genes = set(bank)
        if endGene not in valid_genes:
            return -1

        queue = deque([(startGene, 0)])
        valid_genes.discard(startGene)

        while queue:
            gene, mutations = queue.popleft()
            for pos in range(len(gene)):
                for base in 'ACGT':
                    if base == gene[pos]:
                        continue
                    mutated = gene[:pos] + base + gene[pos + 1:]
                    if mutated == endGene:
                        return mutations + 1
                    if mutated in valid_genes:
                        queue.append((mutated, mutations + 1))
                        valid_genes.remove(mutated)
        return -1
