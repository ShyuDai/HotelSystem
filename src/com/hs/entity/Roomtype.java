package com.hs.entity;

public class Roomtype {
	
    private Integer roomtypeid;

    private String roomtypename;

    private String roomtypeintroduce;

    private Integer roomtypeprice;

    
    
    
    
    
    
    @Override
	public String toString() {
		return "Roomtype [roomtypeid=" + roomtypeid + ", roomtypename=" + roomtypename + ", roomtypeintroduce="
				+ roomtypeintroduce + ", roomtypeprice=" + roomtypeprice + "]";
	}

	public Roomtype() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roomtype(Integer roomtypeid, String roomtypename, String roomtypeintroduce, Integer roomtypeprice) {
		super();
		this.roomtypeid = roomtypeid;
		this.roomtypename = roomtypename;
		this.roomtypeintroduce = roomtypeintroduce;
		this.roomtypeprice = roomtypeprice;
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

    public String getRoomtypeintroduce() {
        return roomtypeintroduce;
    }

    public void setRoomtypeintroduce(String roomtypeintroduce) {
        this.roomtypeintroduce = roomtypeintroduce == null ? null : roomtypeintroduce.trim();
    }

    public Integer getRoomtypeprice() {
        return roomtypeprice;
    }

    public void setRoomtypeprice(Integer roomtypeprice) {
        this.roomtypeprice = roomtypeprice;
    }
}