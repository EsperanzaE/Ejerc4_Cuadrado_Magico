package CuadradoMagico;



public class Metodos {
    public static final int CERO=0;
    public static final int X=0;
    public static final int Y=1;
    public static final int UNO=1;
    public static final int DOS=2;


    /**
     * se le pide al usuario por consola que meta un número válido, ha deser impar entre 2 y 9
     * precondicion:ninguna
     * posticondicio: ha de devolver un número impar positivo entre 2 y 9
     *
     * @return el valor del lado entre 2 y 9
     */
    public static int pedirLado() {// no lo he desarrollado por ahora
        return 9;
    }

    /**
     * se crea un cuadrado de lada el introducido por pantalla
     * precondicion: lado ha de ser un número impar
     *
     * @param lado
     * @return el cuadrado con todos los valores a 0 menos el punto intermedio de la primera fila
     */
    public static int[][] crearCuadrado(int lado) {
        int[][] cuadrado = new int[lado][lado];//creamos el cuadrado de lado por lado
        cuadrado[CERO][(int) (lado / DOS)] = UNO;//metemos un 1 en la mitad de la primera fila
        return cuadrado;
    }

    /**
     * se rellena un cuadrado con el método: numeros correlativos a partir del  1 desplazándose desde la posición
     * anterior una fila hacia arriba y una columna hacia la izquierda. Si la nueva posición está ya ocupada,
     * en lugar de desplazarse una fila hacia arriba y una columna hacia la izquierda, se moverá simplemente una
     * fila hacia abajo y continuará el proceso. La matriz cuadrado rellena se devolverá en los propios argumentos de
     * la función
     * @param cuadrado matriz de lado por lado con el valor 1 en la casilla de la mitad de la primer fila
     */
    public static void rellenarCuadrado(int[][] cuadrado) {
        int[] punto=new int[2]; // guardamos la posición original
        int numCasillas;// guardamos el numero de casillas del cuadrado
        int valor=1;//guardamos el ultimo valor introducido en el cuadrado mágico
        //montamos el punto de partida
        punto[X]=CERO; //coordenada x del punto original
        punto[Y]=(int)cuadrado.length/DOS;//coordenada y del punto original
        cuadrado[punto[X]] [punto[Y]]=valor;
        //calculamos el número de cuadros del cuadrado
        numCasillas= cuadrado.length*cuadrado.length;
        valor++;//ponemos a dos el siguiente valor a introducir en el cuadrado mágico
        while (valor<numCasillas) {
            devolverPosicion(punto, cuadrado);
            cuadrado[punto[X]][punto[Y]] = valor;
            valor++;
        }
    }

    /**
     * se busca la nueva posicion  desplazándose desde la posición
     * anterior una fila hacia arriba y una columna hacia la izquierda. Si la nueva posición está ya ocupada,
     * en lugar de desplazarse una fila hacia arriba y una columna hacia la izquierda, se moverá simplemente una
     * fila hacia abajo
     * @param punto con la posición de la última casilla rellenada
     * @param cuadrado mágico
     */
    private static void devolverPosicion(int [] punto, int[][] cuadrado) {
        int newX,newY;
        newX=punto[CERO]-1;
        newY=punto[UNO]-1;
        // VALIDAMOS QUE LAS NUEVAS COORDENADAS NO SE SALEN DE LOS LIMITES DE NUESTRA MATRIZ
        if (newX<CERO){
            newX=cuadrado.length-1;
        }
        else {
            if (newX== cuadrado.length){
                newX=CERO;
            }
        }
        if (newY<CERO){
            newY=cuadrado.length-1;
        }
        else {
            if (newY== cuadrado.length){
                newY=CERO;
            }
        }
        //Validamos que en la nueva coordenada no haya ya un número, si no, bajamos una celda para abajo
        if (cuadrado[newX][newY]!=0){
            newX=punto[X]+UNO;
            newY=punto[Y];
        }
        punto[X]=newX;
        punto[Y]=newY;
    }

    public static void mostrarCuadrado(int[][] cuadrado) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("El cuadrado mágico es el siguiente");
        stringBuilder.append("\n");
        for (int elemento[]: cuadrado ) {
            for (int elemento2: elemento){
                stringBuilder.append(Integer.valueOf(elemento2)+" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
}
