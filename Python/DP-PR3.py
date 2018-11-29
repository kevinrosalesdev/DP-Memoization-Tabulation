def optimalStrategyOfGameRecursive(table,arr,i,j):
    if(i == j):
        return arr[i]
    if((i+2) <= j): x = optimalStrategyOfGameRecursive(table, arr, i+2, j)
    else: x = 0
    if ((i + 1) <= j-1): y = optimalStrategyOfGameRecursive(table, arr, i + 1, j-1)
    else: y = 0
    if (i <= (j-2)): z = optimalStrategyOfGameRecursive(table, arr, i, j-2)
    else: z = 0

    (table[i])[j] = max(arr[i] + min(x,y), arr[j] + min(y,z))
    return (table[i])[j]
# Driver Code
import time

arr1 = [8, 15, 3, 7]

arr2 = [2, 2, 2, 2]
#Definicón del diccionario
table = {}
for i in range(len(arr1)):
    #creación par(clave(número entero),valor(lista))
    table[i] = []
    for j in range(len(arr1)):
        #asignación para la lista
        table[i].append(0)
st = time.time()
print(optimalStrategyOfGameRecursive(table, arr1, 0, len(arr1)-1))
print("tiempo 1: "  + str(st - time.time()))
st = time.time()
print(optimalStrategyOfGameRecursive(table, arr2, 0, len(arr2)-1))
print("tiempo 2: " + str(st - time.time()))

arr3 = [20, 30, 2, 2, 2, 10]

table = {}
for i in range(len(arr3)):
    #creación par(clave(número entero),valor(lista))
    table[i] = []
    for j in range(len(arr3)):
        #asignación para la lista
        table[i].append(0)
st = time.time()
print(optimalStrategyOfGameRecursive(table, arr3, 0, len(arr3)-1))
print("tiempo 3: " + str(st - time.time()))

arr4 = []
import random
for i in range(1,400):arr4.append(random.randint(1,101))
#2000 --> 4GB sobrecarga memeoria

table = {}
for i in range(len(arr4)):
    #creación par(clave(número entero),valor(lista))
    table[i] = []
    for j in range(len(arr4)):
        #asignación para la lista
        table[i].append(0)
st = time.time()
print(optimalStrategyOfGameRecursive(table, arr4, 0, len(arr4)-1))
print("tiempo 4: " + str(st - time.time()))

#Tabla comparativa de tiempos(versión primitiva)
"""
elementos | iterativo(tabla) s | recursivo(memorization) s
100         0.03                0.0279
250         0.186               0.318
400         0.5                 0.58
550         1.02                1.009
700         1.66                1.09
850         2.41                1.64
1000        3.17                3.39
"""
