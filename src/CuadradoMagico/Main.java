package CuadradoMagico;

public class Main {
public static int [][] cuadrado;
    public static void main(String[] args) {
        int lado=0;
        lado=Metodos.pedirLado();
        cuadrado=Metodos.crearCuadrado(lado);
        Metodos.rellenarCuadrado(cuadrado);
        Metodos.mostrarCuadrado(cuadrado);


    }

}
