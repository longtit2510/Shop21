/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Snowyy
 */
public class Order {

    private String id;
    private String id_customer;
    private String totalprice;
    private String startDate;
    private String status;

    public Order() {
    }

    public Order(String id, String id_customer, String totalprice, String startDate, String status) {
        this.id = id;
        this.id_customer = id_customer;
        this.totalprice = totalprice;
        this.startDate = startDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_customer() {
        return id_customer;
    }

    public void setId_customer(String id_customer) {
        this.id_customer = id_customer;
    }

    public String getTotalprice() {
        if(totalprice == null){
            totalprice = "0";
        }
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        return formatter.format(Double.parseDouble(totalprice))+" VNĐ";
    }

    public void setTotalprice(String totalprice) {
        this.totalprice = totalprice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", id_customer=" + id_customer + ", totalprice=" + totalprice + ", startDate=" + startDate + ", status=" + status + '}';
    }

}
