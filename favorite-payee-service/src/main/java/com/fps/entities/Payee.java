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
@Table(name = "Payee")
@Setter
@Getter
@NoArgsConstructor
public class Payee implements Serializable {

    private static final long serialVersionUID = 8661482700975224893L;

    @Id
    @Column(name = "payee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger payeeId;

    @Column(name = "bank_code",length = 4,nullable = false)
    private String bank_code;

    @Column(name = "bank_name",length = 50,nullable = false)
    private String bankName;

    @Column(name = "iban",length = 20,nullable = false)
    private String iban;

    @Column(name = "payee_name",length = 50,nullable = false)
    private String payeeName;

    @Column(name = "cust_id",length = 20,nullable = false)
    private BigInteger custId;

    @JsonFormat(pattern = Constants.DATE_FORMAT_V1)
    @Column(name = "created_date", columnDefinition = Constants.TIMESTAMP_COLUMN_DEF)
    private Timestamp createdDate;

    @JsonFormat(pattern = Constants.DATE_FORMAT_V1)
    @Column(name = "LAST_MODIFIED_DT", columnDefinition = Constants.TIMESTAMP_COLUMN_DEF)
    private Timestamp lastModifiedDt;

}
