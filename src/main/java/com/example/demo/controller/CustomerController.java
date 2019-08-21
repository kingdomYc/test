package com.example.demo.controller;

import com.example.demo.model.Customer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping(value = "/User")

public class CustomerController {
//    @ApiOperation(value="hello world",notes="")
//    @RequestMapping("/index")
//    public String index(){
//        return "Hello World";
//    }

//    @RequestMapping("/getUser")
//    public User getUser(){
//        //return "Hello World";
//        User user = new User();
//        user.setUserName("小明");
//        user.setPassWord("xxxx");
//        return user;
//    }
    static Map<Long,Customer> customers = Collections.synchronizedMap(new HashMap<Long,Customer>());

    @ApiOperation(value="获取⽤户列表",	notes="")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<Customer> getUserList(){
        //	处理"/users/"的GET请求，⽤来获取⽤户列表
        // 	还可以通过@RequestParam从⻚⾯中传递参数来进⾏查询条件或者翻⻚信息的传递
        List<Customer>	r	=	new ArrayList<Customer>(customers.values());
        return	r;
    }

    @ApiOperation(value="创建⽤户",	notes="根据User对象创建⽤户")
    @ApiImplicitParam(name="user",value="⽤户详细实体user",required=true,dataType="User")
    @RequestMapping(value="/",	method=RequestMethod.POST)
    public	String	postUser(@ModelAttribute Customer user)	{
        //	处理"/users/"的POST请求，⽤来创建User
        // 	除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从⻚⾯中传递参数
        customers.put(user.getId(),	user);
        return	"success";
    }

    @ApiImplicitParam(name="id",value="⽤户ID",required=	true,dataType="Long")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customer getUser(@PathVariable Long id){
        return customers.get(id);
    }


    @ApiOperation(value="更新⽤户详细信息",	notes="根据url的id来指定更新对象，并根据传过来的 user信息来更新⽤户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "⽤户ID", required = true,	dataType = "Long"),
            @ApiImplicitParam(name = "user",value ="⽤户详细实体user",required = true,dataType = "User")
    })
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute Customer c){
        Customer customer = customers.get(id);
        customer.setName(c.getName());
        customer.setAge(c.getAge());
        customers.put(id,customer);
        return "success";
    }
    @ApiOperation(value="删除⽤户",	notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name="id",value="⽤户ID",required=true,dataType="Long")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String putUser(@PathVariable Long id){
        //Customer customer = customers.get(id);
        customers.remove(id);
        return "success";
    }
}
