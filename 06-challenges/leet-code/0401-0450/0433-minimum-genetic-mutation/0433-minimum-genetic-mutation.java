// https://leetcode.com/problems/minimum-genetic-mutation/

// Solution: BFS — O(b * L) time, O(b) space
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGenes = new HashSet<>();
        for (String gene : bank) {
            validGenes.add(gene);
        }
        if (!validGenes.contains(endGene)) {
            return -1;
        }

        char[] bases = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        validGenes.remove(startGene);
        int mutations = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            mutations++;
            for (int i = 0; i < levelSize; i++) {
                char[] current = queue.poll().toCharArray();
                for (int pos = 0; pos < current.length; pos++) {
                    char original = current[pos];
                    for (char base : bases) {
                        if (base == original) {
                            continue;
                        }
                        current[pos] = base;
                        String mutated = new String(current);
                        if (mutated.equals(endGene)) {
                            return mutations;
                        }
                        if (validGenes.contains(mutated)) {
                            queue.offer(mutated);
                            validGenes.remove(mutated);
                        }
                        current[pos] = original;
                    }
                }
            }
        }
        return -1;
    }
}
