import java.util.Scanner;

public class AlumnoService {

    boolean alumnoEncontrado = false;

    public void alta(Alumno[] alumnos, Scanner sc){

        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del alumno para darlo de alta");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }
        if(verificarId(id, alumnos)){
            System.out.println("Ese id ya existe");
            return;
        }

        System.out.println("Ingresa el nombre del alumno");
        sc.nextLine();
        String nombre = sc.nextLine();
        if(nombre.isBlank()){
            System.out.println("No se admite valores vacios");
            return;
        }

        double promedio = input.getValidDouble(sc, "Ingresa el promedio del alumno");
        if(promedio < 0 || promedio > 10){
            System.out.println("No se admite valores vacios");
            return;
        }

        int indiceInsercion= obtenerIndice(alumnos);
        if(indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Alumno alumnos1= new Alumno(id, nombre, promedio);
        alumnos[indiceInsercion] = alumnos1;
    }

    public void baja(Alumno[] alumnos, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del alumno para realizar la baja");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (int i = 0; i < alumnos.length; i++){
            if (alumnos [i] != null && alumnos [i].getId() == id){
                alumnos[i] = null;
                System.out.println("Alumno dado de baja de forma exitosa");
                break;
            }
        }

        for (Alumno alumno : alumnos) {
            System.out.println("________");
            System.out.println(alumno);
        }
    }

    public void buscarPorId(Alumno[] alumnos, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del alumno para realizar la busqueda");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (Alumno alumno : alumnos){
            if (alumno != null && alumno.getId() == id){
                System.out.println("Alumno encontrado");
                System.out.println(alumno);
                alumnoEncontrado = true;
                break;
            }
        }

        if (!alumnoEncontrado){
            System.out.println("No se encontro el ID de el alumno");
        }
    }

    public void listarActivas(Alumno[] alumnos, Scanner sc){
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.activo){
                System.out.println("________");
                System.out.println(alumno);
            }
        }
    }

    public void actualizarPromedio(Alumno[] alumnos, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del alumno para actualizar el promedio");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (int i = 0; i < alumnos.length; i++){
            if (alumnos[i] != null && alumnos[i].getId() == id){

                System.out.println("Promedio actual: " + alumnos[i].getPromedio());
                System.out.println("Ingresa el nuevo promedio del alumno");
                double newPromedio = sc.nextDouble();

                if(newPromedio < 0 || newPromedio > 10){
                    System.out.println("No se admite valores vacios");
                    return;
                }

                alumnos[i].setPromedio(newPromedio);
                System.out.println("Promedio actualizado");
                break;
            }
        }
    }

    public void reportes(Alumno[] alumnos, Scanner sc){

        double sumaPromedio = 0.0;
        int contadorAlumnosActivos = 0;
        int contadorAlumnosConOcho = 0;
        Alumno promedioMayor = null;
        Alumno promedioMenor = null;

        for (Alumno alumno : alumnos){
            if (alumno != null && alumno.isActivo()){

                contadorAlumnosActivos++;
                sumaPromedio+= alumno.getPromedio();

                if (alumno.getPromedio() >= 8.0){
                    contadorAlumnosConOcho++;
                }

                if (alumno.getPromedio() >= 9.0 && alumno.getPromedio() <= 10.0){
                    promedioMayor = alumno;
                }

                if (alumno.getPromedio() >= 7.0 && alumno.getPromedio() <= 8.0){
                    promedioMenor = alumno;
                }
            }
        }

        if (contadorAlumnosActivos == 0){
            System.out.println("No hay alumnos activos para realizar el reporte");
            return;
        }

        double promedioGeneral = sumaPromedio / contadorAlumnosActivos;

        System.out.println("Promedio general de alumnos activos: " + promedioGeneral);
        System.out.println("Alumno activo con mayor promedio: " + promedioMayor);
        System.out.println("Alumno activo con menor promedio: " + promedioMenor);
        System.out.println("Alumnos activos que tienen promedio mayor o igual a 8.0: " + contadorAlumnosConOcho);

    }

    public boolean verificarId(int id, Alumno[] alumnos){

        for (Alumno alumno : alumnos) {
            if(alumno!=null && alumno.getId()==id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Alumno[] alumnos){

        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i]==null){
                return i;
            }
        }
        return -1;
    }


}
