package com.hs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQL {


    private static String table_room=null;
    private static String table_customer=null;
    private static String table_houqin=null;
    private static String table_user=null;
    private static String table_employee=null;  
    
 
    public static String [] roomAttruArra={"roomid","roomnumber","roomtypeid","roomtypename","roomintroduce","roomstatus"};
    public static String [] customerAttruArra={"id","name","sex","idcard","phone"};
    public static String [] houqinAttruArra={"empnumber","roomid","roomnumber","roomtypename","staercleantime","endcleantime"};
    public static String [] userAttruArra= {"userid","empnumber","password","roleid"};
    public static String [] emloyeeAttruArra= {"empId","empNo","empName","empSex","empAge","empEntryDate","empWorkingYears","empRemark","roleId","roleName","level","monthPay","depId","depNo","depName","depManager"};
    
    //静态初始化块只会在类加载的时候加载一次,加载表名
    static {
        InputStream is=DBConnectionUtil.class.getClassLoader().getResourceAsStream("table.properties");
        Properties p=new Properties();
        try {
            p.load(is);
            table_room=p.getProperty("table_room");
            table_customer=p.getProperty("table_customer");
            table_houqin=p.getProperty("table_houqin");
            table_user=p.getProperty("table_user");
            table_employee=p.getProperty("table_employee");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   /* public static String [] roomAttruArra={"roomid","roomnumber","roomtypeid","roomtypename","roomintroduce","roomstatus"};*/
    public static String getRoomQueryByCount(int attrCode,String value){
        String sql="select count(*) count from "+table_room;
        switch (attrCode){//1-6表示查询根据6个属性查询
            case 0://表示查询数据表总记录数
            	
             	break;
            case 1:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[0] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[0] + "='" +value+"'";
                }
                break;
            case 2:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[1] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[1] + "like '" +value+"%'";
                }
                break;
            case 3:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[2] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[2] + "='" +value+"'";
                }
                break;

            case 4:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[3] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[3] + " like '" +value+"%'";
                }
                break;


            case 5:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[4] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[4] + " like '%" +value+"%'";
                }
                break;

            case 6:
                if(isNum(value)) {
                    sql += " where " + roomAttruArra[5] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + roomAttruArra[5] + " ='" +value+"'";
                }
                break;
                

            case 7://条件组合查询
            	if(isNum(value)){
                    sql+=" where "+
              	 roomAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                roomAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                roomAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                roomAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                roomAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                roomAttruArra[5]+" ="+ Integer.parseInt(value);
               
                }else {
                    sql+=" where "+
                roomAttruArra[0]+" like '%"+value+"%' or "+
                roomAttruArra[1]+" like '%"+value+"%' or "+
                roomAttruArra[2]+" like '%"+value+"%' or "+
                roomAttruArra[3]+" like '%"+value+"%' or "+
                roomAttruArra[4]+" like '%"+value+"%' or "+
                roomAttruArra[5]+" like '%"+value+"%'";
           
                }
                break;
                
                
        }
        return sql;
    }

    public static  String getRoomQuerySqlByPage( int pageNo, int pageSize,int attrCode,String value){
        String sql="select *from "+table_room;
        switch (attrCode){
            case 0://表示查询所有
            	sql+=" limit "+(pageNo-1)*pageSize+" , "+pageSize;
            	break;
            case 1:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[0]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+roomAttruArra[0]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 2:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[1]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+roomAttruArra[1]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 3:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[2]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+roomAttruArra[2]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
            break;

            case 4:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[3]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where " + roomAttruArra[3] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;


            case 5:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[4]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                	sql+=" where " + roomAttruArra[4] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 6:
                if(isNum(value)){
                    sql+=" where "+roomAttruArra[5]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+roomAttruArra[5]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 7://条件组合查询
            	 if(isNum(value)){
                     sql+=" where "+
               	 roomAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                 roomAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                 roomAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                 roomAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                 roomAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                 roomAttruArra[5]+" ="+ Integer.parseInt(value)+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }else {
                     sql+=" where "+
                 roomAttruArra[0]+" like '%"+value+"%' or "+
                 roomAttruArra[1]+" like '%"+value+"%' or "+
                 roomAttruArra[2]+" like '%"+value+"%' or "+
                 roomAttruArra[3]+" like '%"+value+"%' or "+
                 roomAttruArra[4]+" like '%"+value+"%' or "+
                 roomAttruArra[5]+" like '%"+value+"%'"+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }
                break;

        }
    return sql;
    }
    
    
    /*public static String [] customerAttruArra={"id","name","sex","idcard","phone"};*/
    public static String getCustomerQueryByCount(int attrCode,String value){
        String sql="select count(*) count from "+table_customer;
        switch (attrCode){//1-6表示查询根据6个属性查询
            case 0://表示查询数据表总记录数
      
             	break;
            case 1:
                if(isNum(value)) {
                    sql += " where " + customerAttruArra[0] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + customerAttruArra[0] + "='" +value+"'";
                }
                break;
            case 2:
                if(isNum(value)) {
                    sql += " where " + customerAttruArra[1] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + customerAttruArra[1] + "='%" +value+"%'";
                }
                break;
            case 3:
                if(isNum(value)) {
                    sql += " where " + customerAttruArra[2] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + customerAttruArra[2] + "='" +value+"'";
                }
                break;

            case 4:
                if(isNum(value)) {
                    sql += " where " + customerAttruArra[3] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + customerAttruArra[3] + " like '%" +value+"%'";
                }
                break;


            case 5:
                if(isNum(value)) {
                    sql += " where " + customerAttruArra[4] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + customerAttruArra[4] + " like '%" +value+"%'";
                }
                break;

            case 6://条件组合查询
            	/*if(isNum(value)){
                    sql+=" where "+
                    		customerAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                    		customerAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                    		customerAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                    		customerAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                    		customerAttruArra[4]+" ="+ Integer.parseInt(value);
                }else {*/
                    sql+=" where "+
                    		customerAttruArra[0]+" like '"+value+"%' or "+
                    		customerAttruArra[1]+" like '"+value+"%' or "+
                    		customerAttruArra[2]+" like '"+value+"%' or "+
                    		customerAttruArra[3]+" like '"+value+"%' or "+
                    		customerAttruArra[4]+" like '"+value+"%'";
                  /*  
                    sql+=" where "+
                    		customerAttruArra[0]+" like '%"+value+"%' or "+
                    		customerAttruArra[1]+" like '%"+value+"%' or "+
                    		customerAttruArra[2]+" like '%"+value+"%' or "+
                    		customerAttruArra[3]+" like '%"+value+"%' or "+
                    		customerAttruArra[4]+" like '%"+value+"%'";*/
                //}
                break;
             
        }
        return sql;
    }

    public static  String getCustomerQuerySqlByPage( int pageNo, int pageSize,int attrCode,String value){
        String sql="select *from "+table_customer;
        switch (attrCode){
            case 0://表示查询所有
            	sql+=" limit "+(pageNo-1)*pageSize+" , "+pageSize;
            	break;
            case 1:
                if(isNum(value)){
                    sql+=" where "+customerAttruArra[0]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+customerAttruArra[0]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 2:
                if(isNum(value)){
                    sql+=" where "+customerAttruArra[1]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+customerAttruArra[1]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 3:
                if(isNum(value)){
                    sql+=" where "+customerAttruArra[2]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+customerAttruArra[2]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
            break;

            case 4:
                if(isNum(value)){
                    sql+=" where "+customerAttruArra[3]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where " + customerAttruArra[3] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;


            case 5:
                if(isNum(value)){
                    sql+=" where "+customerAttruArra[4]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                	sql+=" where " + customerAttruArra[4] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 6:
            	 /* if(isNum(value)){
                      sql+=" where "+
                    		  customerAttruArra[0]+" ="+value+" or "+
                    		  customerAttruArra[1]+" ="+value+" or "+
                    		  customerAttruArra[2]+" ="+value+" or "+
                    		  customerAttruArra[3]+" ="+value+" or "+
                    		  customerAttruArra[4]+" ="+value+
                  " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                  }else {*/
                      sql+=" where "+
                    		  customerAttruArra[0]+" like '"+value+"%' or "+
                      		customerAttruArra[1]+" like '"+value+"%' or "+
                      		customerAttruArra[2]+" like '"+value+"%' or "+
                      		customerAttruArra[3]+" like '"+value+"%' or "+
                      		customerAttruArra[4]+" like '"+value+"%'"+
                  " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 // }
                break;
                
        }
    return sql;
    }
    
    
   /* public static String [] houqinAttruArra={"empnumber","roomid","roomnumber","roomtypename","staercleantime","endcleantime"};
    */
    public static String getHouQinQueryByCount(int attrCode,String value){
        String sql="select count(*) count from "+table_houqin;
        switch (attrCode){//1-6表示查询根据6个属性查询
            case 0://表示查询数据表总记录数
            	
             	break;
            case 1:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[0] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[0] + "='" +value+"'";
                }
                break;
            case 2:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[1] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[1] + "='%" +value+"%'";
                }
                break;
            case 3:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[2] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[2] + "='" +value+"'";
                }
                break;

            case 4:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[3] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[3] + " like '%" +value+"%'";
                }
                break;


            case 5:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[4] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[4] + " like '%" +value+"%'";
                }
                break;

            case 6:
                if(isNum(value)) {
                    sql += " where " + houqinAttruArra[5] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + houqinAttruArra[5] + " ='" +value+"'";
                }
                break;
                

            case 7://条件组合查询
            	 if(isNum(value)){
                     sql+=" where "+
                    		 houqinAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[5]+" ="+ Integer.parseInt(value);
                 }else {
                     sql+=" where "+
                    		 houqinAttruArra[0]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[1]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[2]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[3]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[4]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[5]+" like '%"+value+"%'";
                 }
                break;
                
                
        }
        return sql;
    }

    public static  String getHouQinQuerySqlByPage( int pageNo, int pageSize,int attrCode,String value){
        String sql="select *from "+table_houqin;
        switch (attrCode){
            case 0://表示查询所有
            	sql+=" limit "+(pageNo-1)*pageSize+" , "+pageSize;
            	break;
            case 1:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[0]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+houqinAttruArra[0]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 2:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[1]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+houqinAttruArra[1]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 3:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[2]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+houqinAttruArra[2]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
            break;

            case 4:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[3]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where " + houqinAttruArra[3] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;


            case 5:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[4]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                	sql+=" where " + houqinAttruArra[4] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 6:
                if(isNum(value)){
                    sql+=" where "+houqinAttruArra[5]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+houqinAttruArra[5]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 7://条件组合查询
            	 if(isNum(value)){
                     sql+=" where "+
                    		 houqinAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                    		 houqinAttruArra[5]+" ="+ Integer.parseInt(value)+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }else {
                     sql+=" where "+
                    		 houqinAttruArra[0]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[1]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[2]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[3]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[4]+" like '%"+value+"%' or "+
                    		 houqinAttruArra[5]+" like '%"+value+"%'"+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }
                break;

        }
    return sql;
    }
    
    /*public static String [] userAttruArra= {"userid","empnumber","password","roleid"};*/
    
    public static String getUserQueryByCount(int attrCode,String value){
        String sql="select count(*) count from "+table_user;
        switch (attrCode){//1-6表示查询根据6个属性查询
            case 0://表示查询数据表总记录数
      
             	break;
            case 1:
                if(isNum(value)) {
                    sql += " where " + userAttruArra[0] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + userAttruArra[0] + "='" +value+"'";
                }
                break;
            case 2:
                if(isNum(value)) {
                    sql += " where " + userAttruArra[1] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + userAttruArra[1] + "like '" +value+"%'";
                }
                break;
            case 3:
                if(isNum(value)) {
                    sql += " where " + userAttruArra[2] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + userAttruArra[2] + "like '" +value+"%'";
                }
                break;

            case 4:
                if(isNum(value)) {
                    sql += " where " + userAttruArra[3] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + userAttruArra[3] + " ='" +value+"'";
                }
                break;


      
            case 5://条件组合查询
                    sql+=" where "+
                    		userAttruArra[0]+" like '"+value+"%' or "+
                    		userAttruArra[1]+" like '"+value+"%' or "+
                    		userAttruArra[2]+" like '"+value+"%' or "+
                    		userAttruArra[3]+" like '"+value+"%'";
                  
                break;
             
        }
        return sql;
    }
    
    /*public static String [] userAttruArra= {"userid","empnumber","password","roleid"};*/
    public static  String getUserQuerySqlByPage( int pageNo, int pageSize,int attrCode,String value){
        String sql="select *from "+table_user;
        switch (attrCode){
            case 0://表示查询所有
            	sql+=" limit "+(pageNo-1)*pageSize+" , "+pageSize;
            	break;
            case 1:
                if(isNum(value)){
                    sql+=" where "+userAttruArra[0]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+userAttruArra[0]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 2:
                if(isNum(value)){
                    sql+=" where "+userAttruArra[1]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+userAttruArra[1]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 3:
                if(isNum(value)){
                    sql+=" where "+userAttruArra[2]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+userAttruArra[2]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
            break;

            case 4:
                if(isNum(value)){
                    sql+=" where "+userAttruArra[3]+" ="+value+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where " + userAttruArra[3] + " ='" +value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;


          
            case 5:
           
                      sql+=" where "+
                    		  userAttruArra[0]+" like '"+value+"%' or "+
                    		  userAttruArra[1]+" like '"+value+"%' or "+
                    		  userAttruArra[2]+" like '"+value+"%' or "+
                    		  userAttruArra[3]+" like '"+value+"%'"+
                  " limit "+(pageNo-1)*pageSize+" , "+pageSize;
               
                break;
                
        }
    return sql;
    }
    
    
   /* public static String [] emloyeeAttruArra= {
    * "empId","empNo","empName",
    * "empSex","empAge","empEntryDate",
    * "empWorkingYears","empRemark","roleId",
    * "roleName","level","monthPay",
    * "depId","depNo","depName",
    * "depManager"};
   */ 
    //根据区间段查询员工表数量的SQL语句
    public static String getEmployeeQueryByInterval(int attrCode,String start,String end) {
    	 String sql="select count(*) count from "+table_employee;
    	switch (attrCode) {
    	
		case 5://empAgeInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[4]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[4]+"<="+Integer.parseInt(end);
			}else {
			sql+=" where "+emloyeeAttruArra[4]+">='"+start+"' and "+emloyeeAttruArra[4]+"<='"+end+"'";
			}
			break;
			
		case 6://empEntryDateInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[5]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[5]+"<="+Integer.parseInt(end);
			}else {
			sql+=" where "+emloyeeAttruArra[5]+">='"+start+"' and "+emloyeeAttruArra[5]+"<='"+end+"'";
			}
			break;
			
		case 7://empWorkingYearsInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[6]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[6]+"<="+Integer.parseInt(end);
			}else {
			sql+=" where "+emloyeeAttruArra[6]+">='"+start+"' and "+emloyeeAttruArra[6]+"<='"+end+"'";
			}
			break;
			
		case 12://monthPayInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[11]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[11]+"<="+Integer.parseInt(end);
			}else {
			sql+=" where "+emloyeeAttruArra[11]+">='"+start+"' and "+emloyeeAttruArra[11]+"<='"+end+"'";
			}
			break;

		
		}
    	
    	return sql;
    }
    
  //根据区间段查询员工表员工信息的SQL语句
    public static String getEmployeeListByInterval(int pageNo,int pageSize,int attrCode,String start,String end) {
    	 String sql="select *from "+table_employee;
    	switch (attrCode) {
		case 5://empAgeInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[4]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[4]+"<="+Integer.parseInt(end)+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}else {
			sql+=" where "+emloyeeAttruArra[4]+">='"+start+"' and "+emloyeeAttruArra[4]+"<='"+end+"'"+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}
			break;
			
		case 6://empEntryDateInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[5]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[5]+"<="+Integer.parseInt(end)+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}else {
			sql+=" where "+emloyeeAttruArra[5]+">='"+start+"' and "+emloyeeAttruArra[5]+"<='"+end+"'"+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}
			break;
			
		case 7://empWorkingYearsInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[6]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[6]+"<="+Integer.parseInt(end)+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}else {
			sql+=" where "+emloyeeAttruArra[6]+">='"+start+"' and "+emloyeeAttruArra[6]+"<='"+end+"'"+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}
			break;
			
		case 12://monthPayInterval
			if(isNum(start)&&isNum(end)) {
			sql+=" where "+emloyeeAttruArra[11]+">="+Integer.parseInt(start)+" and "+emloyeeAttruArra[11]+"<="+Integer.parseInt(end)+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}else {
			sql+=" where "+emloyeeAttruArra[11]+">='"+start+"' and "+emloyeeAttruArra[11]+"<='"+end+"'"+" limit "+(pageNo-1)*pageSize+","+pageSize;
			}
			break;

		
		}
    	
    	return sql;
    }
    
    
    
    //根据属性查询员工数量
    public static String getEmployeeQueryByCount(int attrCode,String value){
        String sql="select count(*) count from "+table_employee;
        switch (attrCode){//1-6表示查询根据6个属性查询
            case 0://表示查询数据表总记录数
            	
             	break;
            case 1://empId
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[0] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[0] + " ='" +value+"'";
                }
                break;
            case 2://empNo
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[1] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[1] + " like '" +value+"%'";
                }
                break;
            case 3://empName
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[2] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[2] + " like '" +value+"%'";
                }
                break;

            case 4://empSex
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[3] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[3] + " = '" +value+"'";
                }
                break;


            case 5://empAge
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[4] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[4] + " ='" +value+"'";
                }
                break;

            case 6://empEntryDate
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[5] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[5] + " like '" +value+"%'";
                }
                break;
                
                
            case 7://empWorkingYears
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[6] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[6] + " ='" +value+"'";
                }
                break;
                
                
                
            case 8://empRemark
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[7] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[7] + " like '%" +value+"%'";
                }
                break;

            case 9://roleId
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[8] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[8] + " ='" +value+"'";
                }
                break;
                
                

            case 10://roleName
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[9] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[9] + " like '%" +value+"%'";
                }
                break;

            case 11://level
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[10] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[10] + " ='" +value+"'";
                }
                break;
                

            case 12://monthPay
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[11] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[11] + " = '" +value+"'";
                }
                break;

            case 13://depId
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[12] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[12] + " ='" +value+"'";
                }
                break;
                

            case 14://depNo
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[13] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[13] + " like '" +value+"%'";
                }
                break;

            case 15://depName
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[14] + "=" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[14] + " like '%" +value+"%'";
                }
                break;
                

            case 16://depManager
                if(isNum(value)) {
                    sql += " where " + emloyeeAttruArra[15] + " =" + Integer.parseInt(value);
                }else{
                    sql += " where " + emloyeeAttruArra[15] + " like '" +value+"%'";
                }
                break;

          
               
            case 17://条件组合查询
            	if(isNum(value)){
                    sql+=" where "+
                    		emloyeeAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[5]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[6]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[7]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[8]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[9]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[10]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[11]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[12]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[13]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[14]+" ="+ Integer.parseInt(value)+" or "+
                    		emloyeeAttruArra[15]+" ="+ Integer.parseInt(value);
               
                }else {
                    sql+=" where "+
                    		 emloyeeAttruArra[0] + " ='" +   value+"%' or "+
                    		 emloyeeAttruArra[1] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[2] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[3] + " = '" +value+"' or "+
                    		 emloyeeAttruArra[4] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[5] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[6] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[7] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[8] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[9] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[10] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[11] + " = '" +value+"' or "+
                    		 emloyeeAttruArra[12] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[13] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[14] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[15] + " like '" +value+"%'";
                    		 
                }
                break;
                
                
        }
        return sql;
    }

    public static  String getEmployeeQuerySqlByPage( int pageNo, int pageSize,int attrCode,String value){
        String sql="select *from "+table_employee;
        switch (attrCode){
            case 0://表示查询所有
            	sql+=" limit "+(pageNo-1)*pageSize+" , "+pageSize;
            	break;
            case 1://empId
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[0]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[0]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 2://empNo
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[1]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[1] + " like '" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;

            case 3://empName
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[2]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[2] + " like '" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
            break;

            case 4://empSex
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[3]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where " +emloyeeAttruArra[3] + " = '" +value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;


            case 5://empAge
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[4]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                	sql+=" where "+emloyeeAttruArra[4] + " = '" +value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
            case 6://empEntryDate
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[5]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[5]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
            case 7://empWorkingYears
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[6]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[6]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
            case 8://empRemark
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[7]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[7]+" like '%"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 9://roleId
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[8]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[8]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 10://roleName
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[9]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[9] + " like '%" +value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 11://level
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[10]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[10]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
                
            case 12://monthPay
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[11]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[11]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 13://depId
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[12]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[12]+" ='"+value+"' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 14://depNo
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[13]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[13]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
            case 15://depName
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[14]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[14]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
            case 16://depManager
                if(isNum(value)){
                    sql+=" where "+emloyeeAttruArra[15]+" ="+ Integer.parseInt(value)+" limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }else {
                    sql+=" where "+emloyeeAttruArra[15]+" like '"+value+"%' limit "+(pageNo-1)*pageSize+" , "+pageSize;
                }
                break;
                
                
                
            case 17://条件组合查询
            	 if(isNum(value)){
                     sql+=" where "+
                    			emloyeeAttruArra[0]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[1]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[2]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[3]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[4]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[5]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[6]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[7]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[8]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[9]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[10]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[11]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[12]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[13]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[14]+" ="+ Integer.parseInt(value)+" or "+
                        		emloyeeAttruArra[15]+" ="+ Integer.parseInt(value)+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }else {
                     sql+=" where "+
                    		 emloyeeAttruArra[0] + " ='" +   value+"%' or "+
                    		 emloyeeAttruArra[1] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[2] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[3] + " = '" +value+"' or "+
                    		 emloyeeAttruArra[4] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[5] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[6] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[7] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[8] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[9] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[10] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[11] + " = '" +value+"' or "+
                    		 emloyeeAttruArra[12] + " ='" +value+"' or "+
                    		 emloyeeAttruArra[13] + " like '" +value+"%' or "+
                    		 emloyeeAttruArra[14] + " like '%" +value+"%' or "+
                    		 emloyeeAttruArra[15] + " like '" +value+"%'"+
                 " limit "+(pageNo-1)*pageSize+" , "+pageSize;
                 }
                break;

        }
    return sql;
    }
    
    
  
    

    //正则表达式判断是否是数字
    public static boolean isNum(String str){
        String regularExpression = "^\\+{0,1}[1-9]\\d*";
        Pattern p = Pattern.compile(regularExpression);
        Matcher m = p.matcher(str);
        if (str.length() == 0) {
            return false;
        } else {
            if (m.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }


}
