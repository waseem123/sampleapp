package com.learn.sampleapp.repository;

import com.learn.sampleapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface MappingRepository extends CrudRepository<User,Long> {

}
