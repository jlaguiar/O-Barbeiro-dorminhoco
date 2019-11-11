/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeiro;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author joao luiz
 */
public class Threads extends Thread {

    Random random = new Random();
    boolean bar = false;

    Runnable barbeirando = new Runnable() {
        @Override
        public void run() {
            Long aux = Thread.currentThread().getId();
            Integer valorConvertido = Integer.parseInt(aux.toString());
            insere(valorConvertido);
                if (!bar) {
                    bar = true;
                    System.out.println("Acorda o barbeiro " + VariveisCompartilhadas.fila.get(0));
                    System.out.println("Vai ser atendido ");
                    try {
                        sleep(random.nextInt(1000) + 1);
                    } catch (InterruptedException ex) {
                        System.out.println(ex);
                    }
                    System.out.println("Terminou de ser atendido o " + VariveisCompartilhadas.fila.remove(0));
                    VariveisCompartilhadas.qtddOcupadas--;
                    bar = false;
                } else {
                    System.out.println("Barbeiro trabalhando " + VariveisCompartilhadas.fila.get(0));

                }
            }

        
    };

    public synchronized void insere(int valor) {
        if (VariveisCompartilhadas.qtddOcupadas <= VariveisCompartilhadas.qtddCadeiras) {
            VariveisCompartilhadas.fila.add(valor);
            System.out.println("Senta ai no seu lugar na fila " + valor);
            VariveisCompartilhadas.qtddOcupadas++;
        } else {
            System.out.println("Ta cheio vai embora " + valor);
        }
    }

}
