package com.lvan.jpademo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * @author Lvan
 * @since 2021/10/24
 */
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role2 implements Auditable<Integer, Integer, LocalDateTime> {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(length = 16)
    private String name;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer createBy;
    private Integer updateBy;

    @Override
    public Optional<Integer> getCreatedBy() {
        return Optional.of(this.createBy);
    }

    @Override
    public void setCreatedBy(Integer createdBy) {
        this.createBy = createdBy;
    }

    @Override
    public Optional<LocalDateTime> getCreatedDate() {
        return Optional.of(this.createTime);
    }

    @Override
    public void setCreatedDate(LocalDateTime creationDate) {
        this.createTime = creationDate;
    }

    @Override
    public Optional<Integer> getLastModifiedBy() {
        return Optional.of(this.updateBy);
    }

    @Override
    public void setLastModifiedBy(Integer lastModifiedBy) {
        this.updateBy = lastModifiedBy;
    }

    @Override
    public Optional<LocalDateTime> getLastModifiedDate() {
        return Optional.of(this.updateTime);
    }

    @Override
    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.updateTime = lastModifiedDate;
    }

    @Override
    public boolean isNew() {
        return id == null;
    }
}
