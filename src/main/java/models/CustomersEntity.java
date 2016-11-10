package models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Alexandr on 01.11.2016.
 */
@Entity
@Table(name = "customers", schema = "training_db", catalog = "")
public class CustomersEntity {
    private int custNum;
    private String company;
    private BigDecimal creditLimit;
    private SalesrepsEntity salesrepsByCustRep;
    private Collection<OrdersEntity> ordersesByCustNum;

    @Id
    @Column(name = "CUST_NUM")
    public int getCustNum() {
        return custNum;
    }

    public void setCustNum(int custNum) {
        this.custNum = custNum;
    }

    @Basic
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "CREDIT_LIMIT")
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomersEntity that = (CustomersEntity) o;

        if (custNum != that.custNum) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (creditLimit != null ? !creditLimit.equals(that.creditLimit) : that.creditLimit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = custNum;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (creditLimit != null ? creditLimit.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CUST_REP", referencedColumnName = "EMPL_NUM")
    public SalesrepsEntity getSalesrepsByCustRep() {
        return salesrepsByCustRep;
    }

    public void setSalesrepsByCustRep(SalesrepsEntity salesrepsByCustRep) {
        this.salesrepsByCustRep = salesrepsByCustRep;
    }

    @OneToMany(mappedBy = "customersByCust", fetch = FetchType.EAGER)
    public Collection<OrdersEntity> getOrdersesByCustNum() {
        return ordersesByCustNum;
    }

    public void setOrdersesByCustNum(Collection<OrdersEntity> ordersesByCustNum) {
        this.ordersesByCustNum = ordersesByCustNum;
    }

    @Override
    public String toString() {
        return "CustomersEntity{" +
                "company='" + company + '\'' +
                ", creditLimit=" + creditLimit +
                ", ordersesByCustNum=" + ordersesByCustNum +
                '}';
    }
}
