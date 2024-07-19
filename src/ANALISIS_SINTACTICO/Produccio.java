package ANALISIS_SINTACTICO;

import java.util.List;

public class Produccio {
    String lhs;
    List<String> rhs;

    Produccio(String lhs, List<String> rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
