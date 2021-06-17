package Ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {

    Contacto[] lista_contactos = new Contacto[99];
    private int contador_contactos = 0;

    public void Consultar(String nombre, int telefono) {
        for (int i = 0; i < this.contador_contactos; i++) {

            if (nombre.equals(this.lista_contactos[i].getNombre())) {
                System.out.println("Contacto existente");
            }
        }

    }

    public void Anadir(String nombre, int telefono) {
        if (contador_contactos < 99) {
            this.lista_contactos[contador_contactos] = new Contacto();
            this.lista_contactos[contador_contactos].set_nombre(nombre);
            this.lista_contactos[contador_contactos].set_telefono(telefono);
            this.contador_contactos++;

        } else {
            System.out.println("Ya no hay espacio en la agenda");
        }

    }


    public void Mostrar() {
        if (this.contador_contactos == 0) {
            System.out.println("No hay contactos");
        } else {
            for (int t = 0; t < this.contador_contactos; t++) {
                System.out.println(this.lista_contactos[t].getNombre() + "-" + "Telefono:" + Integer.toString(this.lista_contactos[t].getTelefono()));
            }
        }
    }


    public void Eliminar() {
        try {
            boolean encontrado = false;
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre de contacto a eliminar:");
            String eliminar = teclado.readLine().toUpperCase();
            if (contador_contactos == 0) {
                System.out.println("No hay contactos");
            } else {
                for (int i = 0; i < contador_contactos; i++) {

                    if (eliminar.equals(this.lista_contactos[i].getNombre())) {
                        System.out.println(i + 1 + ". " + this.lista_contactos[i].getNombre() + "-" + "Tf:" + this.lista_contactos[i].getTelefono());
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    System.out.println("¿Qué contacto quieres eliminar, introduce el número asociado?");
                    int eliminar_numero = Integer.parseInt(teclado.readLine());
                    eliminar_numero--;
                    System.out.println("¿Estas seguro (Si(s)/no(n))?");
                    String respuesta;
                    respuesta = teclado.readLine();
                    respuesta = respuesta.toUpperCase();
                    if (respuesta.equals("S")) {
                        Contacto[] temporal = new Contacto[99];
                        int ii = 0;
                        boolean encontrado2 = false;
                        for (int i = 0; i < this.contador_contactos; i++) {

                            if (i != eliminar_numero) {
                                if (!encontrado2) {
                                    temporal[ii] = this.lista_contactos[ii];
                                    ii++;
                                } else {
                                    if (ii < this.contador_contactos) {
                                        temporal[ii] = this.lista_contactos[ii + 1];
                                        ii++;
                                    }
                                }

                            } else {
                                temporal[ii] = this.lista_contactos[ii + 1];
                                ii++;
                                encontrado2 = true;

                            }
                        }
                        this.contador_contactos--;
                        System.out.println("Contacto eliminado exitosamente");
                        for (int j = 0; j < this.contador_contactos; j++) {
                            this.lista_contactos[j] = temporal[j];

                        }

                    }

                } else {
                    System.out.println("Contacto inexistente o mal escrito.");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
