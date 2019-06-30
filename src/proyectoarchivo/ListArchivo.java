
package proyectoarchivo;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ListArchivo {
    nodo cab;
    
     public ListArchivo(){
        cab=null;
        this.cargarTxt();
        
    }
     
     public void cargarTxt(){
        if(MostrarArchivo()==1){
            JOptionPane.showMessageDialog(null,"El archivo esta vacio");
           
        }
        else{
             
            
                     try (FileReader fr = new FileReader("archivo.txt")) {
                        BufferedReader br = new BufferedReader(fr);
                            String linea= null;
                             while((linea = br.readLine())!=null){
                                 StringTokenizer st = new StringTokenizer(linea,",");
                    
                                     Insertarfinal(Integer.parseInt(st.nextToken()),st.nextToken(),Integer.parseInt(st.nextToken()),Float.parseFloat(st.nextToken()));
                        
                              }
                             br.close();
                     }
                     catch(Exception e){
                             JOptionPane.showMessageDialog(null,"Error al cargar archivo: "+e);
                     }
                
            
            
       }
    }
     
     public int  MostrarArchivo(){
     int cont=0;
        try{
            FileReader fr=new FileReader("archivo.txt");
            BufferedReader br=new BufferedReader(fr);
            String cadena;
            
            while((cadena=br.readLine())!= null){
               System.out.println(""+cadena);
               cont++;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
        }
       
         return(cont);
    }
     
     public void Buscar(int cedcam){
             
            String cedcambio;
            cedcambio=String.valueOf(cedcam);
           // String concatenar1=" ";
            String concatenar="";
            try{
            FileReader fr=new FileReader("archivo.txt");
            BufferedReader br=new BufferedReader(fr);
            String cadena;
            boolean sw=true;
            
                while((cadena=br.readLine())!= null && sw==true) {
                  //  if(cadena.equals(cedcambio)){
                       // int numTokens = 0;
                        StringTokenizer st = new StringTokenizer(cadena,",");
                       
                        
                        // while (st.hasMoreTokens() && sw==true)
                        //{
                             if(cedcambio.equals(st.nextToken())){
                                 
                                 
                                  JOptionPane.showMessageDialog(null,"El Resgistro fue encontrado con exito\n"+cedcambio+" "+st.nextToken()+" "+st.nextToken()+" "+st.nextToken());
                                  System.out.println("El Resgistro fue encontrado con exito");
                                  System.out.println(cadena);
                                  sw=false;
                             }
                             
                              
                        // }
                         
                }
                         if(sw==true){
                         JOptionPane.showMessageDialog(null,"El Resgistro no fue encontrado");
                         }
               
              
            }
             catch(Exception e){
            JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
            } 
            
    }
     
     public void Insertarfinal(int c,String name,int ed,float nt) {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        boolean sw=true;
         nodo q=cab;
         nodo p=new nodo(c,name,ed,nt);
         
         
         if(cab==null){
            cab=p;
           
             try{
                 f=new File("archivo.txt");
                 w=new FileWriter(f);
                 bw=new BufferedWriter(w);
                 wr=new PrintWriter(bw);
                
                
                 wr.println(p.getCedula()+","+p.getNombre()+","+p.getEdad()+","+p.getNota()+",");
                
                 wr.close();
                 bw.close();
                 
             }
             catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
             }
         }
         else{
             
            while(q.getLiga()!= null ){
                if(c == q.getCedula()){
                    sw=false;
                }
                q=q.getLiga();
            }
            if(q.getCedula()==p.getCedula()){
                sw=false;
            }
            try{
                if(sw==true){
                    f=new File("archivo.txt");
                    w=new FileWriter(f,true);
                    bw=new BufferedWriter(w);
                    wr=new PrintWriter(bw);
                
                
                    wr.println(p.getCedula()+","+p.getNombre()+","+p.getEdad()+","+p.getNota()+",");
                
                     wr.close();
                     bw.close();
                     q.setLiga(p);
                }
                else{
                    JOptionPane.showMessageDialog(null,"El registro no se puede validar ya que la \ncedula ingresada ya esta registrada");
                }
             }
             catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
             }
           
         }
        
    }
     
     public void Modificar(int cedcam){
         nodo q=cab;
         int cont=0;
         int ce,e;
         String no;
         float nt;
         int op;
          String Menumod="***MENU MODIFICAR***\n\n1. Modificar todo\n2. Modificar Cedula\n3. Moficar Nombre\n4. Modificar edad\n5. Modificar Nota\n6. Atras"
          + "\n\nDigite opcion:";
          
          do{
              op=Integer.parseInt(JOptionPane.showInputDialog(Menumod));
             
            switch(op){
                
                case 1:
                            
                        ce=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva Cedula: "));
                        no=JOptionPane.showInputDialog(null,"Ingrese nuevo Nombre: ");
                        e=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva Edad:"));
                        nt=Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva Nota: "));
                        while(nt >5){
                             JOptionPane.showMessageDialog(null,"La nota debe de estar entre 0 y 5\nVuelva y digite el valor de la nota");
                             nt=Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota: "));
                        }
         
                         if(cab==null){
                         JOptionPane.showMessageDialog(null,"Archivo vacio");
                         }
                         else{
                             while(q!=null){
                                 if(q.getCedula()== cedcam){
                     
                                 q.setCedula(ce);
                                 q.setNombre(no);
                                 q.setEdad(e);
                                 q.setNota(nt);
                                 cont++;
                                }
                                 q=q.getLiga();
                            }
                        if(cont==0){
                        JOptionPane.showMessageDialog(null,"La cc del registro que desea modificar\nno esta en el archivo");
                        }
                        ModificandoArchivo();
                     }
                    
                break;
                    
                case 2:
                        ce=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva Cedula: "));
                        
                         if(cab==null){
                         JOptionPane.showMessageDialog(null,"Archivo vacio");
                         }
                         else{
                             while(q!=null){
                                 if(q.getCedula()== cedcam){
                     
                                 q.setCedula(ce);
                                 
                                 cont++;
                                }
                                 q=q.getLiga();
                            }
                        if(cont==0){
                        JOptionPane.showMessageDialog(null,"La cc del registro que desea modificar\nno esta en el archivo");
                        }
                        ModificandoArchivo();
                     }
                       
                break;
                    
                case 3:
                        
                        no=JOptionPane.showInputDialog(null,"Ingrese nuevo Nombre: ");
                        
                         if(cab==null){
                         JOptionPane.showMessageDialog(null,"Archivo vacio");
                         }
                         else{
                             while(q!=null){
                                 if(q.getCedula()== cedcam){
     
                                 q.setNombre(no);
                                 cont++;
                                }
                                 q=q.getLiga();
                            }
                        if(cont==0){
                        JOptionPane.showMessageDialog(null,"La cc del registro que desea modificar\nno esta en el archivo");
                        }
                        ModificandoArchivo();
                     }
                       
                break;
                    
                case 4:
                       
                        e=Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva Edad:"));
                         if(cab==null){
                         JOptionPane.showMessageDialog(null,"Archivo vacio");
                         }
                         else{
                             while(q!=null){
                                 if(q.getCedula()== cedcam){
                     
                                 
                                 q.setEdad(e);
                                 
                                 cont++;
                                }
                                 q=q.getLiga();
                            }
                        if(cont==0){
                        JOptionPane.showMessageDialog(null,"La cc del registro que desea modificar\nno esta en el archivo");
                        }
                        ModificandoArchivo();
                     }
                break;
                    
                case 5:
                       
                        nt=Float.parseFloat(JOptionPane.showInputDialog("Ingrese nueva Nota: "));
                        while(nt >5){
                             JOptionPane.showMessageDialog(null,"La nota debe de estar entre 0 y 5\nVuelva y digite el valor de la nota");
                             nt=Float.parseFloat(JOptionPane.showInputDialog("Ingrese Nota: "));
                        }
         
                         if(cab==null){
                         JOptionPane.showMessageDialog(null,"Archivo vacio");
                         }
                         else{
                             while(q!=null){
                                 if(q.getCedula()== cedcam){
                                 q.setNota(nt);
                                 cont++;
                                }
                                 q=q.getLiga();
                            }
                        if(cont==0){
                        JOptionPane.showMessageDialog(null,"La cc del registro que desea modificar\nno esta en el archivo");
                        }
                        ModificandoArchivo();
                     }
                        
                break;
                    
                case 6:
                        op=7; 
                break;
            
                 default:    JOptionPane.showMessageDialog(null,"Opcion no Valida");
                 break;
            }
          }while(op!=7);
         
         
     }
     
     public void ModificandoArchivo(){
       boolean sw=true;
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
     nodo q=cab;
     if(cab==null){
         JOptionPane.showMessageDialog(null,"No hay Registros para agregar al archivo");
     }
        
         while(q!=null){
             if(sw==true){
                try{
                
                    f=new File("archivo.txt");
                    w=new FileWriter(f);
                    bw=new BufferedWriter(w);
                    wr=new PrintWriter(bw);
                    sw=false;
                
                     wr.println(q.getCedula()+","+q.getNombre()+","+q.getEdad()+","+q.getNota()+",");
                
                     wr.close();
                     bw.close();
                 
                }
                 catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
                 }
             }
             else{
                 try{
                
                        f=new File("archivo.txt");
                        w=new FileWriter(f,true);
                        bw=new BufferedWriter(w);
                        wr=new PrintWriter(bw);
                
                
                         wr.println(q.getCedula()+","+q.getNombre()+","+q.getEdad()+","+q.getNota()+",");
                
                         wr.close();
                        bw.close();
                 
                  }
                   catch(Exception e){
                        JOptionPane.showMessageDialog(null,"Existe un error en: "+e);
                  } 
             }
             q=q.getLiga();
         }
     
     }
     
     public void MostrarLista(){
     
        nodo q=cab;
        
        if(cab==null){
            JOptionPane.showMessageDialog(null,"Lista Vacia");
        }
        else{
            JOptionPane.showMessageDialog(null,"NUEVA LISTA");
            while(q!=null){
                
            JOptionPane.showMessageDialog(null,"REGISTRO: "+q.getCedula()+"  "+q.getNombre()+"  "+q.getEdad()+"  "+q.getNota());
            q=q.getLiga();
            }
        }
      
     } 
     
     public void BorrarLinea(int cedcam){
            
            nodo q=cab,ant=null;
            boolean sw=false;
            
            if(cab==null){
                JOptionPane.showMessageDialog(null,"Lista vacia");
            }
            else{
                //Elimina la primera ocurrencia
                while((q!=null)&&(sw==false)){
                
                    if(q.getCedula()==cedcam){
                        sw=true;
                        JOptionPane.showMessageDialog(null,"El registro con cedula "+q.getCedula()+" Se elimino con exito ");
                    }
                    else{
                           ant=q;
                           q=q.getLiga();
                    } 
                }
                if(sw==false){
                    JOptionPane.showMessageDialog(null,"La cedula ingresada no se encuentra en el archivo");
                }
                else{
                    if(q==cab){
                        cab=cab.getLiga();
                    }
                    else{
                        ant.setLiga(q.getLiga());
                    }
                    //delete(q);
                
                }
            }
            ModificandoArchivo();
        }    
}
