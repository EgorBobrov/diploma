package com.egobob.diploma.domain.role;

import com.egobob.diploma.domain.AbstractDomainClass;
import com.egobob.diploma.domain.user.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(includeFieldNames = false, onlyExplicitlyIncluded = true)
@Table(name = "role")
public class Role extends AbstractDomainClass {

    @ToString.Include
    @NotNull
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }
        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }
    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }

}
