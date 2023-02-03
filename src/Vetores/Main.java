
package trab6;
public class Main {


    public static void main(String[] args) {
        Vetor2D vetorA = new Vetor2D();
        Vetor2D vetorB = new Vetor2D();
        vetorA.coordenadax = 3;
        vetorA.coordenaday = 4;
        vetorB.coordenadax = 2;
        vetorB.coordenaday = -1;
        System.out.println(Vetor2D.produtoEscalar(vetorA, vetorB));
        if(Vetor2D.testardependencia(vetorA, vetorB)){
            System.out.println("A e B sao linearmente dependentes");
        }System.out.println("A e B nao sao linearmente dependentes");
        Vetor3D vetA = new Vetor3D();
        Vetor3D vetB = new Vetor3D();
        Vetor3D vetC = new Vetor3D();
        vetA.coordenadax = -1;
        vetA.coordenaday = 1;
        vetA.coordenadaz = -1;
        vetB.coordenadax = 1;
        vetB.coordenaday = 2;
        vetB.coordenadaz = 0;
        vetC.coordenadax = 3;
        vetC.coordenaday = 0;
        vetC.coordenadaz = 2;
        if(Vetor3D.testardependencia2(vetA, vetB)){
            System.out.println("A e B sao linearmente dependentes");
        }else
        System.out.println("A e B nao sao linearmente dependentes");
        if(Vetor3D.testardependencia2(vetA, vetC)){
            System.out.println("A e C sao linearmente dependentes");
        }else
        System.out.println("A e C nao sao linearmente dependentes");
        if(Vetor3D.testardependencia2(vetB, vetC)){
            System.out.println("B e C sao linearmente dependentes");
        }else
        System.out.println("B e C nao sao linearmente dependentes");
        if(Vetor3D.testardependencia3(vetA, vetB,vetC)){
            System.out.println("A,B e C sao linearmente dependentes");
        }else
        System.out.println("A,B e C nao sao linearmente dependentes");
    }
    
}
