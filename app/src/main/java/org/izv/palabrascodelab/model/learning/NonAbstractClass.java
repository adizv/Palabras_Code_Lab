package org.izv.palabrascodelab.model.learning;

public class NonAbstractClass extends AbstractClass {

    public NonAbstractClass(int number) {
        super(number);
    }

    @Override
    public void metodoSinImplementar() {
        System.out.println("Ya está implementado.");
    }

    /*@Override
    public int getLengthTimes3(String string) {
        return string.length() * 3;
    }*/

    public static void main(String[] args) {
        NonAbstractClass object = new NonAbstractClass(1);

        //interface
        //object.getLengthTimes3("qqq");

        //herencia de la clase abstracta y lo he implementado
        object.metodoSinImplementar();

        //herencia de la clase abstracta
        object.getNumber();
    }
}
