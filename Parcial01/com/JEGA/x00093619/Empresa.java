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
    planilla.add(emp);
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
