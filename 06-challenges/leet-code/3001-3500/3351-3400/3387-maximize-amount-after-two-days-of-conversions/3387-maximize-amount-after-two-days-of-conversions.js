// https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/

var maxAmount = function(initialCurrency, pairs1, rates1, pairs2, rates2) {
    const buildGraph = (pairs, rates) => {
        const graph = new Map();
        for (let i = 0; i < pairs.length; i++) {
            const [a, b] = pairs[i], r = rates[i];
            if (!graph.has(a)) graph.set(a, []);
            if (!graph.has(b)) graph.set(b, []);
            graph.get(a).push([b, r]);
            graph.get(b).push([a, 1.0 / r]);
        }
        return graph;
    };

    const bfs = (initAmounts, graph) => {
        const amounts = new Map(initAmounts);
        const queue = [...initAmounts.keys()];
        let head = 0;
        while (head < queue.length) {
            const cur = queue[head++];
            const curAmt = amounts.get(cur);
            for (const [nb, rate] of (graph.get(cur) || [])) {
                const newAmt = curAmt * rate;
                if (!amounts.has(nb) || newAmt > amounts.get(nb)) {
                    amounts.set(nb, newAmt);
                    queue.push(nb);
                }
            }
        }
        return amounts;
    };

    const g1 = buildGraph(pairs1, rates1);
    const g2 = buildGraph(pairs2, rates2);

    const day1 = bfs(new Map([[initialCurrency, 1.0]]), g1);
    const day2 = bfs(day1, g2);

    return day2.get(initialCurrency) ?? 1.0;
};
