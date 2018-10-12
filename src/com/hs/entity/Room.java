package com.hs.entity;

public class Room {
    private Integer roomid;

    private String roomnumber;

    private Integer roomtypeid;

    private String roomtypename;

    private String roomintroduce;

    private Integer roomstatus;
    
    
    
    

    @Override
	public String toString() {
		return "Room [roomid=" + roomid + ", roomnumber=" + roomnumber + ", roomtypeid=" + roomtypeid
				+ ", roomtypename=" + roomtypename + ", roomintroduce=" + roomintroduce + ", roomstatus=" + roomstatus
				+ "]";
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(Integer roomid, String roomnumber, Integer roomtypeid, String roomtypename, String roomintroduce,
			Integer roomstatus) {
		super();
		this.roomid = roomid;
		this.roomnumber = roomnumber;
		this.roomtypeid = roomtypeid;
		this.roomtypename = roomtypename;
		this.roomintroduce = roomintroduce;
		this.roomstatus = roomstatus;
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

    public String getRoomintroduce() {
        return roomintroduce;
    }

    public void setRoomintroduce(String roomintroduce) {
        this.roomintroduce = roomintroduce == null ? null : roomintroduce.trim();
    }

    public Integer getRoomstatus() {
        return roomstatus;
    }

    public void setRoomstatus(Integer roomstatus) {
        this.roomstatus = roomstatus;
    }
}