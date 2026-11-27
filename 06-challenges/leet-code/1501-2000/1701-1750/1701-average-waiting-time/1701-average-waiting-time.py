# https://leetcode.com/problems/average-waiting-time/

class Solution:
    def averageWaitingTime(self, customers: list[list[int]]) -> float:
        total_wait = 0
        chef_free_at = 0
        for arrival, prep_time in customers:
            chef_free_at = max(chef_free_at, arrival) + prep_time
            total_wait += chef_free_at - arrival
        return total_wait / len(customers)
