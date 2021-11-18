package com.company;
import java.util.Scanner;
//Autor: Eibar Abisai Velazquez Guevara
public class Main {

    public static void main(String[] args) throws Exception  {
        AddressBook con =new AddressBook();

        int flag = 0;
        while(flag==0){
            System.out.println ("******************************************************************************************");
            System.out.println ("---------------------- Agenda telefónica ----------------- ----- ");
            System.out.println (" 1. Crear Nuevo Contacto \n 2. Mostrar Todos Los Contactos De La Agenda  \n 3. Eliminar contacto \n 0. Salir ");
            System.out.println ("---------------------- Sistema de la agenda telefónica ----------------- ----- ");
            System.out.println ("Selecciona El Numero Deseado");
            Scanner sc1 = new Scanner(System.in);
            switch (sc1.nextInt()) {
                case 1:
                    con.create();
                    break;
                case 2:
                    con.list();
                    break;
                case 3:
                    con.delete();
                    break;
                case 0:
                    flag=1;
                    break;
                default:
                    System.out.println ("******************************************************************************************");
                    System.out.println ("************************************ Opcion No Valida ************************************");
                    System.out.println ("******************************** Intenta Con Otro Numero *********************************");
                    break;
            }
        }
    }
}