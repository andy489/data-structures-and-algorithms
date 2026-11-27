// https://leetcode.com/problems/number-of-orders-in-the-backlog/

var getNumberOfBacklogOrders = function(orders) {
    const MOD = 1000000007n;
    const buy = new Map();  // price -> amount
    const sell = new Map(); // price -> amount

    for (const [price, amount, type] of orders) {
        let rem = amount;
        if (type === 0) { // buy order
            const sellPrices = [...sell.keys()].sort((a, b) => a - b);
            for (const sp of sellPrices) {
                if (sp > price || rem === 0) {
                    break;
                }
                const sa = sell.get(sp);
                const matched = Math.min(rem, sa);
                rem -= matched;
                if (sa - matched === 0) {
                    sell.delete(sp);
                } else {
                    sell.set(sp, sa - matched);
                }
            }
            if (rem > 0) {
                buy.set(price, (buy.get(price) || 0) + rem);
            }
        } else { // sell order
            const buyPrices = [...buy.keys()].sort((a, b) => b - a);
            for (const bp of buyPrices) {
                if (bp < price || rem === 0) {
                    break;
                }
                const ba = buy.get(bp);
                const matched = Math.min(rem, ba);
                rem -= matched;
                if (ba - matched === 0) {
                    buy.delete(bp);
                } else {
                    buy.set(bp, ba - matched);
                }
            }
            if (rem > 0) {
                sell.set(price, (sell.get(price) || 0) + rem);
            }
        }
    }

    let total = 0n;
    for (const a of buy.values()) {
        total += BigInt(a);
    }
    for (const a of sell.values()) {
        total += BigInt(a);
    }
    return Number(total % MOD);
};
