// https://leetcode.com/problems/count-items-matching-a-rule/

var countMatches = function(items, ruleKey, ruleValue) {
    const idx = ruleKey === "type" ? 0 : ruleKey === "color" ? 1 : 2;
    return items.filter(item => item[idx] === ruleValue).length;
};
