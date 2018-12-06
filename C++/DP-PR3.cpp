#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int optimalStrategyOfGameMemoization(int *table, int n, int arr[], int i, int j){
    int x, y, z;
    if(i == j){
        return arr[i];
    }
    if((i+2) <= j){
        x = optimalStrategyOfGameMemoization(table, n, arr, i+2, j);
    } else{
        x = 0;
    }
    if((i+1) <= (j-1)){
        y = optimalStrategyOfGameMemoization(table, n, arr, i+1, j-1);
    } else{
        y = 0;
    }
    if(i <= (j-2)){
        z = optimalStrategyOfGameMemoization(table, n, arr, i, j-2);
    } else{
        z = 0;
    }
    table[i*n+j] = max(arr[i] + min(x,y), arr[j] + min(y,z));
    return table[i*n+j];


}

int optimalStrategyOfGameTabulation(int* arr, int n){
    // Create a table to store solutions of subproblems
    int table[n][n];

    // Fill table using above recursive formula. Note
    // that the table is filled in diagonal fashion from diagonal
    // elements to table[0][n-1] which is the result.
    for (int gap = 0; gap < n; ++gap) {
        for (int i = 0, j = gap; j < n; ++i, ++j) {

            // Here x is value of F(i+2, j), y is F(i+1, j-1) and
            // z is F(i, j-2) in above recursive formula
            int x = ((i + 2) <= j) ? table[i + 2][j] : 0;
            int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
            int z = (i <= (j - 2)) ? table[i][j - 2] : 0;

            table[i][j] = max(arr[i] + min(x, y), arr[j] + min(y, z));
        }
    }

    return table[0][n - 1];
}

void llamada_tiempo_memoization(string fichero){

}

void llamada_tiempo_tabulation(string fichero){

}

void llamada_funcionamiento_memoization(string fichero){

}

void llamada_funcionamiento_tabulation(string fichero){

}

int main() {
    int arr1[] = { 8, 15, 3, 7 };

    int n = sizeof(arr1) / sizeof(arr1[0]);
    printf("Tabulacion: %d ", optimalStrategyOfGameTabulation(arr1, n));

    int table0[4][4] = {0};
    printf("Memoization: %d\n", optimalStrategyOfGameMemoization((int *)table0, n, arr1, 0, n-1));

    int arr2[] = { 2, 2, 2, 2 };

    n = sizeof(arr2) / sizeof(arr2[0]);
    printf("Tabulacion: %d ", optimalStrategyOfGameTabulation(arr2, n));

    int table1[4][4] = {0};
    printf("Memoization: %d\n", optimalStrategyOfGameMemoization((int *)table1, n, arr2, 0, n-1));

    int arr3[] = { 20, 30, 2, 2, 2, 10 };

    n = sizeof(arr3) / sizeof(arr3[0]);
    printf("Tabulacion: %d ", optimalStrategyOfGameTabulation(arr3, n));

    int table2[6][6] = {0};
    printf("Memoization: %d\n", optimalStrategyOfGameMemoization((int *)table2, n, arr3, 0, n-1));

    return 0;
}