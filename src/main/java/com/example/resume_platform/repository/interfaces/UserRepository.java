package com.example.resume_platform.repository.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.resume_platform.dto.SignInFormDTO;
import com.example.resume_platform.dto.SignUpFormDTO;
import com.example.resume_platform.repository.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class UserRepository {
    // private static final Logger logger =
    // LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    private EntityManager em;

    @Transactional
    public void insert(SignUpFormDTO signUpFormDTO) {
        Query query = em.createNativeQuery(
                "insert into user_tb (USERNAME, PASSWORD, USERID) values (:username, :password, :userid)");
        query.setParameter("username", signUpFormDTO.getUsername());
        query.setParameter("password", signUpFormDTO.getPassword());
        query.setParameter("userid", signUpFormDTO.getUserid());
        query.executeUpdate();
    }

    public User findById(String id) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM user_tb WHERE id = :id", User.class);
            query.setParameter("id", id);
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            System.out.println("쿼리 실행 중 오류: " + e.getMessage());
            return null;
        }
    }

    public User findByUserId(SignInFormDTO signInFormDTO) {
        Query query = em.createNativeQuery("select * from user_tb where userid = :userid", User.class);
        query.setParameter("userid", signInFormDTO.getUserid());
        User user = (User) query.getSingleResult();
        return user;
    }

}
