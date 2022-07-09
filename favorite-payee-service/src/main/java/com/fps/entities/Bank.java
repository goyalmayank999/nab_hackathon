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
@Table(name = "BANK")
@Setter
@Getter
@NoArgsConstructor
public class Bank implements Serializable {

    private static final long serialVersionUID = 8661482700975224893L;

    @Id
    @Column(name = "bank_code",length =  4)
    private String bankCode;

    @Column(name = "bank_name",length = 50,nullable = false)
    private String bankName;

    @JsonFormat(pattern = Constants.DATE_FORMAT_V1)
    @Column(name = "created_date", columnDefinition = Constants.TIMESTAMP_COLUMN_DEF)
    private Timestamp createdDate;

}
