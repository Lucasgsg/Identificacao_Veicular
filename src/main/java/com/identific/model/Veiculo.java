package com.identific.model;

import javax.persistence.*;

@Entity
public class Veiculo {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String tipo_veiculo = "";

    private String marca = "";

    private String modelo = "";

    private String cor= "";
    
    private String placa="";

    private String estado_cid="";
    
    private String placa_cid = "";
    
    private String localidade;

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    @ManyToOne
    private Condutor condutor;

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }
    
       public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(String tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado_cid() {
        return estado_cid;
    }

    public void setEstado_cid(String estado_cid) {
        this.estado_cid = estado_cid;
    }
    
    public String getPlaca_cid() {
        return placa_cid;
    }

    public void setPlaca_cid(String placa_cid) {
        this.placa_cid = placa_cid;
    }
}
