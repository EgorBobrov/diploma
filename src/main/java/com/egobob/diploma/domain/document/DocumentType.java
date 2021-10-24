package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentType extends AbstractDomainClass {

    private String name;
    private String description;
    @OneToMany(mappedBy = "type")
    private Collection<Document> documents;

}
