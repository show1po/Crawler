package com.tn.web.repository;

import com.tn.web.po.Gamble;
import com.tn.web.po.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Show on 2016/10/24.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByAccount(String account);
}
