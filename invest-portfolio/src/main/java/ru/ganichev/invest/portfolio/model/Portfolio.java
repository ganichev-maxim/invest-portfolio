package ru.ganichev.invest.portfolio.model;




import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import static ru.ganichev.invest.portfolio.model.AbstractBaseEntity.START_SEQ;

@Entity
@Table(name = "portfolio", uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "user_id"}, name = "portfolio_name_idx")})
@SequenceGenerator(name = "default_gen", sequenceName = "portfolio_seq", allocationSize = 1, initialValue = START_SEQ)
public class Portfolio extends AbstractBaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(max = 200)
    private String name;

    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private User user;

    public Portfolio(@NotNull String name, @NotNull User user) {
        this.name = name;
        this.user = user;
    }

    protected Portfolio() {
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public User getUser() {
        return user;
    }
}
