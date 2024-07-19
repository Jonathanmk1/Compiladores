
package ANALISIS_SINTACTICO;

import java.util.*;

public class GLC {
    List<Produccio> productions;
    static Map<Integer, Map<String, Acciones>> actionTable;
    Map<Integer, Map<String, Integer>> gotoTable;

    GLC() {
        productions = new ArrayList<>(); 
       actionTable = new HashMap<>();
        gotoTable = new HashMap<>();
        initializeGrammar();
        initializeTables();
    }

    private void initializeGrammar() {
        productions.add(new Produccio("P", Arrays.asList("class", "I", "{", "V", "}")));
        productions.add(new Produccio("P", Arrays.asList("class", "I", "{", "}")));
        productions.add(new Produccio("P", Arrays.asList("class", "I")));
        productions.add(new Produccio("I", Arrays.asList("a")));
        productions.add(new Produccio("I", Arrays.asList("b")));
        productions.add(new Produccio("I", Arrays.asList("c")));
        productions.add(new Produccio("V", Arrays.asList("T", "I", ";")));
        productions.add(new Produccio("T", Arrays.asList("int")));
        productions.add(new Produccio("T", Arrays.asList("string")));
    }

    private void initializeTables() {
        // Acción
        actionTable.put(0, new HashMap<>());
        actionTable.get(0).put("class", new Acciones(Acciones.ActionType.SHIFT, 1));

        actionTable.put(1, new HashMap<>());
        actionTable.get(1).put("a", new Acciones(Acciones.ActionType.SHIFT, 2));
        actionTable.get(1).put("b", new Acciones(Acciones.ActionType.SHIFT, 3));
        actionTable.get(1).put("c", new Acciones(Acciones.ActionType.SHIFT, 4));

        actionTable.put(2, new HashMap<>());
        actionTable.get(2).put("{", new Acciones(Acciones.ActionType.SHIFT, 5));
        actionTable.get(2).put("$", new Acciones(Acciones.ActionType.ACCEPT, -1));

        actionTable.put(3, new HashMap<>());
        actionTable.get(3).put("{", new Acciones(Acciones.ActionType.SHIFT, 5));
        actionTable.get(3).put("$", new Acciones(Acciones.ActionType.ACCEPT, -1));

        actionTable.put(4, new HashMap<>());
        actionTable.get(4).put("{", new Acciones(Acciones.ActionType.SHIFT, 5));
        actionTable.get(4).put("$", new Acciones(Acciones.ActionType.ACCEPT, -1));

        actionTable.put(5, new HashMap<>());
        actionTable.get(5).put("int", new Acciones(Acciones.ActionType.SHIFT, 6));
        actionTable.get(5).put("string", new Acciones(Acciones.ActionType.SHIFT, 7));
        actionTable.get(5).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(6, new HashMap<>());
        actionTable.get(6).put("a", new Acciones(Acciones.ActionType.SHIFT, 9));
        actionTable.get(6).put("b", new Acciones(Acciones.ActionType.SHIFT, 10));
        actionTable.get(6).put("c", new Acciones(Acciones.ActionType.SHIFT, 11));

        actionTable.put(7, new HashMap<>());
        actionTable.get(7).put("a", new Acciones(Acciones.ActionType.SHIFT, 12));
        actionTable.get(7).put("b", new Acciones(Acciones.ActionType.SHIFT, 13));
        actionTable.get(7).put("c", new Acciones(Acciones.ActionType.SHIFT, 14));

        actionTable.put(8, new HashMap<>());
        actionTable.get(8).put("$", new Acciones(Acciones.ActionType.ACCEPT, -1));

        actionTable.put(9, new HashMap<>());
        actionTable.get(9).put(";", new Acciones(Acciones.ActionType.SHIFT, 15));

        actionTable.put(10, new HashMap<>());
        actionTable.get(10).put(";", new Acciones(Acciones.ActionType.SHIFT, 16));

        actionTable.put(11, new HashMap<>());
        actionTable.get(11).put(";", new Acciones(Acciones.ActionType.SHIFT, 17));

        actionTable.put(12, new HashMap<>());
        actionTable.get(12).put(";", new Acciones(Acciones.ActionType.SHIFT, 18));

        actionTable.put(13, new HashMap<>());
        actionTable.get(13).put(";", new Acciones(Acciones.ActionType.SHIFT, 19));

        actionTable.put(14, new HashMap<>());
        actionTable.get(14).put(";", new Acciones(Acciones.ActionType.SHIFT, 20));

        actionTable.put(15, new HashMap<>());
        actionTable.get(15).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(16, new HashMap<>());
        actionTable.get(16).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(17, new HashMap<>());
        actionTable.get(17).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(18, new HashMap<>());
        actionTable.get(18).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(19, new HashMap<>());
        actionTable.get(19).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        actionTable.put(20, new HashMap<>());
        actionTable.get(20).put("}", new Acciones(Acciones.ActionType.SHIFT, 8));

        gotoTable.put(0, new HashMap<>());
        gotoTable.get(0).put("P", 21);

        gotoTable.put(1, new HashMap<>());
        gotoTable.get(1).put("I", 22);

        gotoTable.put(5, new HashMap<>());
        gotoTable.get(5).put("V", 23);
    }

}
