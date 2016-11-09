package com.tn.web.repository;

import com.tn.web.po.Gamble;
import com.tn.web.po.PositionMapping;
import com.tn.web.po.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Show on 2016/10/24.
 */
public interface PositionMappingRepository extends CrudRepository<PositionMapping, Long> {
    List<PositionMapping> findAllByUser(User user);
}
