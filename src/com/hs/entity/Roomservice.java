package com.hs.entity;

public class Roomservice {
    private Integer id;

    private String name;

    private String roomnumber;

    private Integer roomtypeid;

    private String roomtypename;

    private String servicename;

    private Integer servicetotalprice;

    private String servicetime;

    private String empnumber;

    @Override
	public String toString() {
		return "Roomservice [id=" + id + ", name=" + name + ", roomnumber=" + roomnumber + ", roomtypeid=" + roomtypeid
				+ ", roomtypename=" + roomtypename + ", servicename=" + servicename + ", servicetotalprice="
				+ servicetotalprice + ", servicetime=" + servicetime + ", empnumber=" + empnumber + "]";
	}

	public Roomservice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roomservice(Integer id, String name, String roomnumber, Integer roomtypeid, String roomtypename,
			String servicename, Integer servicetotalprice, String servicetime, String empnumber) {
		super();
		this.id = id;
		this.name = name;
		this.roomnumber = roomnumber;
		this.roomtypeid = roomtypeid;
		this.roomtypename = roomtypename;
		this.servicename = servicename;
		this.servicetotalprice = servicetotalprice;
		this.servicetime = servicetime;
		this.empnumber = empnumber;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber == null ? null : roomnumber.trim();
    }

    public Integer getRoomtypeid() {
        return roomtypeid;
    }

    public void setRoomtypeid(Integer roomtypeid) {
        this.roomtypeid = roomtypeid;
    }

    public String getRoomtypename() {
        return roomtypename;
    }

    public void setRoomtypename(String roomtypename) {
        this.roomtypename = roomtypename == null ? null : roomtypename.trim();
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }

    public Integer getServicetotalprice() {
        return servicetotalprice;
    }

    public void setServicetotalprice(Integer servicetotalprice) {
        this.servicetotalprice = servicetotalprice;
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime == null ? null : servicetime.trim();
    }

    public String getEmpnumber() {
        return empnumber;
    }

    public void setEmpnumber(String empnumber) {
        this.empnumber = empnumber == null ? null : empnumber.trim();
    }
}