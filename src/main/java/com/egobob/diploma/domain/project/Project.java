package com.egobob.diploma.domain.project;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.client.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project extends AbstractDomainClass {

    @NotNull
    private String name;
    @Column(columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private ProjectStatus projectStatus;

}
