
# Contents
![](contents.png)

## Recursion

>- choice/ Tree diagram  _ most important
- be clear about what you want to return from the function, if func. isn't void  
- break into smaller sub-problems and operate on them  
- suppose that the sub-problem will bring the answer


- base condition _ think of smallest valid input  
- generally we start from the last index, but sometimes we may need to start from starting index
- use (idx-1) inside rec function for getting array values, when calling on idx; first call will be on n, so it will access n-1 index
- when we call on rec

DP
- the no. of variables changing in the recursion, determine if dp[] array will be 1d, 2d, or 3d

## To identify type of DP

- Match I/P (given data) & O/P (ans) format/ data type
- 

## knapsack

- 0/1 knapsack _ starting from last, once an item is processed we will move to i-1
- unbounded knapsack _ we can take an item again, so even after taking we will still be at i

rod cutting is simply same as unbounded knapsack

### Coin change (max no. of ways) _ initialization
![img_1.png](img_1.png)

### Coin change (min no. of coins) _ unbounded knapsack
> - only question where will initialization is a bit different
- initialization with Int_MAX -1
- first two rows will be initialized  

Second Base condition
- ![img_2.png](img_2.png)

![img_3.png](img_3.png)

## LCS - longest common subsequence
![img_4.png](img_4.png)
![img_7.png](img_7.png)

## Longest common substring - LCSS
- for substring, the else condition of subsequence will be zero

## print LCS
![img_5.png](img_5.png)
![img_6.png](img_6.png)

### SCS -  shortest common supersequene
m + n - lcs(a,b,m,n);   // a = string of length m; b = string of length n

### min insert. and del. to convert String A to string B
![img_8.png](img_8.png)
![img_9.png](img_9.png)

### LPS - longest palindromic subsequence
![img_11.png](img_11.png)

### Minimum number of deletion in a string to make it a palindrome
![img_10.png](img_10.png)

### print SCS
![img_12.png](img_12.png)
![img_13.png](img_13.png)

### longest repeating subsequence
- we take only those where i != j, this is the only change in LCS code
![img_14.png](img_14.png)

### sequence pattern matching
- given two strings, check if one of them lies in the other
- solution: compare length of lcs with min. of length of both strings
![img_15.png](img_15.png)

### min. no. of insertion to make it palindrome
![img_16.png](img_16.png)

## MCM - Matrix Chain Multiplication

### MCM Contents
![img_17.png](img_17.png)

### Matrix chain multiplication Introduction Identification and General Format
generally used when we have to partition/ do something k times between i & j
![img_18.png](img_18.png)
![img_19.png](img_19.png)

### MCM recursive
contains 4 steps to make problem specific code
![img_20.png](img_20.png)

### Palindrome Partition _ min partitions required to make it a palindrome
![img_21.png](img_21.png)

optimised
- ![img_22.png](img_22.png)

### Boolean Parenthesization
![img_23.png](img_23.png)
![img_24.png](img_24.png)
![img_25.png](img_25.png)
- here as we were having 3 changing variables, we chose to use hashmap instead of 3d array 

### Scrambled string
![img_26.png](img_26.png)

- substr in c++, takes starting index and length as arguments
- in java, it's starting index and ending index

![img_27.png](img_27.png)
![img_28.png](img_28.png)

### Egg Drop
![img_29.png](img_29.png)
- optimised & memoized code  
    ![img_30.png](img_30.png)

## DP on Trees
- base condition
- hypotheses _ believe it will give the answer
- induction step

### Diameter of binary tree _ max number of nodes between two leaf nodes
![img_31.png](img_31.png)

### Max path sum _ any node to any node
- this step is required in case, we get negative values from left and right subtree     
![img_32.png](img_32.png)

![img_33.png](img_33.png)

### Max path sum _ leaf node to leaf node
in this case, if both subtrees give negative value, it has to take the negative also 
![img_34.png](img_34.png)