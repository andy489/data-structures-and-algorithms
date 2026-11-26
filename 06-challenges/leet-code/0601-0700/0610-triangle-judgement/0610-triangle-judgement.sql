-- https://leetcode.com/problems/triangle-judgement/

SELECT x, y, z,
    IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
FROM Triangle;
