// https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/

var displayTable = function(orders) {
    const foods = [...new Set(orders.map(o => o[2]))].sort();
    const tables = new Map();
    for (const [, tbl, food] of orders) {
        if (!tables.has(tbl)) tables.set(tbl, new Map());
        tables.get(tbl).set(food, (tables.get(tbl).get(food) || 0) + 1);
    }
    const res = [["Table", ...foods]];
    for (const tbl of [...tables.keys()].sort((a,b) => +a - +b)) {
        res.push([tbl, ...foods.map(f => String(tables.get(tbl).get(f) || 0))]);
    }
    return res;
};
