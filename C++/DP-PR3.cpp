#include "DP-PR3.h"

/**
 * optimalStrategyOfGameMemoization: Método recursivo que hace uso
 * de una tabla hash con la librería 'unordered_map' para usar la
 * técnica de 'Memoization'. El algoritmo se basa en la técnica de
 * tabulación de la fuente original. Se usa como 'key' la posición
 * del array multidimensional si no se usara un mapa.
 *
 * @param map Mapa Hash
 * @param n Longitud del array
 * @param arr Array del problema
 * @param i posición
 * @param j posición
 * @return mapa con key 'i*n+j'
 */
int optimalStrategyOfGameMemoization(unordered_map<int, int> map, int n, int arr[], int i, int j){
    int valor = i*n+j;
    if(map.find(valor) == map.end()){
        int x, y, z;
        if(i == j){
            return arr[i];
        }
        if((i+2) <= j){
            x = optimalStrategyOfGameMemoization(map, n, arr, i+2, j);
        } else{
            x = 0;
        }
        if((i+1) <= (j-1)){
            y = optimalStrategyOfGameMemoization(map, n, arr, i+1, j-1);
        } else{
            y = 0;
        }
        if(i <= (j-2)){
            z = optimalStrategyOfGameMemoization(map, n, arr, i, j-2);
        } else{
            z = 0;
        }
        map[i*n+j] = max(arr[i] + min(x,y), arr[j] + min(y,z));
    }
    return map[i*n+j];
}

/**
 * optimalStrategyOfGameTabulation: Método que implementa el algoritmo
 * original de resolución del problema mediante la técnica de 'Tabulation'.
 * Está basado en la fuente original (geeksforgeeks.org)
 *
 * @param arr Array del problema
 * @param n Longitud del array
 * @return solución al problema
 */
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

/**
 * llamada_tiempo_memoization: Método que lee del fichero pasado por parámetro
 * y forma los vectores y mapas hash correspondientes para las llamadas a
 * optimalStrategyOfGameMemoization(). Escribe en el fichero pasado con el
 * ofstream por parámetro el tiempo y además lo imprime por pantalla junto al resultado.
 *
 * @param fichero fichero a leer
 * @param fs ofstream para escribir
 */
