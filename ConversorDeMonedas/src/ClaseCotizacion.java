public class ClaseCotizacion {
    float resultado;

    public ClaseCotizacion(Cotizacion cotizacion){
        this.resultado = cotizacion.conversion_result();
    }

    public float getResultado() {
        return resultado;
    }
}


