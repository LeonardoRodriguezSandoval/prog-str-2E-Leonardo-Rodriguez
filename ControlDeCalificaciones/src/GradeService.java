import javax.security.auth.Subject;

public class GradeService {

    public GradeService(){

    }

    private double a = 0;
    private double b = 0;
    private double c = 0;
    private int asistencia = 0;
    private double promedio = 0;
    private double calificacionFinal = 0;
    private boolean entregoProyecto;

    public double calcularPromedio(double a, double b, double c){
        promedio = (a + b + c) / 3;
        return promedio;
    }

    public double calcularFinal(double promedio, int asistencia){
        double conversionPromedio = promedio * 10;
        return (conversionPromedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double calificacionFinal, int asistencia, boolean entregoProyecto){

        if (calificacionFinal>=70 && asistencia >= 80 && entregoProyecto){
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

}
