package Proyecto_analizador_sintatico;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Pruebas {

//    public static void main(String[] args) {
////        Scanner s = new Scanner(System.in);
////        
////        System.out.println("Ingresa lo que desee:");
////        String entrada = s.nextLine();
//        String entrada = "11 + 22 - 33";
//        ArrayList<Token> tokens = lex(entrada);
//        for (Token token : tokens){
//            System.out.println(token.getTipo() + " : " + token.getValor() );
//        }
//    }
    public static ArrayList<Token> lex(String entrada) {
        final ArrayList<Token> tokens = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(entrada, "\n\r\t{}()[];\" ", true);
        boolean com_di_ant = false;
        boolean com_doble_linea = false;

        while (st.hasMoreTokens()) {
            String palabra = st.nextToken();

            if (!com_di_ant && palabra.startsWith("/*")) {
                com_di_ant = true; // Iniciar comentario de bloque
            }

            if (!com_doble_linea && !com_di_ant && palabra.startsWith("//")) {
                com_doble_linea = true; // Iniciar comentario de línea
            }

            if (!com_di_ant && !com_doble_linea) {

                String[] palabras = palabra.split("\\s+"); // Dividir la palabra por espacios
                for (String token : palabras) {
                    if (!token.isEmpty()) {
                        boolean encontrado = false;

                        for (Token.Tipos tokenTipo : Token.Tipos.values()) {
                            Pattern patron = Pattern.compile(tokenTipo.patron);
                            Matcher busqueda = patron.matcher(token);

                            if (busqueda.matches()) {
                                Token nuevoToken = new Token();
                                nuevoToken.setId(tokenTipo.getId());
                                nuevoToken.setTipo(tokenTipo);
                                nuevoToken.setValor(token);
                                tokens.add(nuevoToken);
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            Token tokenDesconocido = new Token();
                            tokenDesconocido.setId(Token.Tipos.DESCONOCIDO.getId());
                            tokenDesconocido.setTipo(Token.Tipos.DESCONOCIDO);
                            tokenDesconocido.setValor(token);
                            tokens.add(tokenDesconocido);
                        }
                    }
                }
            }

            if (com_di_ant && palabra.endsWith("*/")) {
                com_di_ant = false; // Termina comentario de bloque
            }

            if (palabra.endsWith("\n")) {
                com_doble_linea = false; // Termina comentario de línea
            }
        }
        return tokens;
    }
}
