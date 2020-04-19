package com.JEGA.x00093619;

import java.util.ArrayList;

public class Empresa {
    private String nombreE;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombreE = nombre;
        planilla=new ArrayList<>();
    }

    public String getNombre() {
        return nombreE;
    }

    public void setPlanilla(ArrayList<Empleado> planilla) {
        this.planilla = planilla;
    }

    public void addEmpleado(Empleado emp){

        try {

            boolean exists = false;

            for (Empleado d : planilla) {

                if (d.getDocumentos().equals(emp.getDocumentos())) {

                    exists = true;

                }
            }

            boolean extencionex = false;

            for (Empleado d : planilla) {

                if (d instanceof PlazaFija) {

                    if (((PlazaFija) d).getExtension() == ((PlazaFija) emp).getExtension()) {

                        extencionex = true;
                    }

                }

            }

            if (exists) {

                throw new DocumentAlreadyExistsException("ya existe ese numero de documento en el sistema");

            }

            if (extencionex) {

                throw new ExtensionAlreadyExistsException("esa extención ya está asignada.");

            }
            planilla.add(emp);



        }catch (DocumentAlreadyExistsException e){

            System.out.println(e.getMessage());

        }catch(ExtensionAlreadyExistsException e){

            System.out.println(e.getMessage());

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

    }
    public void quitEmpleado(String nombre){
        Empleado aux = null;

        for(Empleado Emp : planilla){
            if(Emp.getNombre().equals(nombre))
                aux = Emp;
        }

            planilla.remove(aux);



}

    public String consultarEmpleados(){
        String cadena = "";

        for(Empleado app : planilla){
            if(app instanceof PlazaFija){
                cadena += app.toString() + "\n";
            }else if(app instanceof ServicioProfesional){
                cadena += app.toString() + "\n";
            }

        }

        return cadena;
    }

    public Empleado buscarEmpleado(String nombre){

        Empleado aux = null;

        for(Empleado Emp : planilla){
            if(Emp.getNombre().equals(nombre))
                aux = Emp;
        }


           return aux;

    }



    }
