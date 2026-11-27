// https://leetcode.com/problems/design-an-atm-machine/

class ATM {
    constructor() {
        this.counts = new Array(5).fill(0);
        this.denominations = [20, 50, 100, 200, 500];
    }

    /**
     * @param {number[]} banknotesCount
     * @return {void}
     */
    deposit(banknotesCount) {
        for (let i = 0; i < 5; i++) {
            this.counts[i] += banknotesCount[i];
        }
    }

    /**
     * @param {number} amount
     * @return {number[]}
     */
    withdraw(amount) {
        const used = new Array(5).fill(0);
        for (let i = 4; i >= 0; i--) {
            const take = Math.min(this.counts[i], Math.floor(amount / this.denominations[i]));
            used[i] = take;
            amount -= take * this.denominations[i];
        }
        if (amount !== 0) {
            return [-1];
        }
        for (let i = 0; i < 5; i++) {
            this.counts[i] -= used[i];
        }
        return used;
    }
}
