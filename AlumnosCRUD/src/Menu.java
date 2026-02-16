import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws Exception {

        int opc;
        Scanner sc= new Scanner(System.in);
        AlumnoService alumnoService= new AlumnoService();
        Alumno[] alumnos = new Alumno[25];

        do{
            System.out.println("----Menu----");
            System.out.println("1.-Alta Alumno");
            System.out.println("2.-Buscar por ID ");
            System.out.println("3.-Baja logica por ID");
            System.out.println("4.-Listar activos");
            System.out.println("5.-Actualizar promedio por ID");
            System.out.println("6.-Reportes");
            System.out.println("0.-Salir");
            System.out.println("----Menu----");
            opc=sc.nextInt();
            switch (opc) {
                case 1:
                    alumnoService.alta(alumnos, sc);
                    break;
                case 2:
                    alumnoService.buscarPorId(alumnos, sc);
                    break;
                case 3:
                    alumnoService.baja(alumnos, sc);
                    break;
                case 4:
                    alumnoService.listarActivas(alumnos, sc);
                    break;
                case 5:
                    alumnoService.actualizarPromedio(alumnos, sc);
                    break;
                case 6:
                    alumnoService.reportes(alumnos, sc);
                    break;
                case 0:
                    System.out.println("Selecciono la opcion de salir");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opc!=0);
    }


}
