## Task 13.

Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses [Dense Ranking](https://en.wikipedia.org/wiki/Ranking#Dense_ranking_.28.221223.22_ranking.29), so its leaderboard works like this:
- The player with the highest score is ranked number **1** on the leaderboard.
- Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.

For example, the four players on the leaderboard have high scores of **100, 90, 90**, and **80**. Those players will have ranks **1, 2, 2** and **3**, respectively. If Alice's scores are **70, 80** and **105**, her rankings after each game are <img src="https://latex.codecogs.com/svg.latex?\Large&space;4^{th}">, <img src="https://latex.codecogs.com/svg.latex?\Large&space;3^{rd}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;1^{st}">.

#### Function Description

Write a climbingLeaderboard function. It should return an integer array where each element <img src="https://latex.codecogs.com/svg.latex?\Large&space;res[j]"> represents Alice's rank after the <img src="https://latex.codecogs.com/svg.latex?\Large&space;j^{th}"> game.

climbingLeaderboard has the following parameter(s):
- scores: an array of integers that represent leaderboard scores
- alice: an array of integers that represent Alice's scores

#### Input Format

The first line contains an integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, the number of players on the leaderboard.<br>
The next line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;scores[i]">, the leaderboard scores in decreasing order.<br>
The next line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;m">, denoting the number games Alice plays.
The last line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> space-separated integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;alice[j]">, the game scores.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{2\times}10^5"><br>
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{2\times}10^5"><br>
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{scores[i]}\le{10^9}"> for <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{i}\le{n}"><br>
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{alice[i]}\le{10^9}"> for <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{j}\le{m}"><br>
- The existing leaderboard, <img src="https://latex.codecogs.com/svg.latex?\Large&space;scores">, is in descending order.
- Alice's scores, <img src="https://latex.codecogs.com/svg.latex?\Large&space;alice">, are in ascending order.

#### Subtask
For <img src="https://latex.codecogs.com/svg.latex?\Large&space;60%"> of the maximum score:
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{n}\le{200}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{m}\le{200}">

#### Output Format

Print <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> integers. The <img src="https://latex.codecogs.com/svg.latex?\Large&space;j^{th}"> integer should indicate Alice's rank after playing the <img src="https://latex.codecogs.com/svg.latex?\Large&space;j^{th}"> game.

**Sample Input 1**

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2001.png)

Input|Output
-|-
7<br>100 100 50 40 40 20 10<br>4<br>5 25 50 120|6<br>4<br>2<br>1

**Explanation 1**<br> Alice starts playing with **7** players already on the leaderboard, which looks like this:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2002.png)

After Alice finishes game **0**, her score is **5** and her ranking is **6**:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2003.png)

After Alice finishes game **1**, her score is **25** and her ranking is **4**:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2004.png)

After Alice finishes game **2**, her score is **50** and her ranking is tied with Caroline at **2**:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2005.png)

After Alice finishes game **3**, her score is **120** and her ranking is **1**:

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2006.png)

**Sample Input 2**

![](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/assets/Alice%2007.png)

Input|Output
-|-
6<br>100 90 90 80 75 60<br>5<br>50 65 77 90 102|6<br>5<br>4<br>2<br>1
