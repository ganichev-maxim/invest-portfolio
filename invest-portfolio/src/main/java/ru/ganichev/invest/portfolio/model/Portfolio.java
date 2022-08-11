package ru.ganichev.invest.portfolio.model;

import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

import static ru.ganichev.invest.portfolio.model.AbstractBaseEntity.START_SEQ;

@Entity
@Table(name = "portfolio", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"}, name = "users_name_idx")})
@SequenceGenerator(name = "default_gen", sequenceName = "portfolio_seq", allocationSize = 1, initialValue = START_SEQ)
@Access(AccessType.FIELD)
public class Portfolio extends AbstractBaseEntity{

    @NotNull
    private String name;

    @CreationTimestamp
    private LocalDateTime created;

    public Portfolio(@NotNull String name) {
        this.name = name;
    }

    protected Portfolio() {
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
