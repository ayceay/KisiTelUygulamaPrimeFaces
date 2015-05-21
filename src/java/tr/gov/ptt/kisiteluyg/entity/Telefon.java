/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.kisiteluyg.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TELEFON")
@NamedQueries({
    @NamedQuery(name = "Telefon.findAll", query = "SELECT t FROM Telefon t"),
    @NamedQuery(name = "Telefon.findByNo", query = "SELECT t FROM Telefon t WHERE t.no = :no"),
    @NamedQuery(name = "Telefon.findByTur", query = "SELECT t FROM Telefon t WHERE t.tur = :tur"),
    @NamedQuery(name = "Telefon.findByNumara", query = "SELECT t FROM Telefon t WHERE t.numara = :numara")})
public class Telefon implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NO")
    private BigDecimal no;
    @Size(max = 5)
    @Column(name = "TUR")
    private String tur;
    @Size(max = 20)
    @Column(name = "NUMARA")
    private String numara;
    @JoinColumn(name = "KISINO", referencedColumnName = "NO")
    @ManyToOne
    private Kisi kisino;

    public Telefon() {
    }

    public Telefon(BigDecimal no) {
        this.no = no;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public Kisi getKisino() {
        return kisino;
    }

    public void setKisino(Kisi kisino) {
        this.kisino = kisino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (no != null ? no.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefon)) {
            return false;
        }
        Telefon other = (Telefon) object;
        if ((this.no == null && other.no != null) || (this.no != null && !this.no.equals(other.no))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tr.gov.ptt.kisiteluyg.entity.Telefon[ no=" + no + " ]";
    }
    
}
