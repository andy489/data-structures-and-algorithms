// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/

var filterRestaurants = function(restaurants, veganFriendly, maxPrice, maxDistance) {
    return restaurants
        .filter(r => (!veganFriendly||r[2]===1) && r[3]<=maxPrice && r[4]<=maxDistance)
        .sort((a,b)=>a[1]!==b[1]?b[1]-a[1]:b[0]-a[0])
        .map(r=>r[0]);
};
