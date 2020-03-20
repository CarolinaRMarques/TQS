/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geocoding;

import java.util.Objects;

/**
 *
 * @author ico
 */
public class Address {

       private String road;

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    private String cirty;

    public String getCirty() {
        return cirty;
    }

    public void setCirty(String cirty) {
        this.cirty = cirty;
    }

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address(String road, String cirty, String state, String zio, String houseNumber) {
        this.road = road;
        this.cirty = cirty;
        this.state = state;
        this.zio = zio;
        this.houseNumber = houseNumber;
    }

    private String zio;

    public String getZio() {
        return zio;
    }

    public void setZio(String zio) {
        this.zio = zio;
    }

    private String houseNumber;

    /**
     * Get the value of houseNumber
     *
     * @return the value of houseNumber
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Set the value of houseNumber
     *
     * @param houseNumber new value of houseNumber
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Address{" + "road=" + road + ", cirty=" + cirty + ", state=" + state + ", zio=" + zio + ", houseNumber=" + houseNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.road, other.road)) {
            return false;
        }
        if (!Objects.equals(this.cirty, other.cirty)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.zio, other.zio)) {
            return false;
        }
        if (!Objects.equals(this.houseNumber, other.houseNumber)) {
            return false;
        }
        return true;
    }

    
    
}
