package com.test.config.repository;


import com.test.Main;
import com.test.config.H2TestProfileJPAConfig;
import com.test.model.ContactPersonDAO;
import com.test.model.WorkspaceMemberDAO;
import com.test.model.WorkspaceDAO;
import com.test.repository.ContactPersonRepository;
import com.test.repository.PersonRepository;
import com.test.repository.WorkspaceMemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class PersonTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    private WorkspaceMemberRepository workspaceMemberRepository;

    @PersistenceContext
    private EntityManager em;




    @Test
    @Transactional
    @Rollback(false)
    public void test(){

        testTran();

       // workspaceMemberRepository.saveAndFlush(workspaceMemberDAO1);


//        WorkspaceMemberDAO workspaceMemberDAO1 = new WorkspaceMemberDAO();
//        workspaceMemberDAO1.setWorkspaceDAO(workspaceDAO);
//        workspaceMemberDAO1.setContactPersonDAO(contactPersonDAO);
//
//        contactPersonDAO.getMembers().add(workspaceMemberDAO1);

      //  contactPersonRepository.save(contactPersonDAO);

    }

    public void testTran(){
        WorkspaceMemberDAO workspaceMemberDAO = new WorkspaceMemberDAO();

        ContactPersonDAO contactPersonDAO = new ContactPersonDAO();
        contactPersonDAO.getMembers().add(workspaceMemberDAO);
        WorkspaceDAO workspaceDAO = new WorkspaceDAO();
        workspaceDAO.getMembers().add(workspaceMemberDAO);
        workspaceDAO.setOwner(workspaceMemberDAO);

        workspaceMemberDAO.setWorkspaceDAO(workspaceDAO);
        workspaceMemberDAO.setContactPersonDAO(contactPersonDAO);



        workspaceMemberRepository.save(workspaceMemberDAO);

        WorkspaceMemberDAO workspaceMemberDAO1 = new WorkspaceMemberDAO();

        workspaceMemberDAO.getWorkspaceDAO().getMembers().add(workspaceMemberDAO1);
        workspaceMemberDAO.getContactPersonDAO().getMembers().add(workspaceMemberDAO1);

        workspaceMemberDAO1.setContactPersonDAO(workspaceMemberDAO.getContactPersonDAO());
        workspaceMemberDAO1.setWorkspaceDAO(workspaceMemberDAO.getWorkspaceDAO());

        //em.merge(workspaceMemberDAO.getContactPersonDAO());

        workspaceMemberRepository.save(workspaceMemberDAO1);

        WorkspaceMemberDAO workspaceMemberDAO2 = new WorkspaceMemberDAO();
        WorkspaceDAO workspaceDAO1 = new WorkspaceDAO();
        workspaceMemberDAO2.setWorkspaceDAO(workspaceDAO1);
        workspaceMemberDAO2.setContactPersonDAO(workspaceMemberDAO1.getContactPersonDAO());
        workspaceMemberDAO1.getContactPersonDAO().getMembers().add(workspaceMemberDAO2);
        workspaceDAO1.setOwner(workspaceMemberDAO2);
        workspaceDAO1.getMembers().add(workspaceMemberDAO2);

        workspaceMemberRepository.save(workspaceMemberDAO2);



        workspaceMemberRepository.save(workspaceMemberDAO2);





    }
}
