package fr.dauphine.miageif.msa.exchange_rate_operator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ExchangeOperationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    private String dest;
    private double montant;
    @Basic
    @Temporal(TemporalType.DATE)
    private Date date;
    private double taux;

    public ExchangeOperationEntity() {
        super();
    }

    public ExchangeOperationEntity(String source, String dest, double montant, Date date, double taux) {
        super();
        this.source = source;
        this.dest = dest;
        this.montant = montant;
        this.date = date;
        this.taux = taux;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

}
