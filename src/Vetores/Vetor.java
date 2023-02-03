
package trab6;


public class Vetor {
     
    double coordenadax, coordenaday;
     
    protected Vetor Soma(Vetor v){
        if ( v instanceof Vetor2D ) {
            ((Vetor2D) v).coordenadax += this.coordenadax;
            ((Vetor2D) v).coordenaday += this.coordenaday;    
        }
        if ((this instanceof Vetor3D) && (v instanceof Vetor3D)) {
            ((Vetor3D)v).coordenadax += ((Vetor3D)this).coordenadax;
            ((Vetor3D)v).coordenaday += ((Vetor3D)this).coordenaday;
            ((Vetor3D)v).coordenadaz += ((Vetor3D)this).coordenadaz; 
        }
        return v;

    }
    
    protected Vetor Produto(double x){
        if (this instanceof Vetor3D) {
          ((Vetor3D)this).coordenadax = ((Vetor3D)this).coordenadax*x;
          ((Vetor3D)this).coordenaday = ((Vetor3D)this).coordenaday*x;
          ((Vetor3D)this).coordenadaz = ((Vetor3D)this).coordenadaz*x;
        }
        if (this instanceof Vetor2D) {
            ((Vetor2D)this).coordenadax = ((Vetor2D)this).coordenadax*x;
            ((Vetor2D)this).coordenaday = ((Vetor2D)this).coordenaday*x;
        }
        
        return this;
    }
    
    protected double Dimensao(){
        if (this instanceof Vetor2D) {
            return 0;
        }
        if (this instanceof Vetor3D) {
            return 3;
        }
        return 5;
    }
    
    
}
