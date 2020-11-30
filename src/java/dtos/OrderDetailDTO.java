package dtos;

import java.sql.Timestamp;

public class OrderDetailDTO {
    private int orderDetailID, orderID, cakeID;
    private Timestamp createDate;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int orderDetailID, int orderID, int cakeID, Timestamp createDate) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.cakeID = cakeID;
        this.createDate = createDate;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(int orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCakeID() {
        return cakeID;
    }

    public void setCakeID(int cakeID) {
        this.cakeID = cakeID;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
}
