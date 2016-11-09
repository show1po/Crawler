package com.tn.web.repository;

import com.tn.web.po.Gamble;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Show on 2016/10/20.
 */
public interface  GambleRepository extends CrudRepository<Gamble, Long> {
    List<Gamble> findByCreator(String creator);
}

