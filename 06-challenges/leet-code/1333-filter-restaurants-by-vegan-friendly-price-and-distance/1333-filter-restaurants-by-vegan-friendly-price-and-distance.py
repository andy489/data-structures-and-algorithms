# https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/

class Solution:
    def filterRestaurants(self, restaurants, veganFriendly, maxPrice, maxDistance):
        filtered = [r for r in restaurants
                    if (not veganFriendly or r[2]) and r[3] <= maxPrice and r[4] <= maxDistance]
        filtered.sort(key=lambda r: (-r[1], -r[0]))
        return [r[0] for r in filtered]
