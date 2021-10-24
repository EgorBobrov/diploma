package com.egobob.diploma.domain.user;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.document.DocumentNote;
import com.egobob.diploma.domain.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends AbstractDomainClass {

    private String username;

    private String name;

    private String password;
    @Transient
    private String confirmedPassword;

    private Boolean enabled = true;

    @ManyToMany(cascade=CascadeType.MERGE)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
    private Set<Role> roles;

    private Integer failedLoginAttempts = 0;

    @OneToMany(mappedBy = "author")
    private Collection<DocumentNote> notes;

    public void addRole(Role role){
        if(!this.roles.contains(role)){
            this.roles.add(role);
        }
        if(!role.getUsers().contains(this)){
            role.getUsers().add(this);
        }
    }
    public void removeRole(Role role){
        this.roles.remove(role);
        role.getUsers().remove(this);
    }
}
