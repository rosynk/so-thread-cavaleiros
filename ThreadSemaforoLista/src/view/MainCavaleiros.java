package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCavaleiros;

public class MainCavaleiros {
    public static void main(String[] args) {
    	Semaphore tocha = new Semaphore(1);
    	Semaphore pedra = new Semaphore(1);
    	int portaCorreta = gerarPortaCorreta();
        
    	
    	System.out.println("A porta correta é a: " + portaCorreta + ", mas só vc sabe disso!!");
    	
        for (int i = 0; i < 4; i++) {
            Thread threadCavaleiros = new ThreadCavaleiros(i, tocha, pedra, portaCorreta); 
            threadCavaleiros.start(); 
        }
    }
    
    public static int gerarPortaCorreta() {
    	
        //4 = quantidade de cavaleiros >>> gera um número de 0 a 3
        //O certo seria passar esse 4 como parâmetro aqui e na Thread, para poder ter mais cavaleiros
    	
        return (int) (Math.random() * 4);
    }
}