// https://leetcode.com/problems/simple-bank-system/

// Solution: Simulation — O(1) per op, O(n) space
class Bank {
    constructor(balance) { this.balance = balance; }
    transfer(a1, a2, money) {
        const n = this.balance.length;
        if (a1 < 1 || a1 > n || a2 < 1 || a2 > n || this.balance[a1-1] < money) return false;
        this.balance[a1-1] -= money; this.balance[a2-1] += money; return true;
    }
    deposit(account, money) {
        if (account < 1 || account > this.balance.length) return false;
        this.balance[account-1] += money; return true;
    }
    withdraw(account, money) {
        if (account < 1 || account > this.balance.length || this.balance[account-1] < money) return false;
        this.balance[account-1] -= money; return true;
    }
}
