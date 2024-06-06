package com.webpage.fshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.webpage.fshop.model.Account;
import org.springframework.data.repository.query.Param;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query("SELECT n FROM Account n WHERE n.username = :username")
    Account findByUsername(@Param("username") String username);

}
