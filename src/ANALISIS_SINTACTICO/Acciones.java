
package ANALISIS_SINTACTICO;


public class Acciones {
     enum ActionType {SHIFT, REDUCE, ACCEPT}

    ActionType actionType;
    int state; // For shift actions
    Produccio production; // For reduce actions

    Acciones(ActionType actionType, int state) {
        this.actionType = actionType;
        this.state = state;
    }

    Acciones(ActionType actionType, Produccio production) {
        this.actionType = actionType;
        this.production = production;
    }

    @Override
    public String toString() {
        if (actionType == ActionType.SHIFT) {
            return "Desplazamiento: " + state;
        } else if (actionType == ActionType.REDUCE) {
            return "Reducción: " + production.lhs + " -> " + String.join(" ", production.rhs);
        } else {
            return "Aceptación";
        }
    }

}
