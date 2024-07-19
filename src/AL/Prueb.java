
package AL;

import AL.Token.Tipos;
import java.util.*;
import java.util.regex.*;

public class Prueb {

        public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        
//        System.out.println("Ingresa lo que desee:");
//        String entrada = s.nextLine();
        String entrada = "11 + 22 - 33";
        ArrayList<Token> tokens = lex(entrada);
        for (Token token : tokens){
            System.out.println(token.getTipo() + " : " + token.getValor() );
        }
    }

    private static ArrayList<Token> lex(String entrada) {
         
        final ArrayList<Token> tokens = new ArrayList();
        final StringTokenizer st = new StringTokenizer(entrada);
        boolean banderas = false;
        
        while (st.hasMoreTokens()){
            String palabra = st.nextToken();
            boolean encontrado = false;
            
            for(Tipos tokenTipo: Tipos.values()){
                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher busqueda = patron.matcher(palabra);
                
                if (busqueda.find()){
                    Token token = new Token();
                    
                    token.setTipo(tokenTipo);
                    token.setValor(palabra);
                    tokens.add(token);
                    encontrado = true;
                    break; // Salir del bucle una vez que se haya encontrado un token válido.
                }
            }
            
            if(!encontrado){
                // Si no se encontró ningún token válido para la palabra actual, lanzar la excepción.
                throw new RuntimeException("Token invalido, desconoce token: " + palabra);
            }
        }
        return tokens;
    }
}