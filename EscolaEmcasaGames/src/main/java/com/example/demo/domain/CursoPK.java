package com.example.demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable

public class CursoPK implements Serializable {
    @ApiModelProperty(hidden = true)
    private int idLMS;
    @ApiModelProperty(hidden = true)
    private int idCurso;

    public CursoPK(){

    }

    public  CursoPK(int idCurso, int idLMS){
        this.idCurso = idCurso;
        this.idLMS = idLMS;
    }

    public void setIdLMS(int idLMS) {
        this.idLMS = idLMS;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdLMS() {
        return idLMS;
    }

    @Override
    public String toString() {
        return "CursoPK{" +
                "idLMS=" + idLMS +
                ", idCurso=" + idCurso +
                '}';
    }
}
