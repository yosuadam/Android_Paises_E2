package com.example.yosua.yosuamartinezexamen2;

/**
 * Created by Yosua on 21/02/2018.
 */

class DatosPais {

    private String nombreEN;
    private String nombreES;
    private String clave;
    private String capital;
    private String continente;
    private String poblacion;
    private String latitud;
    private String longitud;
    private String paisesFronterizos;

    public DatosPais(String nombreEN, String nombreES, String clave, String capital, String continente, String poblacion, String latitud, String longitud, String paisesFronterizos) {
        this.nombreEN = nombreEN;
        this.nombreES = nombreES;
        this.clave = clave;
        this.capital = capital;
        this.continente = continente;
        this.poblacion = poblacion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.paisesFronterizos = paisesFronterizos;
    }

    public String getNombreEN() {
        return nombreEN;
    }

    public void setNombreEN(String nombreEN) {
        this.nombreEN = nombreEN;
    }

    public String getNombreES() {
        return nombreES;
    }

    public void setNombreES(String nombreES) {
        this.nombreES = nombreES;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getPaisesFronterizos() {
        return paisesFronterizos;
    }

    public void setPaisesFronterizos(String paisesFronterizos) {
        this.paisesFronterizos = paisesFronterizos;
    }
}
