// https://leetcode.com/problems/find-products-with-valid-serial-numbers/
// This is a SQL problem. See the .sql file for the solution.

// Solution: SQL Regex — O(n) time, O(n) space
// SELECT product_id, product_name, description
// FROM products
// WHERE description REGEXP '(^|[^[:alnum:]])SN[0-9]{4}-[0-9]{4}($|[^[:digit:]])'
// ORDER BY product_id ASC;
