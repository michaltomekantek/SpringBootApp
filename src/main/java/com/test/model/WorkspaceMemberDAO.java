package com.test.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = {"workspaceDAO", "contactPersonDAO"})
public class WorkspaceMemberDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private WorkspaceDAO workspaceDAO;

    @ManyToOne(cascade = CascadeType.ALL)
    private ContactPersonDAO contactPersonDAO;
}
