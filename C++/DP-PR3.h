#ifndef UNTITLED_DP_PR3_H
#define UNTITLED_DP_PR3_H

#endif //UNTITLED_DP_PR3_H

#include <iostream>
#include <stdlib.h>
#include <ctime>
#include <string>
#include <fstream>
#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int optimalStrategyOfGameMemoization(unordered_map<int, int> map, int n, int arr[], int i, int j);

int optimalStrategyOfGameTabulation(int* arr, int n);

void llamada_tiempo_memoization(const string &fichero, ofstream& fs);

void llamada_tiempo_tabulation(const string &fichero, ofstream& fs);

void llamada_funcionamiento_memoization(const string &fichero);

void llamada_funcionamiento_tabulation(const string &fichero);




