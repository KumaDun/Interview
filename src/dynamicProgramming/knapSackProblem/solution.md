> https://noworneverev.github.io/leetcode_101/en/dynamic-programming/6-6-knapsack-problem/

# Introduction #

The knapsack problem is a combinatorial optimization NP-complete problem: given n items and a knapsack with weight
capacity w, where each item has a weight and a value, determine which items to include in the knapsack to maximize the
total value. If each item can only be chosen 0 or 1 time, the problem is called the 0-1 knapsack problem; if there is no
limit to the number of items chosen, it is called the unbounded knapsack problem.

## 0-1 KnapSack ##

### Intuition ###

Greedy algorithm can only be correct in Fractional knapsack problem and not correct in 0-1 knapsack problem.
The core difference and reason is in fractional version, every item can be divided. However, in 0-1 knapsack problem, an
item can either be selected or not selected instead of being divided. Implementing greedy algorithm will make item with
the highest unit value being picked first and this may lead to weight space being occupied and exclude a better
combination.
For example

* weight capacity W = 5

* Items:

  Item A, weightA = 4, valueA = 5, unitValueA = 1.25

  Item B, weight = 3, value = 3, unitValueB = 1

  Item C, weight = 2， value = 2, unitValueC = 1

Greedy algorithm will pick A first and use up the weight capacity while B + C gives the same value sum. In this case,
greedy algorithm is coincidentally correct. If value of B increase a little bit, greedy algorithm will return an
incorrect combination.

We can solve the knapsack problem using dynamic programming. Taking the 0-1 knapsack problem as an example, we define a
2D array dp to store the maximum value, where dp[i][j] represents the maximum value achievable after considering the
first i items
and a knapsack weight limit of j. When processing the i-th item, if we do not include item i in the knapsack, then
dp[i][j] = dp[i-1][j], which means the maximum value equals that of the first i-1 items. If we include item i, with
weight weight and value value, then dp[i][j] = dp[i-1][j-weight] + value. We take the maximum of these two options
during iteration, resulting in a time complexity and space complexity of
O(nw).

Note that dp[i][j] only means the first i-th items are considered, not necessarily being picked.

## Unbounded KnapSack ##

### Intuition ###

In the unbounded knapsack problem, an item can be chosen multiple times. Assume we are processing item
i=2i=2, with a weight of weight=2weight=2 and a value of value=3value=3. For a knapsack capacity of
j=5j=5, we can fit at most 2 of this item. Thus, our state transition equation becomes
dp[2][5]=max(dp[1][5],dp[1][3]+3,dp[1][1]+6)dp[2][5]=max(dp[1][5],dp[1][3]+3,dp[1][1]+6). If we use this approach and
assume infinite knapsack capacity with infinitely small item weight, the number of comparisons would approach infinity,
far exceeding the time complexity of
O(nw)O(nw).

How do we solve this issue? We observe that at dp
[2][3], we have already accounted for dp[1][3] and
dp[2][1], and at dp[2][1], we have already considered
dp[1][1]. Therefore, as shown in the bottom part of the figure, for cases involving multiple items, we only need to
consider
dp[2][3], i.e.,dp[2][5]=max(dp[1][5],dp[2][3]+3), dp[2][5]=max(dp[1][5],dp[2][3]+3). This gives us the state transition
equation for the unbounded knapsack problem:
dp[i][j]=max(dp[i−1][j],dp[i][j−w]+v), which differs from the 0-1 knapsack problem only in that the second
i−1 in the state transition equation is replaced by i.

### Tricky Point ###
Another question is why dp[i][j-w] can represent a situation where the i-th item is never selected.
Remember that dp[i] only means the i-th item is considered but not necessarily picked. If the i-th item
should not be picked, mathmatically dp[i][j-w] also should be equal to dp[i-1][j-w].

##   ##

