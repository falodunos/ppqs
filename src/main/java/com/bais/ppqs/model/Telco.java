package com.bais.ppqs.model;

import com.bais.ppqs.model.audit.DateAudit;
import com.bais.ppqs.model.enums.telco.RuntimeEnv;
import com.bais.ppqs.model.enums.constraints.TelcoRuntimeEnvSubset;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "telco_tb", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"alias"})
})
@EntityListeners(AuditingEntityListener.class)
public class Telco extends DateAudit {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Please provide name")
    @Column(name = "alias", nullable = false)
    private String name;

    @NotEmpty(message = "Please provide alias")
    @Column(name = "alias", nullable = false)
    private String alias;

    @NotEmpty(message = "Please provide a support email address")
    @Column(name = "supportEmail", nullable = false)
    private String supportEmail;

    @NotEmpty(message = "Please provide credential value")
    @Column(name = "credential", columnDefinition = "varchar(1000)", nullable = false)
    private String credential;

//    @Column(name = "state", columnDefinition = "varchar(10) default 'ACTIVE'", nullable = false)
//    @TelcoStateSubset(anyOf = { TState.ACTIVE, TState.INACTIVE })
//    @NotNull
//    private TState state;

    @Column(name = "environment", columnDefinition = "varchar(10) default 'DEV'", nullable = false)
    @TelcoRuntimeEnvSubset(anyOf = { RuntimeEnv.LIVE, RuntimeEnv.DEV })
    @NotNull
    private RuntimeEnv runtimeEnv;

}
