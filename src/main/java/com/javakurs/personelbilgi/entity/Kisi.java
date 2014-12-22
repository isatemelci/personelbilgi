/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javakurs.personelbilgi.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dream
 */
@Entity
@Table(catalog = "personelbilgi", name = "kisi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kisi.findAll", query = "SELECT k FROM Kisi k"),
    @NamedQuery(name = "Kisi.findById", query = "SELECT k FROM Kisi k WHERE k.id = :id"),
    @NamedQuery(name = "Kisi.findByAd", query = "SELECT k FROM Kisi k WHERE k.ad = :ad"),
    @NamedQuery(name = "Kisi.findBySoyad", query = "SELECT k FROM Kisi k WHERE k.soyad = :soyad")})
public class Kisi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String ad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(nullable = false, length = 20)
    private String soyad;
    @OneToMany(mappedBy = "kisi", cascade = CascadeType.ALL)
    private List<Telefon> telefonList;

    public Kisi() {
    }

    public Kisi(Integer id) {
        this.id = id;
    }

    public Kisi(Integer id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }

//    @PrePersist
//    public void prePersistKisi() {
//        
//        for (Telefon telefon : telefonList) {
//            telefon.setKisi(this);
//        }
//    }
//    
//    @PreUpdate
//    public void preUpdateKisi() {
//        
//        for (Telefon telefon : telefonList) {
//            telefon.setKisi(this);
//        }
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    @XmlTransient
    public List<Telefon> getTelefonList() {
        return telefonList;
    }

    public void setTelefonList(List<Telefon> telefonList) {
        this.telefonList = telefonList;
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
        if (!(object instanceof Kisi)) {
            return false;
        }
        Kisi other = (Kisi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.javakurs.personelbilgi.entity.Kisi[ id=" + id + " ]";
    }

}
