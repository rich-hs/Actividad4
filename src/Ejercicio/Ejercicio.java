package Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio {
    public static void main(String[] args) {
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String texto="";
            char opcion='1';
            Agenda mi_agenda= new Agenda();
            while ((opcion=='1') || (opcion=='2')|| (opcion=='3') )
            {

                System.out.println("1-Nuevo contacto");
                System.out.println("2-Eliminar contacto");
                System.out.println("3-Lista de contactos");
                System.out.println("0-Salir");
                System.out.println("......................");
                texto=teclado.readLine();
                opcion= texto.charAt(0);
                System.out.println("Seleccione opción: ");
                System.out.println("......................");

                switch(opcion){
                    case '1':
                        String nombre;
                        String telefono;
                        boolean validar;
                        System.out.println("Por favor introduzca el nombre:");
                        nombre=teclado.readLine();
                        System.out.println("Por favor introduzca el numero telefonico:");
                        telefono=teclado.readLine();
                        validar=esNumerica(telefono);
                        if (validar){
                            int telefono_entero= Integer.parseInt(telefono);
                            mi_agenda.Consultar(nombre, telefono_entero);
                            mi_agenda.Anadir(nombre, telefono_entero);
                        }
                        else{
                            System.out.println("Formato incorrecto, intente de nuevo por favor.");}


                        break;
                    case '2':
                        mi_agenda.Eliminar();
                        break;
                    case '3':
                        mi_agenda.Mostrar();
                        break;
                    case '0':
                        System.out.println("Usted salio del programa.");
                        break;

                    default:
                        System.out.println("Opción incorrecta ...");
                        opcion='1';

                }

            }

        } catch (IOException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static boolean esNumerica(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}

