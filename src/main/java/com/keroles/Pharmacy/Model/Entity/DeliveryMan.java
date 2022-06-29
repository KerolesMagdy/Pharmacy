package com.keroles.Pharmacy.Model.Entity;
// Generated Oct 22, 2021, 2:07:56 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static com.keroles.Pharmacy.Constant.ConstantDbProperties.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * DeliveryMan generated by hbm2java
 */
@Entity
@Table(name="delivery_man"
    ,catalog="pharmacy"
)
public class DeliveryMan  implements java.io.Serializable {


     private Integer deliveryManId;
     private String deliveryManName;
     private long deliveryManPhone;
     private double deliveryManLat;
     private double deliveryManLong;
     private Long deliveryManNationalId;
     private float deliveryManTotalRate;
     private int deliveryManRateCount;
    private Address address;
     private Set<Order> orders = new HashSet(0);

    public DeliveryMan() {
    }

	
    public DeliveryMan(Address address,String deliveryManName, long deliveryManPhone, double deliveryManLat, double deliveryManLong, long deliveryManNationalId, float deliveryManTotalRate, int deliveryManRateCount) {
        this.address = address;
        this.deliveryManName = deliveryManName;
        this.deliveryManPhone = deliveryManPhone;
        this.deliveryManLat = deliveryManLat;
        this.deliveryManLong = deliveryManLong;
        this.deliveryManNationalId = deliveryManNationalId;
        this.deliveryManTotalRate = deliveryManTotalRate;
        this.deliveryManRateCount = deliveryManRateCount;
    }
    public DeliveryMan(Address address,String deliveryManName, long deliveryManPhone, double deliveryManLat, double deliveryManLong, long deliveryManNationalId, float deliveryManTotalRate, int deliveryManRateCount, Set<Order> orders) {
        this.address = address;
       this.deliveryManName = deliveryManName;
       this.deliveryManPhone = deliveryManPhone;
       this.deliveryManLat = deliveryManLat;
       this.deliveryManLong = deliveryManLong;
       this.deliveryManNationalId = deliveryManNationalId;
       this.deliveryManTotalRate = deliveryManTotalRate;
       this.deliveryManRateCount = deliveryManRateCount;
       this.orders = orders;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name=table_delivery_man_attribute_delivery_man_id, unique=true, nullable=false)
    public Integer getDeliveryManId() {
        return this.deliveryManId;
    }
    
    public void setDeliveryManId(Integer deliveryManId) {
        this.deliveryManId = deliveryManId;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_name, nullable=false, length=100)
    public String getDeliveryManName() {
        return this.deliveryManName;
    }
    
    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_phone, nullable=false)
    public long getDeliveryManPhone() {
        return this.deliveryManPhone;
    }
    
    public void setDeliveryManPhone(long deliveryManPhone) {
        this.deliveryManPhone = deliveryManPhone;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_lat, nullable=false, precision=22, scale=0)
    public double getDeliveryManLat() {
        return this.deliveryManLat;
    }
    
    public void setDeliveryManLat(double deliveryManLat) {
        this.deliveryManLat = deliveryManLat;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_long, nullable=false, precision=22, scale=0)
    public double getDeliveryManLong() {
        return this.deliveryManLong;
    }
    
    public void setDeliveryManLong(double deliveryManLong) {
        this.deliveryManLong = deliveryManLong;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_national_id, nullable=false)
    public long getDeliveryManNationalId() {
        return this.deliveryManNationalId;
    }
    
    public void setDeliveryManNationalId(long deliveryManNationalId) {
        this.deliveryManNationalId = deliveryManNationalId;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_total_rate, nullable=false, precision=12, scale=0)
    public float getDeliveryManTotalRate() {
        return this.deliveryManTotalRate;
    }
    
    public void setDeliveryManTotalRate(float deliveryManTotalRate) {
        this.deliveryManTotalRate = deliveryManTotalRate;
    }

    
    @Column(name=table_delivery_man_attribute_delivery_man_rate_count, nullable=false)
    public int getDeliveryManRateCount() {
        return this.deliveryManRateCount;
    }
    
    public void setDeliveryManRateCount(int deliveryManRateCount) {
        this.deliveryManRateCount = deliveryManRateCount;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonBackReference(value = "deliveryMan-address")
    @JoinColumn(name=table_delivery_man_attribute_delivery_man_address_id, nullable=false)
    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @OneToMany(fetch=FetchType.LAZY, mappedBy="deliveryMan")
@JsonManagedReference(value = "order-deliveryman")

    public Set<Order> getOrders() {
        return this.orders;
    }
    
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


    public void Transfer(DeliveryMan deliveryMan){
        this.deliveryManId=deliveryMan.getDeliveryManId()!=null?deliveryMan.getDeliveryManId():null;
        this.deliveryManName=deliveryMan.getDeliveryManName()!=null?deliveryMan.getDeliveryManName():null;
        this.deliveryManPhone=deliveryMan.getDeliveryManPhone();
        this.deliveryManLat=deliveryMan.getDeliveryManLat();
        this.deliveryManLong=deliveryMan.getDeliveryManLong();
        this.deliveryManNationalId=deliveryMan.getDeliveryManNationalId();
        this.deliveryManTotalRate=deliveryMan.getDeliveryManTotalRate();
        this.deliveryManRateCount=deliveryMan.getDeliveryManRateCount();
        this.address=deliveryMan.getAddress()!=null?deliveryMan.getAddress():null;

    }




}


