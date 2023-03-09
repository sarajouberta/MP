package uo.mp.lab05.dome.model;

public interface Borrowable {

    /**
     * Método que devuelve un valor booleano indicando si el item está
     * disponible o no
     * 
     * @return true si disponibles/ false en caso contrario
     */
    public boolean isAvailable();

    /**
     * Método que presta un item
     */
    public void borrow();

    /**
     * Método que devuelve un item
     */
    public void giveBack();

}
