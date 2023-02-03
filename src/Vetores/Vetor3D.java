package trab6;

public class Vetor3D extends Vetor {

    double coordenadaz;

    public Vetor3D() {
        coordenadax = 0;
        coordenaday = 0;
        coordenadaz = 0;
    }

    public Vetor3D(double x, double y, double z) {

        this.coordenadax = x;
        this.coordenaday = y;
        this.coordenadaz = z;
    }

    public Vetor3D(double[] vet) {
        vet[0] = coordenadax;
        vet[1] = coordenaday;
        vet[2] = coordenadaz;
    }

    protected static Vetor3D adicao(Vetor3D vetA, Vetor3D vetB) {
        Vetor3D vettemp = new Vetor3D();
        vettemp.coordenadax = vetA.coordenadax + vetB.coordenadax;
        vettemp.coordenaday = vetA.coordenaday + vetB.coordenadax;
        vettemp.coordenadaz = vetA.coordenadaz + vetB.coordenadaz;
        return vettemp;
    }

    protected static Vetor3D subtracao(Vetor3D vet1, Vetor3D vet2) {
        Vetor3D vetR = new Vetor3D();

        vetR.coordenadax = vet2.coordenadax - vet1.coordenadax;
        vetR.coordenaday = vet1.coordenaday - vet2.coordenaday;
        vetR.coordenadaz = vet1.coordenadaz - vet2.coordenadaz;
        return vetR;

    }
    
    protected Vetor Soma(Vetor v){
        super.Soma(v);
        return v;
    }

    protected double norma() {
        double norma;
        norma = Math.sqrt((this.coordenadax * this.coordenadax) + (this.coordenaday * this.coordenaday) + (this.coordenadaz * this.coordenadaz));
        return norma;
    }

    protected static boolean testardependencia2(Vetor3D vetA, Vetor3D vetB) {
        if ((vetA.coordenadax / vetB.coordenadax) == (vetA.coordenaday / vetB.coordenaday) && (vetA.coordenadaz / vetB.coordenadaz) == (vetA.coordenadax / vetB.coordenadax) && (vetA.coordenadaz / vetB.coordenadaz) == (vetA.coordenaday / vetB.coordenaday)) {
            return true;
        }
        return false;
    }

    protected static boolean testardependencia3(Vetor3D vetA, Vetor3D vetB, Vetor3D vetC) {
        double det;
        det = ((vetA.coordenadax * vetB.coordenaday * vetC.coordenadaz) + (vetA.coordenaday * vetB.coordenadaz * vetC.coordenadax) + (vetA.coordenadaz * vetB.coordenadax * vetC.coordenaday)) - ((vetA.coordenadaz * vetB.coordenaday * vetC.coordenadax) + (vetA.coordenaday * vetB.coordenadax * vetC.coordenadaz) + (vetA.coordenadax * vetB.coordenadaz * vetC.coordenaday));
        //v11 × v22 × v33                 + v12 × v23 × v31                      + v13 × v21 × v32                       − v13 × v22 × v31                   + v12 × v21 × v33                     + v11 × v23 × v32
        if (det == 0) {
            return true;
        }
        return false;
    }

    protected static double produtoEscalar(Vetor3D vet1, Vetor3D vet2) {
        double res = 0;
        for (int i = 0; i < 3; i++) {
            res = (vet1.coordenadax * vet2.coordenadax) + (vet1.coordenaday * vet2.coordenaday) + (vet1.coordenadaz * vet2.coordenadaz);
        }

        return res;
    }

    protected static Vetor3D produtoVet(Vetor3D vet1, Vetor3D vet2) {
        Vetor3D res = new Vetor3D();

        res.coordenadax = (vet1.coordenaday * vet2.coordenadaz) - (vet1.coordenadaz * vet2.coordenaday);
        res.coordenaday = (vet1.coordenadaz * vet2.coordenadax) - (vet1.coordenadax * vet2.coordenadaz);
        res.coordenadaz = (vet1.coordenadax * vet2.coordenaday) - (vet1.coordenaday * vet2.coordenadax);

        return res;
    }
    
     protected static Vetor3D[] Ortonomaliza(Vetor3D v1,Vetor3D v2,Vetor3D v3){
        Vetor3D[] vecs = new Vetor3D[2];
        if((v1 instanceof Vetor3D) && (v2 instanceof Vetor3D) && !(Vetor3D.testardependencia3(v1,v2,v3))){
            vecs[0] = new Vetor3D();
            vecs[1] = new Vetor3D();
            
            vecs[0].coordenadax = v1.coordenadax/v1.norma();
            vecs[0].coordenaday = v1.coordenaday/v1.norma();
            vecs[0].coordenadaz = v1.coordenadaz/v1.norma();
            
            vecs[1].coordenadax = v2.coordenadax - Vetor3D.produtoEscalar(v1,v2)/(v1.norma())*(v1.norma())*v1.coordenadax;
            vecs[1].coordenaday = v2.coordenaday - Vetor3D.produtoEscalar(v1,v2)/(v1.norma())*(v1.norma())*v1.coordenaday;
            vecs[1].coordenadaz = (v2.coordenadaz - Vetor3D.produtoEscalar(v2,v3)/(v2.norma())*(v2.norma())*v1.coordenaday)-(Vetor3D.produtoEscalar(v1,v3)/(v1.norma())*(v1.norma())*v1.coordenadax);
            
            vecs[1].coordenadax = vecs[1].coordenadax/vecs[1].norma();
            vecs[1].coordenaday = vecs[1].coordenaday/vecs[1].norma();
            vecs[1].coordenadaz = vecs[1].coordenadaz/vecs[1].norma();
        }

        return vecs;
    }
}
