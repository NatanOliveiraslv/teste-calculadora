package org.example.calculadora;

public class Calculadora {

    int somar(int num, int num2) {
        return num + num2;
    }

    int subtrair(int num, int num2) {
        return num - num2;
    }

    int dividir(int num, int num2) {
        return num / num2;
    }

    int multiplicar(int num, int num2) {
        return num * num2;
    }

    int fatorial(int num) {
        if ( num < 2) {
            return num;
        }
        return num * fatorial(num -1);
    }

}
