package org.demo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Alexandr on 01.11.2016.
 */
@Entity
@Table(name = "salesreps", schema = "training_db", catalog = "")
public class SalesrepsEntity {
    private int emplNum;
    private String name;
    private Integer age;
    private String title;
    private Date hireDate;
    private BigDecimal quota;
    private BigDecimal sales;
    private Collection<CustomersEntity> customersesByEmplNum;
    private OfficesEntity officesByRepOffice;

    @Id
    @Column(name = "EMPL_NUM")
    public int getEmplNum() {
        return emplNum;
    }

    public void setEmplNum(int emplNum) {
        this.emplNum = emplNum;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "AGE")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "HIRE_DATE")
    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Basic
    @Column(name = "QUOTA")
    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    @Basic
    @Column(name = "SALES")
    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesrepsEntity that = (SalesrepsEntity) o;

        if (emplNum != that.emplNum) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (hireDate != null ? !hireDate.equals(that.hireDate) : that.hireDate != null) return false;
        if (quota != null ? !quota.equals(that.quota) : that.quota != null) return false;
        if (sales != null ? !sales.equals(that.sales) : that.sales != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emplNum;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        result = 31 * result + (quota != null ? quota.hashCode() : 0);
        result = 31 * result + (sales != null ? sales.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "salesrepsByCustRep", fetch = FetchType.EAGER)
    public Collection<CustomersEntity> getCustomersesByEmplNum() {
        return customersesByEmplNum;
    }

    public void setCustomersesByEmplNum(Collection<CustomersEntity> customersesByEmplNum) {
        this.customersesByEmplNum = customersesByEmplNum;
    }

    @ManyToOne
    @JoinColumn(name = "REP_OFFICE", referencedColumnName = "OFFICE")
    public OfficesEntity getOfficesByRepOffice() {
        return officesByRepOffice;
    }

    public void setOfficesByRepOffice(OfficesEntity officesByRepOffice) {
        this.officesByRepOffice = officesByRepOffice;
    }

    @Override
    public String toString() {
        return "SalesrepsEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", title='" + title + '\'' +
                ", hireDate=" + hireDate +
                ", quota=" + quota +
                ", sales=" + sales +
                '}';
    }
}
