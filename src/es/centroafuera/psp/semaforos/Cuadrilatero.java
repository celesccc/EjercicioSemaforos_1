package es.centroafuera.psp.semaforos;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cuadrilatero {

    Luchador luchador1, luchador2;
    private static final int MAXIMO = 2;
    private final Semaphore semaforo = new Semaphore(MAXIMO, true);

    public void addParticipante(Luchador luchador) throws InterruptedException {
        semaforo.acquire();
        if (luchador1 == null) {
            luchador1 = luchador;
            if (luchador2 != null)
                lucha();
        } else {
            luchador2 = luchador;
            lucha();
        }
    }

    public void lucha () throws InterruptedException {
        Luchador ganador, perdedor;
        boolean ganar = new Random().nextBoolean();

        System.out.println(luchador1.getName() + " vs " + luchador2.getName());
        if (ganar) {
            ganador = luchador1;
            perdedor = luchador2;
        } else {
            ganador = luchador2;
            perdedor = luchador1;
        }

        System.out.println("Ganador: " + ganador.getName() + " vs Perdedor: " + perdedor.getName());
        System.out.println("==============================================");
        cambioLuchador(perdedor);
    }

    public void cambioLuchador (Luchador luchador) {
        if (luchador1 == luchador)
            luchador1 = null;
        else
            luchador2 = null;
        semaforo.release();
    }
}
