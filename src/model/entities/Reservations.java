package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exception.DomainException;

public class Reservations {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservations(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior à data de check-in");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
	   long diff = checkOut.getTime() - checkIn.getTime();
	   return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) throws DomainException {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas reservas devem ser futuras");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Check-Out deve ser depois do Check-In encontrado");
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	    return null;
	}
	
	@Override
	public String toString() {
		return "Room "
		+ roomNumber
		+ ", check-in: "
		+ sdf.format(checkIn)
		+ ", check-Out: "
		+ sdf.format(checkOut)
		+ ", "
		+  duration()
		+ " nights";
		
	}
}
