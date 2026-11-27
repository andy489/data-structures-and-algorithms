# https://leetcode.com/problems/design-an-atm-machine/

class ATM:
    def __init__(self):
        self.counts = [0] * 5
        self.denominations = [20, 50, 100, 200, 500]

    def deposit(self, banknotesCount: list[int]) -> None:
        for i in range(5):
            self.counts[i] += banknotesCount[i]

    def withdraw(self, amount: int) -> list[int]:
        used = [0] * 5
        for i in range(4, -1, -1):
            take = min(self.counts[i], amount // self.denominations[i])
            used[i] = take
            amount -= take * self.denominations[i]
        if amount != 0:
            return [-1]
        for i in range(5):
            self.counts[i] -= used[i]
        return used
