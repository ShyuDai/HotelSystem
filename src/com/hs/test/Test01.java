package com.hs.test;

import java.sql.SQLException;


import com.hs.entity.Customer;
import com.hs.entity.Department;
import com.hs.entity.Role;
import com.hs.entity.Room;
import com.hs.entity.Roomtype;
import com.hs.entity.User;
import com.hs.service.CustomerServiceGH;
import com.hs.service.DepartmentServiceGH;
import com.hs.service.RoleServiceGH;
import com.hs.service.RoomServiceGH;
import com.hs.service.RoomTypeServiceGH;
import com.hs.service.UserServiceGH;
import com.hs.utils.SQL;

public class Test01 {
    //public static String [] attruArra={"roomid","roomnumber","roomtypid","roomtypename","roomintroduce","roomstatus"};

    
    
    
    
    public static void main(String s[]) throws SQLException{
    	
    	System.out.println("************************************room测试*************************************************************************************************");
        int singleattrCode=2;
        String singlevalue="1001";
        System.out.println("---------------------------------------单个条件查询--------------------------------------------------------------");
        System.out.println("1--->room单条件查询数量的sql语句："+SQL.getRoomQueryByCount(singleattrCode,singlevalue));
        System.out.println("2--->room单条件查询集合的-->sql语句："+ SQL.getRoomQuerySqlByPage(1,12,singleattrCode,singlevalue));
      
        RoomServiceGH service=new RoomServiceGH();

        System.out.println("单条件查询"+singlevalue+"的数量-->"+service.getRoomsCount(singleattrCode,singlevalue));
        
       /* for(int i=0;i<100;i++) {*/
        for(Room room:service.getRoomsByPage(1,12,singleattrCode,singlevalue)){
        	/*service.save(room);*/
            System.out.println(room.toString());
        }
       /* }*/
        
        
        System.out.println("---------------------------------------条件组合查询--------------------------------------------------------------");
        
        int mutipleAttruCode=7;//attruCode=7代表条件组合查询
        String mutipleValue="大";
        System.out.println("3--->room条件组合查询数量的sql语句："+SQL.getRoomQueryByCount(mutipleAttruCode,mutipleValue));
        System.out.println("4--->room条件组合查询数量的sql语句："+SQL.getRoomQuerySqlByPage(1,12,mutipleAttruCode,mutipleValue));

        System.out.println("条件组合查询‘"+mutipleValue+"’的数量-->"+service.getRoomsCount(mutipleAttruCode,mutipleValue));
        for(Room room:service.getRoomsByPage(1,12,mutipleAttruCode,mutipleValue)) {
        	System.out.println(room.toString());
        }
        
        
        System.out.println();
        System.out.println();
        System.out.println("************************************customer测试************************************");
        singleattrCode=1;
        singlevalue="1";
        
        
        mutipleAttruCode=6;//代号为6代表条件组合查询
        mutipleValue="男";
        System.out.println("---------------------------------------单个条件查询--------------------------------------------------------------");
        System.out.println("1--->customer查询数量的sql语句："+SQL.getCustomerQueryByCount(singleattrCode,singlevalue));
        System.out.println("2--->customer查询集合的-->sql语句："+ SQL.getCustomerQuerySqlByPage(1,12,singleattrCode,singlevalue));
        CustomerServiceGH cservice=new CustomerServiceGH();
        System.out.println("单条件查询"+singlevalue+"的数量-->"+cservice.getCustomerCount(singleattrCode, singlevalue));
        for(Customer customer:cservice.getCustomersByPage(1,12,singleattrCode,singlevalue)) {
        	System.out.println(customer.toString());
        }
        System.out.println();
        System.out.println("3--->customer条件组合查询数量的sql语句："+SQL.getCustomerQueryByCount(mutipleAttruCode,mutipleValue));
        System.out.println("4--->customer条件组合查询集合的-->sql语句："+ SQL.getCustomerQuerySqlByPage(1,12,mutipleAttruCode,mutipleValue));
        System.out.println("条件组合查询‘"+mutipleValue+"’的数量-->"+cservice.getCustomerCount(mutipleAttruCode, mutipleValue));
        for(Customer customer:cservice.getCustomersByPage(1,12,mutipleAttruCode,mutipleValue)) {
        	System.out.println(customer.toString());
        }
        System.out.println();
        System.out.println("************************************roomtype测试************************************************************************");
        RoomTypeServiceGH typeservice=new RoomTypeServiceGH();
        for(Roomtype rt:typeservice.getAllRoomTpes()) {
        	  System.out.println(rt.toString());
              
        }
      
        System.out.println();
        System.out.println("************************************houqin测试************************************************************************");
        
        System.out.println();
        System.out.println("************************************user测试************************************************************************");
        System.out.println("-----------------用户查询-----------------------------------------------------------");
        
        UserServiceGH uservice=new UserServiceGH();
        User user=new User();
        user.setUserid(5);
        user.setEmpnumber("525255225");
        user.setPassword("12525");
        user.setRoleid(5);
        
        int userAttru=5;
        String userValue="2015";
       /* System.out.println(uservice.delete(user)?"用户删除成功！":"用户删除失败");
        */
        System.out.println("1--->user查询数量的sql语句："+SQL.getUserQueryByCount(userAttru,userValue));
        System.out.println("2--->user查询集合的-->sql语句："+ SQL.getUserQuerySqlByPage(1,12,userAttru,userValue));
        System.out.println("条件组合查询'"+userValue+"的'数量----->"+uservice.getUsersCountByPage(userAttru, userValue));
        for(User u:uservice.getUsersByPage(1,12, userAttru,userValue)) {
        System.out.println(u.toString());
        }
        
        
        
        System.out.println();
        System.out.println("************************************role测试************************************************************************");
        System.out.println("-----------------添加role-----------------------------------------------------------");
        RoleServiceGH roleService=new RoleServiceGH();
        Role role=new Role();
        role.setRoleId(1);
        role.setLevel(1);
        role.setMonthPay(100000);
        role.setRoleName("总经理");
       // System.out.println(roleService.save(role)?"职位添加成功":"职位添加失败");
        //System.out.println(roleService.delete(role)?"职位删除成功":"职位删除失败");
        
        
       
        System.out.println();
        System.out.println("************************************department测试************************************************************************");
        System.out.println("-----------------添加department-----------------------------------------------------------");
        DepartmentServiceGH departmentService=new DepartmentServiceGH();
        Department department=new Department();
        department.setDepManager("王五");
        department.setDepName("财务部");
        department.setDepNo("103001");
     
       // System.out.println(departmentService.save(department)?"部门添加成功":"部门添加失败");
        //System.out.println(roleService.delete(role)?"职位删除成功":"职位删除失败");
        
        System.out.println();
        System.out.println("************************************employee测试************************************************************************");
        System.out.println("-----------------添加employee-----------------------------------------------------------");
    }
}
