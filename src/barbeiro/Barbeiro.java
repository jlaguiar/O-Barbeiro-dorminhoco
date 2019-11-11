/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeiro;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joao luiz
 */
public class Barbeiro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        Threads threads = new Threads();
        System.out.println("Quantidade de cadeiras ?");
        VariveisCompartilhadas.qtddCadeiras = ler.nextInt();
        VariveisCompartilhadas.qtddOcupadas = 0;
        VariveisCompartilhadas.fila = new ArrayList<Integer>() ;
        VariveisCompartilhadas.barbeiro = false;
        
        while (true) {
            (new Thread(threads.barbeirando)).start();
            

        }
    }

}
