// https://leetcode.com/problems/throne-inheritance/

class ThroneInheritance {
    constructor(kingName) {
        this.king = kingName;
        this.children = new Map();
        this.dead = new Set();
    }

    birth(parentName, childName) {
        if (!this.children.has(parentName)) this.children.set(parentName, []);
        this.children.get(parentName).push(childName);
    }

    death(name) {
        this.dead.add(name);
    }

    getInheritanceOrder() {
        const order = [];
        const dfs = (name) => {
            if (!this.dead.has(name)) order.push(name);
            for (const child of (this.children.get(name) || [])) dfs(child);
        };
        dfs(this.king);
        return order;
    }
}
