-- https://leetcode.com/problems/first-letter-capitalization-ii/

-- Solution: Recursive CTE Word Splitting with per-hyphen-part capitalisation
WITH RECURSIVE split AS (
    -- Seed: start with pos=1 for each row; remainder is full text
    SELECT
        content_id,
        content_text,
        1 AS pos,
        IF(LOCATE(' ', content_text) > 0,
           LEFT(content_text, LOCATE(' ', content_text) - 1),
           content_text) AS word,
        IF(LOCATE(' ', content_text) > 0,
           SUBSTRING(content_text, LOCATE(' ', content_text) + 1),
           '') AS rest
    FROM user_content

    UNION ALL

    -- Recursion: peel off next word from remainder
    SELECT
        content_id,
        content_text,
        pos + 1,
        IF(LOCATE(' ', rest) > 0,
           LEFT(rest, LOCATE(' ', rest) - 1),
           rest),
        IF(LOCATE(' ', rest) > 0,
           SUBSTRING(rest, LOCATE(' ', rest) + 1),
           '')
    FROM split
    WHERE rest != ''
),
-- Capitalise each word
capped AS (
    SELECT
        content_id,
        content_text,
        pos,
        word,
        CASE
            -- Word does not start with a letter: leave unchanged
            WHEN word NOT REGEXP '^[a-zA-Z]' THEN word
            -- Word contains a hyphen and starts with a letter: capitalise each hyphen-part
            WHEN word LIKE '%-%' THEN (
                SELECT GROUP_CONCAT(
                    CONCAT(UPPER(LEFT(part, 1)), LOWER(SUBSTRING(part, 2)))
                    ORDER BY n SEPARATOR '-'
                )
                FROM (
                    SELECT
                        SUBSTRING_INDEX(SUBSTRING_INDEX(word, '-', nums.n), '-', -1) AS part,
                        nums.n
                    FROM (
                        SELECT 1 n UNION SELECT 2 UNION SELECT 3 UNION SELECT 4
                        UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8
                    ) nums
                    WHERE nums.n <= 1 + LENGTH(word) - LENGTH(REPLACE(word, '-', ''))
                ) parts
            )
            -- Regular word: capitalise first letter, lowercase the rest
            ELSE CONCAT(UPPER(LEFT(word, 1)), LOWER(SUBSTRING(word, 2)))
        END AS converted_word
    FROM split
)
SELECT
    content_id,
    content_text AS original_text,
    GROUP_CONCAT(converted_word ORDER BY pos SEPARATOR ' ') AS converted_text
FROM capped
GROUP BY content_id, content_text
ORDER BY content_id;
