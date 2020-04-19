package com.JEGA.x00093619;

import sun.util.calendar.CalendarUtils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String nombreE, puesto;
        double salario;

        System.out.println("ingrese los datos que se piden a continuación: ");

        System.out.println("Nombre Empresa: ");

        nombreE = in.nextLine();

        Empresa empresa = new Empresa(nombreE);
        CalculadoraImpuestos calcuIMP= new CalculadoraImpuestos();
        byte op;
        boolean error = false;

        do {

            error = false;

            try {

                do {

                    System.out.println("Ingrese una opcion\n1.añadir empleado\n2.Despedir Empleado\n3.Ver Empleado\n4.Calcular Sueldo\n5.Mostrar Totales\n0.Salir");
                    op = in.nextByte();
                    in.nextLine();
                    switch (op) {
                        case 1:
                            añadirEmpleado(empresa);
                            break;
                        case 2:
                            System.out.println("Ingrese el nombre del empleado que quiere despedir");
                            String nombre = in.nextLine();
                            String finalname;
                            finalname = nombre;
                            empresa.quitEmpleado(finalname);
                            break;
                        case 3:
                            System.out.println(empresa.consultarEmpleados());

                            break;
                        case 4:
                            try{
                                System.out.println("Ingrese el nombre del empleado al que le va a pagar");
                                String nomcal;
                                nomcal=in.nextLine();

                                Empleado empleado;
                                empleado=empresa.buscarEmpleado(nomcal);
                                if(empleado==null){
                                    throw new EmployeNotFoundExeption("Empleado no encontrado");
                                }
                                System.out.println(calcuIMP.calcularPago(empleado));
                            }catch(EmployeNotFoundExeption e){
                                System.out.println(e.getMessage());
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }


                            break;
                        case 5:
                            System.out.println(calcuIMP.mostrarTotales());
                            break;
                        case 0:
                            System.out.println("Saliendo...");
                            break;
                    }
                } while (op != 0);

                break;

            }catch (InputMismatchException e){

                System.out.println("debe utilizar valores numericos entre 0 y 5 para su eleccion.");
                in.nextLine();
                error=true;

            }


        }while(error);
    }

    public static void añadirEmpleado(Empresa emp) {
        String nombre = "", puesto = "";
        double salario = 0;
        int mesesContrato = 0, extension = 0;

        int opc1,opc2=0;

        System.out.println("para ingresar un empleado por contrato presione 1, para plaza fija presione 2");

        opc1 = in.nextByte();
        in.nextLine();

        if (opc1 == 1) {

            System.out.println("ingrese el nombre del empleado: ");

            nombre = in.nextLine();

            System.out.println("ingrese el puesto del empleado: ");

            puesto = in.nextLine();
            boolean error=false;
            do {
                error = false;

                try {


                    System.out.println("ingrese el salario del empleado: ");

                    salario = in.nextDouble();
                    in.nextLine();

                } catch (InputMismatchException e) {

                    System.out.println("solo se admiten valores numericos, por favor ingrese uno.");
                    error = true;
                    in.nextLine();

                }
            }while(error);

            System.out.println("ingrese los meses del contrato: ");

            mesesContrato = in.nextInt();
            in.nextLine();
            Empleado ex = new ServicioProfesional(nombre, puesto, salario, mesesContrato);
            emp.addEmpleado(ex);
            System.out.println("Debe añadir un documento:");
            añadirDocumento(ex);
            do{
                System.out.println("Desea añadir otro documento?\n1.Añadir\n0.terminar");
                opc2=in.nextInt();in.nextLine();
                if(opc2==1){
                    añadirDocumento(ex);
                }
            }while(opc2!=0);


        } else if (opc1 == 2) {

            System.out.println("ingrese el nombre del empleado: ");

            nombre = in.nextLine();

            System.out.println("ingrese el puesto del empleado: ");

            puesto = in.nextLine();

            System.out.println("ingrese el salario del empleado: ");

            salario = in.nextDouble();in.nextLine();

            System.out.println("ingrese la extensión:");

            extension=in.nextInt(); in.nextLine();
            Empleado ex2 = new PlazaFija(nombre, puesto, salario, extension);
            emp.addEmpleado(ex2);
            System.out.println("Debe añadir un documento:");
            añadirDocumento(ex2);
            do{
                System.out.println("Desea añadir otro documento?\n1.Añadir\n0.terminar");
                opc2=in.nextInt();in.nextLine();
                if(opc2==1){
                    añadirDocumento(ex2);
                }

            }while(opc2!=0);

        }



    }

    public static void añadirDocumento(Empleado ex){

        String nombreD;
        String numero;

        System.out.println("ingrese el nombre del documento: ");

        nombreD= in.nextLine();

        System.out.println("ingrese el numero del documento: ");

        numero= in.nextLine();

        Documento dx =new Documento(nombreD,numero);

        ex.addDocumentos(dx);


    }
    
}








