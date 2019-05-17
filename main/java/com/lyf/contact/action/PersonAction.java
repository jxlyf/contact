package com.lyf.contact.action;

import com.lyf.contact.dao.PersonRepository;
import com.lyf.contact.modle.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ：liyanfa
 * @date ：Created in 2019/5/15 14:47
 * @description：person
 */
@Controller
@RequestMapping("person")
public class PersonAction {
    private PersonRepository personRepository;

    @Autowired
    public PersonAction(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "/{home}", method = RequestMethod.GET)
    public String findPersonByHome(@PathVariable("home") String home, Model model) {
        List<Person> personList = personRepository.findPersonByHome(home);
        if (personList != null && personList.size() > 0)
            model.addAttribute("personList",personList);
            return "personList";
    }

    @RequestMapping(value = "/{home}",method = RequestMethod.POST)
    public String addOne(@PathVariable("home") String home, Person person) {
        person.setHome(home);
        personRepository.save(person);
        return "redirect:/person/{home}";
    }

}
