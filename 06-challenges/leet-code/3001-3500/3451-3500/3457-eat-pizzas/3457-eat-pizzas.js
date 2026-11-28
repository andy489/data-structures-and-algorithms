// https://leetcode.com/problems/eat-pizzas/

var maxWeight = function(pizzas) {
    pizzas.sort((a, b) => a - b);
    const n = pizzas.length;
    const days = n / 4;
    const odd = Math.ceil(days / 2);
    const even = Math.floor(days / 2);

    let total = 0;
    // Odd days: take maximum (Z) = pizzas[n-1], pizzas[n-3], ...
    for (let i = 0; i < odd; i++) {
        total += pizzas[n - 1 - 2 * i];
    }
    // Even days: take 2nd maximum (Y) = pizzas[n-2], pizzas[n-4], ...
    for (let i = 0; i < even; i++) {
        total += pizzas[n - 2 - 2 * i];
    }
    return total;
};
