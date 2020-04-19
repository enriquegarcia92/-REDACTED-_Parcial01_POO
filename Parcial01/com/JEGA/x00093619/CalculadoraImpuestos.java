package com.JEGA.x00093619;

public final class CalculadoraImpuestos {
    private double totalRenta,totalISSS,totalAFP;

    public CalculadoraImpuestos() {
    }
    public double calcularPago(Empleado emp){
        double AFP ,ISSS,restante,Renta=0,PagoEmp=0;
        double salario = emp.getSalario();
        if(emp instanceof PlazaFija){

            AFP=0.0625*salario;
            ISSS=0.03*salario;
            restante=salario-AFP-ISSS;
            if(restante>=0.01 && restante <=472){
                Renta=0;
            }else if(restante>=472.01 && restante<=895.24){
                Renta=0.1*(restante-472)+17.67;
            }else if(restante>=895.25 && restante<=2038.10){
                Renta=0.2*(restante-895.24)+60;
            }else if(restante>=2038.11){
                Renta=0.3*(restante-2038.10)+288.57;
            }
            totalAFP+=AFP;
            totalISSS+=ISSS;
            totalRenta+=Renta;
            PagoEmp=restante-Renta;
        }else if(emp instanceof ServicioProfesional){
            Renta=salario*0.1;
            totalRenta+=Renta;
            PagoEmp=salario-Renta;
        }

        return PagoEmp;
    }
    public String mostrarTotales(){
        String cadena="Total de AFP descontado:"+totalAFP+"\nTotal de ISSS descontado:"+totalISSS+"\nTotal de Renta descontada: "+totalRenta;

        return cadena;
    }
}
