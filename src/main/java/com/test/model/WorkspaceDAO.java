package com.test.model;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"members", "owner"} )
public class WorkspaceDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private WorkspaceMemberDAO owner;

    @OneToMany(mappedBy = "workspaceDAO", cascade = CascadeType.ALL)
    private Set<WorkspaceMemberDAO> members = new HashSet<>();

}
