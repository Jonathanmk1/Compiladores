package ANALISIS_SINTACTICO;
import javax.swing.JTextArea;
import java.util.*;

public class parser {
    GLC grammar;
    Stack<Integer> stateStack;
    Stack<String> symbolStack;

    parser(GLC grammar) {
        this.grammar = grammar;
        stateStack = new Stack<>();
        symbolStack = new Stack<>();
    }

    void parse(String input, JTextArea outputArea) {
        stateStack.push(0);
        symbolStack.push("$");

        String[] tokens = input.split(" ");
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        tokenList.add("$");

        int index = 0;
        while (index < tokenList.size()) {
            String token = tokenList.get(index);
            int currentState = stateStack.peek();
            Acciones action = GLC.actionTable.get(currentState).get(token);
                    //GLC.actionTable.get(currentState).get(token);

            if (action == null) {
                outputArea.append("Error de sintaxis en el token: " + token + "\n");
                return;
            }

            outputArea.append(action.toString() + "\n");
            if (action.actionType == Acciones.ActionType.SHIFT) {
                stateStack.push(action.state);
                symbolStack.push(token);
                index++;
            } else if (action.actionType == Acciones.ActionType.REDUCE) {
                for (int i = 0; i < action.production.rhs.size(); i++) {
                    stateStack.pop();
                    symbolStack.pop();
                }
                if (action.production.lhs.equals("V")) {
                    // Reducción para V -> T o V -> T I
                    symbolStack.push("V");
                } else if (action.production.lhs.equals("M")) {
                    // Reducción para M -> V ; o M -> I ;
                    int gotoState = grammar.gotoTable.get(stateStack.peek()).get("M");
                    stateStack.push(gotoState);
                    symbolStack.push("M");
                } else {
                    // Reducción para las otras producciones
                    int gotoState = grammar.gotoTable.get(stateStack.peek()).get(action.production.lhs);
                    stateStack.push(gotoState);
                    symbolStack.push(action.production.lhs);
                }
            } else if (action.actionType == Acciones.ActionType.ACCEPT) {
                outputArea.append("Cadena aceptada.\n");
                return;
            }

            outputArea.append("Pila de estados: " + stateStack + "\n");
            outputArea.append("Pila de símbolos: " + symbolStack + "\n");
        }

        outputArea.append("Error: cadena no aceptada.\n");
    }
}

