// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
var findAllRecipes = function(recipes, ingredients, supplies) {
    const available = new Set(supplies);
    const recipeIdx = new Map();
    recipes.forEach((r, i) => recipeIdx.set(r, i));

    const n = recipes.length;
    const inDegree = new Array(n).fill(0);
    const graph = new Map();

    for (let i = 0; i < n; i++) {
        for (const ing of ingredients[i]) {
            if (!available.has(ing)) {
                if (recipeIdx.has(ing)) {
                    if (!graph.has(ing)) graph.set(ing, []);
                    graph.get(ing).push(i);
                    inDegree[i]++;
                } else {
                    inDegree[i] = Infinity;
                    break;
                }
            }
        }
    }

    const queue = [];
    for (let i = 0; i < n; i++) {
        if (inDegree[i] === 0) queue.push(i);
    }

    const result = [];
    let head = 0;
    while (head < queue.length) {
        const idx = queue[head++];
        result.push(recipes[idx]);
        for (const nxt of (graph.get(recipes[idx]) || [])) {
            if (--inDegree[nxt] === 0) queue.push(nxt);
        }
    }
    return result;
};
