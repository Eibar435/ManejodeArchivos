package com.company;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    private  Scanner sc;
    HashMap Map=new HashMap();

    public void create(){
        sc = new Scanner(System.in);
        System.out.println ("------------------------ Crear Nuevo Contacto -------------------------");
        System.out.println ("Numero:");
        String numero=sc.nextLine();
        System.out.println ("Nombre:");
        String nombre=sc.nextLine();

        Contacto newOne = new Contacto (numero, nombre);
        Map.put (numero, newOne);
        System.out.println ("Contacto Agregado Correctamente");
        System.out.println (" ");
    }

    public void delete(){
        sc = new Scanner(System.in);
        System.out.println ("------ Eliminar Contacto ------");
        System.out.println ("Ingrese el numero que se eliminará:");
        String numero=sc.nextLine();
        if (Map.containsKey (numero)) {
            System.out.println(Map.get(numero).toString());
            System.out.println ("¿Está seguro de que desea eliminar este contacto 1 (sí) 0 (no)");
            int flag=sc.nextInt();
            if(flag==1){
                Map.remove(numero);
                System.out.println ("Contacto Eliminado Correctamente");
                System.out.println (" ");
            }else{
                System.out.println ("Proceso Cancelado");
                System.out.println (" ");
            }
        }else{
            System.out.println ("El numero no existe");
            System.out.println (" ");
        }
    }

    //Imprimir todo
    public void list(){
        System.out.println ("------ Mostrar Todos Los Contactos -----");
        Iterator iter = Map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            System.out.println(entry.getValue().toString());
        }
        System.out.println (" ");
    }

    public void load() throws IOException{
        System.out.println ("Cargando contactos del archivo...");
        DataInputStream in=new DataInputStream(new FileInputStream("contact.txt"));
        boolean flag=true;
        while(flag){
            try{
                String numero=in.readUTF();
                String nombre=in.readUTF();
                Contacto newOne = new Contacto (numero, nombre);
                Map.put (numero, newOne);
            }catch(EOFException e){
                flag=false;
            }
        }
        in.close();
        System.out.println (" ");
    }

    public void save1() throws Exception{
        System.out.println ("Guardando Contactos...");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("contact1.txt"));
        Iterator iter = Map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Contacto val = (Contacto) entry.getValue();
            out.writeObject(val);
        }
        out.close();
    }
}
