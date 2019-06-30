/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoarchivo;
import javax.swing.*;
import java.io.*;

public class ProyectoArchivo {
    
    public static void limpiarconsola(){
           for ( int i = 0 ; i < 15 ; i++ ) 
           { 
                   System.out.println(); 
           } 
    }
    
    public static void main(String[] args){
        
      
   
         ListArchivo l=new ListArchivo();
         int opcion;
         String Menu="***MENU ARCHIVO***\n\n1. Mostrar-Leer\n2. Ingresar nuevo Registro\n3. Actualizar-Modificar\n4. Borrar\n5. Buscar\n6. Salir"
         + "\n\nDigite opcion:";
         
         String nomb;
         int ced,ed,cedcam;
         float not;
     do{
             opcion=Integer.parseInt(JOptionPane.showInputDialog(Menu));
             
            switch(opcion){
                
                case 1:
                    
                      limpiarconsola();
                      l.MostrarArchivo();
                    
                break;
                    
                case 2:
                        limpiarconsola();
                        ced=Integer.parseInt(JOptionPane.showInputDialog("Ingrese Cedula: "));
                        nomb=JOptionPane.showInputDialog(null,"Ingrese Nombre: ");
                        ed=Integer.parseInt(JOptionPane.showInputDialog("Ingrese Edad:"));
                        not=Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota: "));
                        while(not >5){
                             JOptionPane.showMessageDialog(null,"La nota debe de estar entre 0 y 5\nVuelva y digite el valor de la nota");
                             not=Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota: "));
                        }  
                        l.Insertarfinal(ced, nomb, ed, not);      
                break;
                    
                case 3:
                        limpiarconsola();
                       if(l.MostrarArchivo()==1){
                                 JOptionPane.showMessageDialog(null,"No hay Registros para Modificar");
                       }
                       else{
                            cedcam=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cedula del registro\n que desea modificar: "));
                            l.Modificar(cedcam);
                            limpiarconsola();
                            l.MostrarArchivo();
                       }  
                          
                break;
                    
                case 4:
                        limpiarconsola();
                       if(l.MostrarArchivo()==1){
                                 JOptionPane.showMessageDialog(null,"No hay Registros para Borrar");
                                 limpiarconsola();
                       }
                       else{
                          
                             cedcam=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cedula del registro\n que desea Borrar: "));
                             l.BorrarLinea(cedcam);
                             limpiarconsola();
                            
                       }
                break;
                    
                case 5:
                        limpiarconsola();
                       if(l.MostrarArchivo()==1){
                                 JOptionPane.showMessageDialog(null,"No hay Registros para Buscar");
                       }
                       else{
                            limpiarconsola();
                            l.MostrarArchivo();
                            cedcam=Integer.parseInt(JOptionPane.showInputDialog("Ingrese cedula del registro que desea buscar: "));
                            limpiarconsola();
                            l.Buscar(cedcam);
                       }
                break;
                    
                case 6:
                         System.exit(0);
                break;
            
                 default:    JOptionPane.showMessageDialog(null,"Opcion no Valida");
                 break;
            }
      }while(opcion!=7); 

    }

}
