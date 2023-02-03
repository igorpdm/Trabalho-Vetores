package trab6;

public class Vetor2D extends Vetor {

    public Vetor2D() {
        this.coordenadax = 0;
        this.coordenaday = 0;
    }

    public Vetor2D(double x, double y) {
        this.coordenadax = x;
        this.coordenaday = y;
    }

    public Vetor2D(Vetor2D vet) {
        this.coordenadax = vet.coordenadax;
        this.coordenaday = vet.coordenaday;
    }

    protected static Vetor2D adicao(Vetor2D vetA, Vetor2D vetB) {
        Vetor2D vettemp = new Vetor2D();
        vettemp.coordenadax = vetA.coordenadax + vetB.coordenadax;
        vettemp.coordenaday = vetA.coordenaday + vetB.coordenaday;
        return vettemp;
    }

    protected static Vetor2D subtracao(Vetor2D vetA, Vetor2D vetB) {
        Vetor2D vettemp = new Vetor2D();
        vettemp.coordenadax = vetA.coordenadax - vetB.coordenadax;
        vettemp.coordenaday = vetA.coordenaday - vetB.coordenaday;
        return vettemp;
    }
    
    protected Vetor2D Soma(Vetor v){
        super.Soma(v);
        return (Vetor2D) v;
    }

    protected static boolean testardependencia(Vetor2D vetA, Vetor2D vetB) {
        if ((vetA.coordenadax / vetB.coordenadax) == (vetA.coordenaday / vetB.coordenaday)) {
            return true;
        }
        return false;
    }
    protected static double produtoEscalar(Vetor2D vetA, Vetor2D vetB){
        double produto = 0;
        produto = (vetA.coordenadax*vetB.coordenadax)+(vetA.coordenaday*vetB.coordenaday);

        return produto;
    }

    public double norma() {
        double norma;
        norma = Math.sqrt((this.coordenadax * this.coordenadax) + (this.coordenaday * this.coordenaday));
        return norma;
    }
    protected static Vetor2D[] Ortonomaliza(Vetor2D v1,Vetor2D v2){
        Vetor2D[] vecs = new Vetor2D[2];
        if((v1 instanceof Vetor2D) && (v2 instanceof Vetor2D) && !(Vetor2D.testardependencia(v1,v2))){
            vecs[0] = new Vetor2D();
            vecs[1] = new Vetor2D();
            
            vecs[0].coordenadax = v1.coordenadax/v1.norma();
            vecs[0].coordenaday = v1.coordenaday/v1.norma();
            
            vecs[1].coordenadax = v2.coordenadax - Vetor2D.produtoEscalar(v1,v2)/(v1.norma())*(v1.norma())*v1.coordenadax;
            vecs[1].coordenaday = v2.coordenaday - Vetor2D.produtoEscalar(v1,v2)/(v1.norma())*(v1.norma())*v1.coordenaday;
            
            vecs[1].coordenadax = vecs[1].coordenadax/vecs[1].norma();
            vecs[1].coordenaday = vecs[1].coordenaday/vecs[1].norma();
        }

        return vecs;
    }

}
