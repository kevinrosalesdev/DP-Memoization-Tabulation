def optimalStrategyOfGameRecursive(table,arr,i,j):
    if(i == j):
        return arr[i]
    if((i+2) <= j): x = optimalStrategyOfGameRecursive(table, arr, i+2, j)
    else: x = 0
    if ((i + 1) <= j-1): y = optimalStrategyOfGameRecursive(table, arr, i + 1, j-1)
    else: y = 0
    if (i <= (j-2)): z = optimalStrategyOfGameRecursive(table, arr, i, j-2)
    else: z = 0

    table[i][j] = max(arr[i] + min(x,y), arr[j] + min(y,z))
    return table[i][j]

def optimalStrategyOfGame(arr, n):

    table = [[0 for i in range(n)]
             for i in range(n)]

    for gap in range(n):
        for j in range(gap, n):
            i = j - gap

            x = 0
            if ((i + 2) <= j):
                x = table[i + 2][j]
            y = 0
            if ((i + 1) <= (j - 1)):
                y = table[i + 1][j - 1]
            z = 0
            if (i <= (j - 2)):
                z = table[i][j - 2]
            table[i][j] = max(arr[i] + min(x, y),
                              arr[j] + min(y, z))
            #for i in table: print(i)
            #print("\n")
    return table[0][n - 1]


# Driver Code

table = [[0 for i in range(4)]
         for i in range(4)]

arr1 = [8, 15, 3, 7]

arr2 = [2, 2, 2, 2]
print(optimalStrategyOfGameRecursive(table, arr1, 0, len(arr1)-1))
print(optimalStrategyOfGameRecursive(table, arr2, 0, len(arr2)-1))

table = [[0 for i in range(6)]
         for i in range(6)]
arr3 = [20, 30, 2, 2, 2, 10]
"""
print(optimalStrategyOfGame(arr3, n))
"""

print(optimalStrategyOfGameRecursive(table, arr3, 0, len(arr3)-1))

# This code is contibuted
# by sahilshelangia
