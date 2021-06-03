/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.Objects;

/**
 *
 * @author Snowyy
 */
public class OrderDetail {

    private int id;
    private int oid;
    private int pid;
    private String pname;
    private String dongia;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int id, int oid, int pid, String pname, String dongia, int quantity) {
        this.id = id;
        this.oid = oid;
        this.pid = pid;
        this.pname = pname;
        this.dongia = dongia;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDongia() {
        if(dongia == null){
            dongia = "0";
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(Double.parseDouble(dongia))+" VNĐ";
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "id=" + id + ", oid=" + oid + ", pid=" + pid + ", pname=" + pname + ", dongia=" + dongia + ", quantity=" + quantity + '}';
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
        final OrderDetail other = (OrderDetail) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.oid != other.oid) {
            return false;
        }
        if (this.pid != other.pid) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.pname, other.pname)) {
            return false;
        }
        if (!Objects.equals(this.dongia, other.dongia)) {
            return false;
        }
        return true;
    }

}
