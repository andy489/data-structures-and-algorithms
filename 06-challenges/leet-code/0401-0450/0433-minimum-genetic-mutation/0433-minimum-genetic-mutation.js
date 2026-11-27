// https://leetcode.com/problems/minimum-genetic-mutation/

var minMutation = function(startGene, endGene, bank) {
    const validGenes = new Set(bank);
    if (!validGenes.has(endGene)) {
        return -1;
    }

    const bases = ['A', 'C', 'G', 'T'];
    const queue = [[startGene, 0]];
    validGenes.delete(startGene);

    while (queue.length > 0) {
        const [gene, mutations] = queue.shift();
        for (let pos = 0; pos < gene.length; pos++) {
            for (const base of bases) {
                if (base === gene[pos]) {
                    continue;
                }
                const mutated = gene.slice(0, pos) + base + gene.slice(pos + 1);
                if (mutated === endGene) {
                    return mutations + 1;
                }
                if (validGenes.has(mutated)) {
                    queue.push([mutated, mutations + 1]);
                    validGenes.delete(mutated);
                }
            }
        }
    }
    return -1;
};
