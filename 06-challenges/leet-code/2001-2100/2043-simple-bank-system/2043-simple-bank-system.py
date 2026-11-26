# https://leetcode.com/problems/simple-bank-system/

class Bank:
    def __init__(self, balance: list[int]):
        self.balance = balance

    def transfer(self, account1: int, account2: int, money: int) -> bool:
        n = len(self.balance)
        if not (1 <= account1 <= n and 1 <= account2 <= n and self.balance[account1-1] >= money):
            return False
        self.balance[account1-1] -= money
        self.balance[account2-1] += money
        return True

    def deposit(self, account: int, money: int) -> bool:
        if not 1 <= account <= len(self.balance):
            return False
        self.balance[account-1] += money
        return True

    def withdraw(self, account: int, money: int) -> bool:
        if not (1 <= account <= len(self.balance) and self.balance[account-1] >= money):
            return False
        self.balance[account-1] -= money
        return True
