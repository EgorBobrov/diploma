package com.egobob.diploma.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AbstractDomainClass implements DomainObject {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Version
    private Long version;

    private Date dateCreated;

    private Date lastUpdated;

    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        lastUpdated = new Date();
        if (dateCreated == null) {
            dateCreated = new Date();
        }
    }
}
