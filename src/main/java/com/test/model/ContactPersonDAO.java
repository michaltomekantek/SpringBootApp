package com.test.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "members")
public class ContactPersonDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "contactPersonDAO", cascade = CascadeType.ALL)
    private Set<WorkspaceMemberDAO> members = new HashSet<>();
}
