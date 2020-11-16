package es.centroafuera.psp.semaforos;

public class Luchador extends Thread {

    Cuadrilatero cuadrilatero;

    public Luchador (Cuadrilatero cuadrilatero){
        this.cuadrilatero = cuadrilatero;
    }

    @Override
    public void run() {
        try {
            cuadrilatero.addParticipante(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}




