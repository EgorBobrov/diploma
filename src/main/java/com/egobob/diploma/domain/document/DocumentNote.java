package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentNote extends AbstractDomainClass {

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    private String text;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;
}
