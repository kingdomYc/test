package com.example.demo.controller;

import com.example.demo.model.Person;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value="/Persons")     // 通过这里配置使下面的映射都在/Persons下，可去除

public class PersonController {

    static Map<Long,Person> Persons = Collections.synchronizedMap(new HashMap<Long, Person>());

    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value={""}, method=RequestMethod.GET)
    public List<Person> getPersonList() {
        List<Person> r = new ArrayList<Person>(Persons.values());
        return r;
    }

    @ApiOperation(value="创建用户", notes="根据Person对象创建用户")
    @ApiImplicitParam(name = "Person", value = "用户详细实体Person", required = true, dataType = "Person")
    @RequestMapping(value="", method=RequestMethod.POST)
    public String postPerson(@RequestBody Person Person) {
        Persons.put(Person.getId(), Person);
        return "success";
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Person getPerson(@PathVariable Long id) {
        return Persons.get(id);
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的Person信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "Person", value = "用户详细实体Person", required = true, dataType = "Person")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.PUT)
    public String putPerson(@PathVariable Long id, @RequestBody Person Person) {
        Person u = Persons.get(id);
        u.setName(Person.getName());
        u.setAge(Person.getAge());
        Persons.put(id, u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deletePerson(@PathVariable Long id) {
        Persons.remove(id);
        return "success";
    }

}
