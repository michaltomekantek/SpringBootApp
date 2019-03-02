package com.test.repository;

import com.test.model.WorkspaceMemberDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceMemberRepository  extends JpaRepository<WorkspaceMemberDAO, Long> {
}
