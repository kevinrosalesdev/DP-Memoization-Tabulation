#!/usr/bin/env python
import sys
import time


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

def llamada_tiempo(fichero,ft):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():
            arr.append(int(palabra))
            # Definicón del diccionario
        table = {}
        for i in range(len(arr)):
            # creación par(clave(número entero),valor(lista))
            table[i] = []
            for j in range(len(arr)):
                # asignación para la lista
                table[i].append(0)
        st = time.time()
        print(optimalStrategyOfGameRecursive(table, arr, 0, len(arr) - 1))
        medida = time.time() - st
        ft.write(str(len(arr)) + "--" + str(medida) + "\n")
        print("tiempo: " + str(medida))


    # Tabla comparativa de tiempos(versión primitiva)
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
def llamada_funcinamiento(fichero):
    iteraciones = 0
    for linea in open(fichero, "r"):
        iteraciones = iteraciones + 1
        print("################ " +
              str(iteraciones) +
              " iteracion ##############")
        arr = []
        for palabra in linea.split():
            arr.append(int(palabra))
            # Definicón del diccionario
        table = {}
        for i in range(len(arr)):
            # creación par(clave(número entero),valor(lista))
            table[i] = []
            for j in range(len(arr)):
                # asignación para la lista
                table[i].append(0)
        print("Para" + str(arr))
        print(optimalStrategyOfGameRecursive(table, arr, 0, len(arr) - 1))

if __name__ == '__main__':
    if len(sys.argv) > 1:
        if sys.argv[1] == "-t":
            for i in range(2, len(sys.argv)):
                print("------------------------------------------------------- "
                      + str(i - 1) +
                      "Fichero -------------------------------------------------------------------------------------------")
                ft = open("tiempos.txt", "w+")
                ft.write("##### TIEMPOS " +  str(sys.argv[i]) + " ####\n")
                llamada_tiempo(sys.argv[i], ft)
                ft.close()
        else:
            for i in range(1, len(sys.argv)):
                print("------------------------------------------------------- "
                      + str(i) +
                      "Fichero -------------------------------------------------------------------------------------------")
                llamada_funcinamiento(sys.argv[i])
    else:
        print("FALLO EN EL ARGUMENTO")
        exit(1)

