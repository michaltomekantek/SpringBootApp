package com.test.repository;

import com.test.model.ContactPersonDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPersonDAO, Long> {
}
