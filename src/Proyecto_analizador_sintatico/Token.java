package Proyecto_analizador_sintatico;

public class Token {
    private String valor;
    private Tipos tipo;
    private int id;

    public Token() {
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public Tipos getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    enum Tipos {
        TIPO_BASE(1, "int|String"),
        PALABRA_RESERVADA(2, "class"),
        LLAVE_A(3, "\\{"),
        LLAVE_C(4, "\\}"),
        PUNTO_Y_COMA(5, ";"),
        ESPACIO_BLANCO(6, "[ \n\r\t]"),
        COMENTARIO(7, "/\\*.*?\\*/"),
        IDENTIFICADOR(8, "[a-c](\\w|[A-C])*"),
        ErrorLexico(9, "@|¿"),
        DESCONOCIDO(10, "Desconocido");

        private final int id;
        public final String patron;

        Tipos(int id, String s) {
            this.id = id;
            this.patron = s;
        }

        public int getId() {
            return id;
        }
    }
}