void llamada_tiempo_memoization(const string &fichero, ofstream& fs){
    int numero, iteraciones = 0;
    double segundos;
    int *array;
    string linea;
    clock_t t0;
    ifstream ifs(fichero);
    ///Se abre el fichero y se detecta si hay algún problema.
    if(! ifs.is_open()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Para cada línea del fichero, se rellena un vector y se llama al método correspondiente. Se muestran las salidas adecuadas.
    while(! ifs.eof()){
        iteraciones = iteraciones + 1;
        cout << "################ " << iteraciones << " iteracion ################" << endl;
        list<int> lista;
        getline(ifs, linea);
        istringstream isstream(linea);
        while(!isstream.eof()){
            isstream >> numero;
            lista.push_back(numero);
        }
        array = new int[lista.size()];
        copy(lista.begin(), lista.end(), array);
        unordered_map<int, int> mapa;
        t0 = clock();
        printf("Resultado: %d\n", optimalStrategyOfGameMemoization(mapa, static_cast<int>(lista.size()), array, 0,
                                                                   static_cast<int>(lista.size() - 1)));
        segundos = (double(clock() - t0)/CLOCKS_PER_SEC);
        fs << "Tamaño: " << lista.size() << " -- " << segundos << " segundos" << endl;
        cout << "Tiempo: " << segundos << endl;
    }
    ///Se comprueba el estado del ifstream.
    if(ifs.bad()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Se cierra el ifstream.
    ifs.close();
}

/**
 * llamada_tiempo_tabulation: Método que lee del fichero pasado por parámetro
 * y forma los vectores correspondientes para las llamadas a
 * optimalStrategyOfGameTabulation(). Escribe en el fichero pasado con el
 * ofstream por parámetro el tiempo y además lo imprime por pantalla junto al resultado.
 *
 * @param fichero fichero a leer
 * @param fs ofstream para escribir
 */
void llamada_tiempo_tabulation(const string &fichero, ofstream& fs){
    int numero, iteraciones = 0;
    double segundos;
    int *array;
    string linea;
    clock_t t0;
    ifstream ifs(fichero);
    ///Se abre el fichero y se detecta si hay algún problema.
    if(! ifs.is_open()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Para cada línea del fichero, se rellena un vector y se llama al método correspondiente. Se muestran las salidas adecuadas.
    while(! ifs.eof()){
        iteraciones = iteraciones + 1;
        cout << "################ " << iteraciones << " iteracion ################" << endl;
        list<int> lista;
        getline(ifs, linea);
        istringstream isstream(linea);
        while(!isstream.eof()){
            isstream >> numero;
            lista.push_back(numero);
        }
        array = new int[lista.size()];
        copy(lista.begin(), lista.end(), array);
        t0 = clock();
        printf("Resultado: %d\n", optimalStrategyOfGameTabulation(array, static_cast<int>(lista.size())));
        segundos = (double(clock() - t0)/CLOCKS_PER_SEC);
        fs << "Tamaño: " << lista.size() << " -- " << segundos << " segundos" << endl;
        cout << "Tiempo: " << segundos << endl;
    }
    ///Se comprueba el estado del ifstream.
    if(ifs.bad()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Se cierra el ifstream.
    ifs.close();
}

/**
 * llamada_tiempo_memoization: Método que lee del fichero pasado por parámetro
 * y forma los vectores y mapas hash correspondientes para las llamadas a
 * optimalStrategyOfGameMemoization(). Imprime por pantalla junto al resultado
 * el vector al que corresponde.
 *
 * @param fichero fichero a leer
 */
void llamada_funcionamiento_memoization(const string &fichero){
    int numero, iteraciones = 0;
    int *array;
    string linea;
    ifstream ifs(fichero);
    ///Se abre el fichero y se detecta si hay algún problema.
    if(! ifs.is_open()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Para cada línea del fichero, se rellena un vector y se llama al método correspondiente. Se muestran las salidas adecuadas.
    while(! ifs.eof()){
        iteraciones = iteraciones + 1;
        cout << "################ " << iteraciones << " iteracion ################" << endl;
        list<int> lista;
        getline(ifs, linea);
        istringstream isstream(linea);
        while(!isstream.eof()){
            isstream >> numero;
            lista.push_back(numero);
        }
        array = new int[lista.size()];
        copy(lista.begin(), lista.end(), array);
        unordered_map<int, int> mapa;
        cout << "Para: ";
        for(int i = 0; i < lista.size(); i++){
            cout << array[i] << " ";
        }
        printf("\nResultado: %d\n", optimalStrategyOfGameMemoization(mapa, static_cast<int>(lista.size()), array, 0,
                                                                     static_cast<int>(lista.size() - 1)));
    }
    ///Se comprueba el estado del ifstream.
    if(ifs.bad()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Se cierra el ifstream.
    ifs.close();
}

/**
 * llamada_tiempo_tabulation: Método que lee del fichero pasado por parámetro
 * y forma los vectores correspondientes para las llamadas a
 * optimalStrategyOfGameTabulation(). Imprime por pantalla junto al resultado
 * el vector al que corresponde.
 *
 * @param fichero fichero a leer
 */
void llamada_funcionamiento_tabulation(const string &fichero){
    int numero, iteraciones = 0;
    int *array;
    string linea;
    ifstream ifs(fichero);
    ///Se abre el fichero y se detecta si hay algún problema.
    if(! ifs.is_open()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Para cada línea del fichero, se rellena un vector y se llama al método correspondiente. Se muestran las salidas adecuadas.
    while(! ifs.eof()){
        iteraciones = iteraciones + 1;
        cout << "################ " << iteraciones << " iteracion ################" << endl;
        list<int> lista;
        getline(ifs, linea);
        istringstream isstream(linea);
        while(!isstream.eof()){
            isstream >> numero;
            lista.push_back(numero);
        }
        array = new int[lista.size()];
        copy(lista.begin(), lista.end(), array);
        cout << "Para: ";
        for(int i = 0; i < lista.size(); i++){
            cout << array[i] << " ";
        }
        printf("\nResultado: %d\n", optimalStrategyOfGameTabulation(array, static_cast<int>(lista.size())));
    }
    ///Se comprueba el estado del ifstream.
    if(ifs.bad()){
        cout << "Ha ocurrido un error leyendo el fichero" << endl;
        exit(-1);
    }
    ///Se cierra el ifstream.
    ifs.close();
}

/**
 * main: Método principal que lee los argumentos pasados en la consola y a raíz de
 * éstos actúa de un modo u otro.
 *
 * @param argc número de argumentos
 * @param argv argumentos
 * @return -1 si fallan los argumentos, 0 si no lo hace.
 */
int main(int argc, char *argv[]) {
    if(argc > 1){
        if(argv[1] == string("-t")){
            for(int i = 2; i < argc; i++){
                printf("------------------------------------"
                       " %d "
                       "Fichero ------------------------------------\n", (i-1));
                ofstream fs("tiempos_Memoization.txt");
                fs << "#### TIEMPOS " << argv[i] << " ####" << endl;
                llamada_tiempo_memoization(argv[i], fs);
                fs.close();
            }
        }else if(argv[1] == string("-T")){
            for(int i = 2; i < argc; i++){
                printf("------------------------------------"
                       " %d "
                       "Fichero ------------------------------------\n", (i-1));
                ofstream fs("tiempos_Tabulation.txt");
                fs << "#### TIEMPOS " << argv[i] << " ####" << endl;
                llamada_tiempo_tabulation(argv[i], fs);
                fs.close();
            }
        }else{
            for(int i = 1; i < argc; i++){
                printf("------------------------------------"
                       " %d "
                       "Fichero ------------------------------------\n", (i-1));
                printf("Algoritmo por Memoization\n");
                llamada_funcionamiento_memoization(argv[i]);
                printf("\nAlgoritmo por Tabulation\n");
                llamada_funcionamiento_tabulation(argv[i]);
            }
        }
    }else{
        printf("FALLO EN EL ARGUMENTO");
        return -1;
    }
    return 0;
}