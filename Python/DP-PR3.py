#!/usr/bin/env python
import sys
import time


def optimalStrategyOfGameMemoization(table,arr,i,j):
    if(i == j):
        return arr[i]
    if((i+2) <= j): x = optimalStrategyOfGameMemoization(table, arr, i+2, j)
    else: x = 0
    if ((i + 1) <= j-1): y = optimalStrategyOfGameMemoization(table, arr, i + 1, j-1)
    else: y = 0
    if (i <= (j-2)): z = optimalStrategyOfGameMemoization(table, arr, i, j-2)
    else: z = 0

    (table[i])[j] = max(arr[i] + min(x,y), arr[j] + min(y,z))
    return (table[i])[j]


def optimalStrategyOfGameTabulation(arr, n):
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
    return table[0][n - 1]

def llamada_tiempo_memoization(fichero,ft):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():
            arr.append(int(palabra))
            # Definición del diccionario
        table = {}
        for i in range(len(arr)):
            # creación par(clave(número entero),valor(lista))
            table[i] = []
            for j in range(len(arr)):
                # asignación para la lista
                table[i].append(0)
        st = time.time()
        print(optimalStrategyOfGameMemoization(table, arr, 0, len(arr) - 1))
        medida = time.time() - st
        ft.write(str(len(arr)) + "--" + str(medida) + "\n")
        print("tiempo: " + str(medida))

def llamada_tiempo_tabulation(fichero,ft):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():
            arr.append(int(palabra))
        st = time.time()
        print(optimalStrategyOfGameTabulation(arr,len(arr)))
        medida = time.time() - st
        ft.write(str(len(arr)) + "--" + str(medida) + "\n")
        print("tiempo: " + str(medida))

def llamada_funcionamiento_tabulation(fichero):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():arr.append(int(palabra))
        print("Para" + str(arr))
        print(optimalStrategyOfGameTabulation(arr,len(arr)))

def llamada_funcionamiento_memoization(fichero):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():
            arr.append(int(palabra))
            # Definición del diccionario
        table = {}
        for i in range(len(arr)):
            # creación par(clave(número entero),valor(lista))
            table[i] = []
            for j in range(len(arr)):
                # asignación para la lista
                table[i].append(0)
        print("Para" + str(arr))
        print(optimalStrategyOfGameMemoization(table, arr, 0, len(arr) - 1))



if __name__ == '__main__':
    if len(sys.argv) > 1:
        if sys.argv[1] == "-t":
            for i in range(2, len(sys.argv)):
                print("------------------------------------------------------- "
                      + str(i - 1) +
                      "Fichero -------------------------------------------------------------------------------------------")
                ft = open("tiempos_Memoization.txt", "w+")
                ft.write("##### TIEMPOS " +  str(sys.argv[i]) + " ####\n")
                llamada_tiempo_memoization(sys.argv[i], ft)
                ft.close()
        elif sys.argv[1] == "-T":
            for i in range(2, len(sys.argv)):
                print("------------------------------------------------------- "
                      + str(i - 1) +
                      "Fichero -------------------------------------------------------------------------------------------")
                ft = open("tiempos_Tabulation.txt", "w+")
                ft.write("##### TIEMPOS " +  str(sys.argv[i]) + " ####\n")
                llamada_tiempo_tabulation(sys.argv[i], ft)
                ft.close()
        else:
            for i in range(1, len(sys.argv)):
                print("------------------------------------------------------- "
                      + str(i) +
                      "Fichero -------------------------------------------------------------------------------------------")
                print("Algoritmo por Memoization")
                llamada_funcionamiento_memoization(sys.argv[i])
                print("\nAlgoritmo por Tabulation")
                llamada_funcionamiento_tabulation(sys.argv[i])
    else:
        print("FALLO EN EL ARGUMENTO")
        exit(1)

