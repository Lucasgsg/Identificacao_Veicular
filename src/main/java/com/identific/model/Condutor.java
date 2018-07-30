package com.identific.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Condutor implements Serializable {

    private static final long serialVersionUID = 1L;

    // Chave Primaria
    @Id
    private Long cnh;

    private String venc_cnh = "";

    private String categ_cnh = "";

    private String tipo_user = "";

    private String nome = "";

    private Long matricula;

    private String email = "";

    private String tel = "";

    private String ramal = "";

    @OneToMany
    private List<Veiculo> veiculos;

    public Long getCnh() {
        return cnh;
    }

    public void setCnh(Long cnh) {
        this.cnh = cnh;
    }

    public String getVenc_cnh() {
        return venc_cnh;
    }

    public void setVenc_cnh(String venc_cnh) {
        this.venc_cnh = venc_cnh;
    }

    public String getCateg_cnh() {
        return categ_cnh;
    }

    public void setCateg_cnh(String categ_cnh) {
        this.categ_cnh = categ_cnh;
    }

    public String getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(String tipo_user) {
        this.tipo_user = tipo_user;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cr_id", referencedColumnName = "id")
    private Cr cr;

    public Cr getCr() {
        return cr;
    }

    public void setCr(Cr cr) {
        this.cr = cr;
    }

}
