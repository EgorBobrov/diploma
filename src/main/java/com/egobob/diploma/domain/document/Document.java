package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Document extends AbstractDomainClass {

    private String title;
    private DocumentStatus documentStatus;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType type;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    private String description;

    @OneToMany(mappedBy = "document")
    private Collection<DocumentNote> notes;

    // TODO: add file attachment

}
