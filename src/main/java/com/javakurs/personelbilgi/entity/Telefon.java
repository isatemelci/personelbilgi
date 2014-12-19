/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dream
 */
@Entity
@Table(catalog = "personelbilgi", name = "telefon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefon.findAll", query = "SELECT t FROM Telefon t"),
    @NamedQuery(name = "Telefon.findById", query = "SELECT t FROM Telefon t WHERE t.id = :id"),
    @NamedQuery(name = "Telefon.findByTelNo", query = "SELECT t FROM Telefon t WHERE t.telNo = :telNo")})
public class Telefon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 20)
    @Column(name = "tel_no", length = 20)
    private String telNo;
    @JoinColumn(name = "kisi_id", referencedColumnName = "id")
    @ManyToOne
    private Kisi kisi;

    public Telefon() {
    }

    public Telefon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefon)) {
            return false;
        }
        Telefon other = (Telefon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javakurs.personelbilgi.entity.Telefon[ id=" + id + " ]";
    }

}
