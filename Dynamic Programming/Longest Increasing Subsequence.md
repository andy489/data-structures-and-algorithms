## Longest Increasing Subsequence 
*Finding and Reconstructing LIS*

![](https://i.ibb.co/9sM7FMK/seq.png)

***3-5-7-8-9-11** and **3-5-7-8-9-10** are possible solutions for the above example, because both are increasing and with maximum length*

- Goal: find the *largest subsequence of increasing numbers* within a given sequence
- This subsequence is not necessarily contiguous, or unique
- Example: 
  - {**3, 5**, 8, **6, 7**}->{3, 5, 6, 7}
  
#### Optimal Sub-Structure
- **Break up** the problem into **sub-problems**
- Characterize the structure of an **optimal solution**
- **Compute** the optimal solutions, typically in a bottom-up fashion
- Construct an **optimal solution** from computed information (*Optimal sub-structure*)

#### Memorization
- DP -> sub-problems **overlap**
- In order to **avoid solving** problems **multiple times**, memorize
  - **Memorization** -> **save/cache** sub-problem solutions **for later use**

- Example:
  - **Save** the length of the LIS **starting/ending** with each number
  
  ![](https://i.ibb.co/19yTTW7/seq2.png)

- Iterative approach

![](https://i.ibb.co/PFJsFHq/seq3.png)

For every sub-problem we find the optimal solution and use it to solve the next larger sub-problem problem until we solve the whole problem.
