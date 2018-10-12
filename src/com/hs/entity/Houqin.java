package com.hs.entity;

public class Houqin {
    private String empnumber;

    private Integer roomid;

    private String roomnumber;

    private String roomtypename;

    private String staercleantime;

    private String endcleantime;

    @Override
	public String toString() {
		return "Houqin [empnumber=" + empnumber + ", roomid=" + roomid + ", roomnumber=" + roomnumber
				+ ", roomtypename=" + roomtypename + ", staercleantime=" + staercleantime + ", endcleantime="
				+ endcleantime + "]";
	}

	public Houqin(String empnumber, Integer roomid, String roomnumber, String roomtypename, String staercleantime,
			String endcleantime) {
		super();
		this.empnumber = empnumber;
		this.roomid = roomid;
		this.roomnumber = roomnumber;
		this.roomtypename = roomtypename;
		this.staercleantime = staercleantime;
		this.endcleantime = endcleantime;
	}

	public Houqin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpnumber() {
        return empnumber;
    }

    public void setEmpnumber(String empnumber) {
        this.empnumber = empnumber == null ? null : empnumber.trim();
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber == null ? null : roomnumber.trim();
    }

    public String getRoomtypename() {
        return roomtypename;
    }

    public void setRoomtypename(String roomtypename) {
        this.roomtypename = roomtypename == null ? null : roomtypename.trim();
    }

    public String getStaercleantime() {
        return staercleantime;
    }

    public void setStaercleantime(String staercleantime) {
        this.staercleantime = staercleantime == null ? null : staercleantime.trim();
    }

    public String getEndcleantime() {
        return endcleantime;
    }

    public void setEndcleantime(String endcleantime) {
        this.endcleantime = endcleantime == null ? null : endcleantime.trim();
    }
}