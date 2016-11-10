package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Alexandr on 01.11.2016.
 */
@Entity
@Table(name = "orders", schema = "training_db", catalog = "")
public class OrdersEntity {
    private int orderNum;
    private Date orderDate;
    private int qty;
    private BigDecimal amount;
    private CustomersEntity customersByCust;
    private SalesrepsEntity salesrepsByRep;

    @Id
    @Column(name = "ORDER_NUM")
    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Basic
    @Column(name = "ORDER_DATE")
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "QTY")
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Basic
    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (orderNum != that.orderNum) return false;
        if (qty != that.qty) return false;
        if (orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNum;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + qty;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CUST", referencedColumnName = "CUST_NUM", nullable = false)
    public CustomersEntity getCustomersByCust() {
        return customersByCust;
    }

    public void setCustomersByCust(CustomersEntity customersByCust) {
        this.customersByCust = customersByCust;
    }

    @ManyToOne
    @JoinColumn(name = "REP", referencedColumnName = "EMPL_NUM")
    public SalesrepsEntity getSalesrepsByRep() {
        return salesrepsByRep;
    }

    public void setSalesrepsByRep(SalesrepsEntity salesrepsByRep) {
        this.salesrepsByRep = salesrepsByRep;
    }

    @Override
    public String toString() {
        return "OrdersEntity{" +
                "orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }
}
