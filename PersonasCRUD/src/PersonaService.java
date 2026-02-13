import java.util.Scanner;

public class PersonaService {

    boolean personaEncontrada = false;

    public void alta(Persona[] personas, Scanner sc){

        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del nuevo usuario");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }
        if(verificarId(id, personas)){
            System.out.println("Ese id ya existe");
            return;
        }

        System.out.println("Ingresa el nombre del nuevo usuario");
        sc.nextLine();
        String name = sc.nextLine();
        if(name.isBlank()){
            System.out.println("No se admite valores vacios");
            return;
        }

        int indiceInsercion= obtenerIndice(personas);
        if(indiceInsercion==-1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Persona persona1= new Persona(id, name);
        personas[indiceInsercion] = persona1;
    }

    public void baja(Persona[] personas, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del usuario para realizar la baja");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (int i = 0; i < personas.length; i++){
            if (personas [i] != null && personas [i].getId() == id){
                personas[i] = null;
                System.out.println("Usuario eliminado de forma exitosa");
                break;
            }
        }

        for (Persona persona : personas) {
            System.out.println("________");
            System.out.println(persona);
        }
    }

    public void buscarPorId(Persona[] personas, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del usuario para realizar la busqueda");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (Persona persona : personas){
            if (persona != null && persona.getId() == id){
                System.out.println("Usuario encontrado");
                System.out.println(persona);
                personaEncontrada = true;
                break;
            }
        }

        if (!personaEncontrada){
            System.out.println("No se encontro el ID de el usuario");
        }
    }

    public void listarActivas(Persona[] personas, Scanner sc){
        for (Persona persona : personas) {
            if (persona != null && persona.isActive()){
                System.out.println("________");
                System.out.println(persona);
            }
        }
    }

    public void actualizarNombre(Persona[] personas, Scanner sc){
        InputValidator input= new InputValidator();
        int id= input.getValidInt(sc, "Ingresa el Id del usuario para actualizar el nombre");
        if(id<=0){
            System.out.println("No se admiten valores menores que 1");
            return;
        }

        for (int i = 0; i < personas.length; i++){
            if (personas[i] != null && personas[i].getId() == id){

                System.out.println("Nombre actual: " + personas[i].getName());
                System.out.println("Ingresa el nombre del nuevo usuario");
                sc.nextLine();
                String newName = sc.nextLine();

                if(newName.isBlank()){
                    System.out.println("No se admite valores vacios");
                    return;
                }

                personas[i].setName(newName);
                System.out.println("Nombre actualizado");
                break;
            }
        }
    }

    public boolean verificarId(int id, Persona[] personas){

        for (Persona persona : personas) {
            if(persona!=null && persona.getId()==id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Persona[] personas){

        for (int i = 0; i < personas.length; i++) {
            if(personas[i]==null){
                return i;
            }
        }
        return -1;
    }

}