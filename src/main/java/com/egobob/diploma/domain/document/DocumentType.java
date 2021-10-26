package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentType extends AbstractDomainClass {

    @NotNull
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @OneToMany(mappedBy = "type")
    private Collection<Document> documents;

}
