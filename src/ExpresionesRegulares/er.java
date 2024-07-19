package ExpresionesRegulares;

import java.util.Scanner;

public class er {

    public void ER_digitos(String cad) {
        if (cad.matches("\\d+")) {
            System.out.println("Esto es un digito");
        }
    }

    public void ER_IDENTIF(String cad) {
        if (cad.matches("[a-z](\\w|[A-Z]|\\_|[0-9])+")) {
            System.out.println("Esto es un identificador");
        }
    }

    public void ER_Tipos(String cad) {
        if (cad.matches("int|INT")) {
            //if (cad.matches("[-2147483648 - 2147483647]"))
            System.out.println("Esto es un tipo ");
        }
        if (cad.matches("string | String")) {
            System.out.println("Esto es un tipo");
        }
    }
//una expresion regular que tenga mi nombre

    public void ER_operador(String cad) {
        if (cad.matches("\\d+([-+*/]\\d+)+")) {
            System.out.println("Es un operador aritmetico");
        }
    }

    public void ER_nombre(String cad) {
        if (cad.matches("(Jonathan(\\sJonathan)*)+")) {
            System.out.println("cadena valida");
        } else {
            System.out.println("cadena invalida");
        }

    }

    public static void main(String[] args) {
        er e = new er();
        Scanner s = new Scanner(System.in);
        String cad;
        do {
            System.out.println("Ingrese una cadena: ");
            cad = s.nextLine();
            e.ER_IDENTIF(cad);
            e.ER_Tipos(cad);
            e.ER_digitos(cad);
            e.ER_operador(cad);
            e.ER_nombre(cad);
            if (cad.isEmpty()) {
                break;
            }
        } while (true);
        s.close();
    }
}

//        //vamos a usar el matches
//        String cad = "35345";
//        String cadd= "001110";
//        if(cad.matches("\\d+")){
//            System.out.println("Esto es un digito");
//        }else{
//            System.out.println("no es un digito");
//        }
//        if(cadd.matches("\\d+")){
//            System.out.println("Esto es un digito");
//        }
