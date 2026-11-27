// https://leetcode.com/problems/invalid-transactions/

var invalidTransactions = function(transactions) {
    const parsed = transactions.map(t => {
        const [name, time, amount, city] = t.split(',');
        return { name, time: +time, amount: +amount, city };
    });
    const byName = new Map();
    for (let i = 0; i < parsed.length; i++) {
        const { name } = parsed[i];
        if (!byName.has(name)) {
            byName.set(name, []);
        }
        byName.get(name).push(i);
    }
    const result = [];
    for (let i = 0; i < parsed.length; i++) {
        const { name, time, amount, city } = parsed[i];
        if (amount > 1000) {
            result.push(transactions[i]);
            continue;
        }
        const peers = byName.get(name);
        const invalid = peers.some(j => {
            if (j === i) {
                return false;
            }
            return Math.abs(time - parsed[j].time) <= 60 && city !== parsed[j].city;
        });
        if (invalid) {
            result.push(transactions[i]);
        }
    }
    return result;
};
