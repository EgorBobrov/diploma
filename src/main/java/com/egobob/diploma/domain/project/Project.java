package com.egobob.diploma.domain.project;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.client.Client;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Project extends AbstractDomainClass {

    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    private ProjectStatus projectStatus;

}
