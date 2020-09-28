/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author cda611
 
@Entity
@Table(name = "CARRIER")
@NamedQueries({
    @NamedQuery(name = "Carrier.findAll", query = "SELECT c FROM Carrier c"),
    @NamedQuery(name = "Carrier.findByCarrierId", query = "SELECT c FROM Carrier c WHERE c.carrierId = :carrierId"),
    @NamedQuery(name = "Carrier.findByCarrierCorporateName", query = "SELECT c FROM Carrier c WHERE c.carrierCorporateName = :carrierCorporateName"),
    @NamedQuery(name = "Carrier.findByCarrierEmail", query = "SELECT c FROM Carrier c WHERE c.carrierEmail = :carrierEmail")})
*/

public class Carrier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CARRIER_ID")
    private Long carrierId;
    @Basic(optional = false)
    @Column(name = "CARRIER_CORPORATE_NAME")
    private String carrierCorporateName;
    @Basic(optional = false)
    @Column(name = "CARRIER_EMAIL")
    private String carrierEmail;
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @ManyToOne(optional = false)
    private Address addressId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carrierId")
    private Collection<ShippingOffer> shippingOfferCollection;

    public Carrier() {
    }

    public Carrier(Long carrierId) {
        this.carrierId = carrierId;
    }

    public Carrier(Long carrierId, String carrierCorporateName, String carrierEmail) {
        this.carrierId = carrierId;
        this.carrierCorporateName = carrierCorporateName;
        this.carrierEmail = carrierEmail;
    }

    public Long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    public String getCarrierCorporateName() {
        return carrierCorporateName;
    }

    public void setCarrierCorporateName(String carrierCorporateName) {
        this.carrierCorporateName = carrierCorporateName;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Collection<ShippingOffer> getShippingOfferCollection() {
        return shippingOfferCollection;
    }

    public void setShippingOfferCollection(Collection<ShippingOffer> shippingOfferCollection) {
        this.shippingOfferCollection = shippingOfferCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (carrierId != null ? carrierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrier)) {
            return false;
        }
        Carrier other = (Carrier) object;
        if ((this.carrierId == null && other.carrierId != null) || (this.carrierId != null && !this.carrierId.equals(other.carrierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "librairie.Carrier[ carrierId=" + carrierId + " ]";
    }
    
}
