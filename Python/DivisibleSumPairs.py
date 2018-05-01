
# URL: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem

# You are given an array of n integers, and a positive integer k. Find and print the number of  pairs where i < j and  a[i] + a[j]  is divisible by k.

# Input Format

# The first line contains  space-separated integers,  and . 
# The second line contains  space-separated integers describing the values of .

# Constraints

# Output Format

# Print the number of  pairs where  and  +  is evenly divisible by .

# Sample Input

# 6 3
# 1 3 2 6 1 2

# Sample Output

# 5

#!/bin/python3

import sys

def divisibleSumPairs(n, k, ar):
    count = 0
    for i in range(0,n):
        for j in range(i+1,n):
            if (ar[i] + ar[j]) % k == 0:
                count += 1
    return count	

n, k = input().strip().split(' ')
n, k = [int(n), int(k)]
ar = list(map(int, input().strip().split(' ')))
result = divisibleSumPairs(n, k, ar)
print(result)