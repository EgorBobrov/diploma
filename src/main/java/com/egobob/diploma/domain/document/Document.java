package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Document extends AbstractDomainClass {

    @NotNull
    private String title;
    @NotNull
    private DocumentStatus documentStatus;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private DocumentType type;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
    @Column(columnDefinition = "text")
    private String description;

    @OneToMany(mappedBy = "document")
    private Collection<DocumentNote> notes;

    private File file;

}
