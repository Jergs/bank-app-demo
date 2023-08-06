package com.havryliuk.yehor.bank.app.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer balanceId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number")
    @Exclude
    private Account account;
    @Column(insertable = false, updatable = false, name = "account_number")
    private Integer accountNumber;
    private Integer amount;
    private LocalDate updatedAt;

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }

}
