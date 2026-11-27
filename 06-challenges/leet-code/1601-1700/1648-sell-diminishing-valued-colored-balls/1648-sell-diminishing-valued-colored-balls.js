// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/

var maxProfit = function(inventory, orders) {
    const MOD = 1_000_000_007n;
    inventory.sort((a, b) => a - b);
    const n = inventory.length;
    let ans = 0n;
    let count = 1n;
    for (let i = n - 1; i >= 0; i--) {
        const cur = BigInt(inventory[i]);
        const nxt = i > 0 ? BigInt(inventory[i - 1]) : 0n;
        const balls = (cur - nxt) * count;
        const ord = BigInt(orders);
        if (ord >= balls) {
            ans += count * (nxt + 1n + cur) * (cur - nxt) / 2n;
            orders -= Number(balls);
        } else {
            const full = ord / count;
            const rem = ord % count;
            ans += count * (cur - full + 1n + cur) * full / 2n;
            ans += rem * (cur - full);
            orders = 0;
            break;
        }
        count++;
    }
    return Number(ans % MOD);
};
