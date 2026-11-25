// https://leetcode.com/problems/employee-importance/

var GetImportance = function(employees, id) {
    const idMap = new Map();
    for (const e of employees) idMap.set(e.id, e);
    let total = 0;
    const queue = [id];
    for (let qi = 0; qi < queue.length; qi++) {
        const e = idMap.get(queue[qi]);
        total += e.importance;
        for (const subId of e.subordinates) queue.push(subId);
    }
    return total;
};
