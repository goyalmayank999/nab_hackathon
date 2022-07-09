package com.fps.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fps.constants.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;


@Entity
@Table(name = "CUSTOMER")
@Setter
@Getter
@NoArgsConstructor
public class Customer implements Serializable {

    private static final long serialVersionUID = 8661482700975224893L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cust_id")
    private BigInteger custId;

    @Column(name = "cust_name",length = 50,nullable = false)
    private String custName;

    @JsonFormat(pattern = Constants.DATE_FORMAT_V1)
    @Column(name = "created_date", columnDefinition = Constants.TIMESTAMP_COLUMN_DEF)
    private Timestamp createdDate;

}
