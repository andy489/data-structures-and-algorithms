// https://leetcode.com/problems/accounts-merge/

var accountsMerge = function(accounts) {
    const parent = new Map();
    const emailToName = new Map();

    function find(x) {
        if (parent.get(x) !== x) parent.set(x, find(parent.get(x)));
        return parent.get(x);
    }

    function union(x, y) {
        parent.set(find(x), find(y));
    }

    for (const account of accounts) {
        const name = account[0];
        for (let i = 1; i < account.length; i++) {
            const email = account[i];
            if (!parent.has(email)) parent.set(email, email);
            emailToName.set(email, name);
            union(account[1], email);
        }
    }

    const groups = new Map();
    for (const email of parent.keys()) {
        const root = find(email);
        if (!groups.has(root)) groups.set(root, []);
        groups.get(root).push(email);
    }

    const result = [];
    for (const [root, emails] of groups) {
        emails.sort();
        result.push([emailToName.get(root), ...emails]);
    }
    return result;
};
