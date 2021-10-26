package com.egobob.diploma.domain.document;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DocumentNote extends AbstractDomainClass {

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User noteAuthor;

    @NotNull
    @Column(columnDefinition = "text")
    private String text;

    @NotNull
    private String author;
}
