import java.sql.SQLOutput;
import java.util.Scanner;



public class App {
    public static void main(String[] args) throws Exception {

        int opc;
        Scanner sc= new Scanner(System.in);
        PersonaService personaService= new PersonaService();
        Persona[] personas = new Persona[20];

        do{
            System.out.println("----Menu----");
            System.out.println("1.-Alta");
            System.out.println("2.-Buscar por ID ");
            System.out.println("3.-Baja logica por ID");
            System.out.println("4.-Listar activas");
            System.out.println("5.-Actualizar nombre por ID");
            System.out.println("0.-Salir");
            System.out.println("----Menu----");
            opc=sc.nextInt();
            switch (opc) {
                case 1:
                    personaService.alta(personas, sc);
                    break;
                case 2:
                    personaService.buscarPorId(personas, sc);
                    break;
                case 3:
                    personaService.baja(personas, sc);
                    break;
                case 4:
                    personaService.listarActivas(personas, sc);
                    break;
                case 5:
                    personaService.actualizarNombre(personas, sc);
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