package AL;

public class Token {

    private String valor;
    private Tipos tipo;

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

    enum Tipos {
    SUMA("\\+"),
    RESTA("-"),
    NUMERO("\\d+");

    public final String patron;

    private Tipos(String patron) {
        this.patron = patron;
    }
    }
}
