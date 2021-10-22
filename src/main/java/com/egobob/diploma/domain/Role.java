package com.egobob.diploma.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractDomainClass {

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) {
        this.users = users;
    }
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
