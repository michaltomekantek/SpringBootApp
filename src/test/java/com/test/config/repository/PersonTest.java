package com.test.config.repository;


import com.test.Main;
import com.test.config.H2TestProfileJPAConfig;
import com.test.model.Person;
import com.test.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class, H2TestProfileJPAConfig.class})
@ActiveProfiles("test")
public class PersonTest {


    @Autowired
    private PersonRepository personRepository;




    @Test
    public void test(){
        Person person = new Person();

        person = personRepository.save(person);

        System.out.println(person.getId());

    }
}
