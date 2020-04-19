package com.JEGA.x00093619;

import java.util.ArrayList;

public abstract class Empleado {
    protected String nombre,puesto;
    protected ArrayList<com.JEGA.x00093619.Documento> documentos;
    protected double salario;

    public Empleado(String nombre, String puesto, double salario) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<com.JEGA.x00093619.Documento> getListaDoc() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }

    public void addDocumentos(com.JEGA.x00093619.Documento doc) {

        try{

            boolean exists=false;

            for (Documento d : documentos) {

                if (d.getNumero().equals(doc.getNumero())) {

                    exists = true;

                }
            }

                if(exists){

                    throw new DocumentAlreadyExistsException("ya existe ese numero de documento en el sistema");

                }
                documentos.add(doc);


        }catch (DocumentAlreadyExistsException e){

            System.out.println(e.getMessage());

        }catch (Exception e){

            System.out.println(e.getMessage());

        }

    }
    public void removeDocumento(){

        documentos.removeAll(documentos);
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }



}
