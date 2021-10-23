package com.egobob.diploma.domain.client;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
public class Client extends AbstractDomainClass {

    private String clientName;
    private String clientWebsiteUrl;
    private String clientDescription;

    @OneToMany(mappedBy = "client")
    private Collection<Project> projects;
    // TODO: maybe add client company logo or something

}
