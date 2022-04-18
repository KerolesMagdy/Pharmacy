package com.keroles.Pharmacy.Model.Entity;
// Generated Oct 22, 2021, 2:07:56 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Logs generated by hbm2java
 */
@Entity
@Table(name="logs"
    ,catalog="pharmacy"
    , uniqueConstraints = @UniqueConstraint(columnNames="USER_ID") 
)
public class Logs  implements java.io.Serializable {


     private Integer logsId;
     private Users users;
     private String action;
     private Date logTimestamp;

    public Logs() {
    }

    public Logs(Users users, String action, Date logTimestamp) {
       this.users = users;
       this.action = action;
       this.logTimestamp = logTimestamp;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="LOGS_ID", unique=true, nullable=false)
    public Integer getLogsId() {
        return this.logsId;
    }
    
    public void setLogsId(Integer logsId) {
        this.logsId = logsId;
    }

@ManyToOne(fetch=FetchType.LAZY)
 @JsonBackReference(value = "user-log")
   @JoinColumn(name="USER_ID", unique=true, nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }

    
    @Column(name="ACTION", nullable=false, length=65535)
    public String getAction() {
        return this.action;
    }
    
    public void setAction(String action) {
        this.action = action;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LOG_TIMESTAMP", nullable=false, length=19)
    public Date getLogTimestamp() {
        return this.logTimestamp;
    }
    
    public void setLogTimestamp(Date logTimestamp) {
        this.logTimestamp = logTimestamp;
    }




}

