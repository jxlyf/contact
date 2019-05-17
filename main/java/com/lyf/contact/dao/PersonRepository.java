package com.lyf.contact.dao;

import com.lyf.contact.modle.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：liyanfa
 * @date ：Created in 2019/5/15 14:51
 * @description：person
 */
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findPersonByHome(String home);
}
