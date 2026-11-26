# 1357. Apply Discount Every n Orders

[Problem Link](https://leetcode.com/problems/apply-discount-every-n-orders/)

## Description
Design Cashier class: n (discount frequency), discount (%), products, prices. getBill(product, amount) returns total, applying discount% every nth customer.

## Examples
cashier.getBill([1,2],[1,2]) → 22.0 (3rd customer: 10% discount on 25 → 22.5... actually 22.5)

## Constraints
- 1 <= n <= 10^4
