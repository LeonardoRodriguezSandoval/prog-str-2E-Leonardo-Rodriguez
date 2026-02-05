public class ShippingCalculator {

    public int estandar= 50;
    public int express= 90;
    public int kg= 12;
    public double costoPorPesokg;
    public int costoPorDistancia;
    public double subtotal;
    public double costoTotal;
    public double IVA= 0.16;

    public ShippingCalculator(){

    }

    public void procesarOperaciones(double pesoKg, int distanciaKm, boolean esZonaRemota, int tipoDeServicio){
        calcularCostoPorPeso(pesoKg);
        calcularCostoPorDistancia(distanciaKm);
    }

    private void calcularCostoPorPeso(double pesoKg){
        this.costoPorPesokg=pesoKg*kg;
    }

    private void calcularCostoPorDistancia(int distanciaKm){
        if (distanciaKm<=50){
            this.costoPorDistancia= 20;
        } else if (distanciaKm>=51&&distanciaKm<=200) {
            this.costoPorDistancia= 60;
        } else if (distanciaKm>200) {
            this.costoPorDistancia= 120;
        }
    }

    private void calcularSinImpuestos(double costoPorPesokg, int costoPorDistancia,boolean esZonaRemota){
        if (esZonaRemota){
            this.subtotal= costoPorPesokg + costoPorDistancia + (costoPorPesokg + costoPorDistancia * 0.10);
        } else {
            this.subtotal= costoPorPesokg + costoPorDistancia;
        }
    }

    private void calcularTotal(double subtotal, int tipoDeServicio){
        if (tipoDeServicio==1){
            this.costoTotal= subtotal + estandar + (subtotal * IVA);
        } else if (tipoDeServicio==2) {
            this.costoTotal= subtotal + express+ (subtotal * IVA);
        }
    }

    public void imprimirTicket(double pesoKg, int distanciaKm, boolean esZonaRemota, int tipoDeServicio){
        System.out.println("---Ticket---");
        System.out.println("Servicio: " + tipoDeServicio);
        System.out.println("Peso: " + pesoKg);
        System.out.println("Distancia: " + distanciaKm);
        System.out.println("Zona remota: " + esZonaRemota);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Total final: " + this.costoTotal);
        System.out.println("---Ticket---");

    }


}
