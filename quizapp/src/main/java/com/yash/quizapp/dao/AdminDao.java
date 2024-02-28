package com.yash.quizapp.dao;

import com.yash.quizapp.Admin;
import com.yash.quizapp.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {
    @Query("SELECT a FROM Admin a WHERE a.admin_email = :email")
    Admin getAdminByEmail(@Param("email") String email);
}
