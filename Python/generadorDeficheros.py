#!/usr/bin/env python
import sys
import random
import re
"""
Script para generar un fichero con vectores aleatorios pares
"""
if __name__ == '__main__':
    if len(sys.argv) != 2:
        lon = int(sys.argv[1])
        ft = open(str(sys.argv[2]) + ".txt", "w+")
        i = 2
        arr = []
        while i <= lon:
            for j in range(i-2,i):
                arr.append(random.randint(0,100))
            ft.write(re.sub(',', '', re.sub('[\[\]]', '', str(arr))) + "\n")
            i = i + 2
        ft.close()
        print("FIN")
    else:
        print("FALLO EN EL ARGUMENTO")
        exit(1)