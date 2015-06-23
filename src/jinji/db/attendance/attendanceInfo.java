package jinji.db.attendance;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class attendanceInfo implements Serializable {
	private String staff_id;
	private Date date;
	private Time time_in;
	private Time time_out;
	/**
	 * 出退勤をデータを扱う
	 * @param staff_id
	 * @param date
	 * @param time_in
	 * @param time_out
	 */
	public attendanceInfo(String staff_id, Date date, Time time_in,
			Time time_out) {
		super();
		this.staff_id = staff_id;
		this.date = date;
		this.time_in = time_in;
		this.time_out = time_out;
	}

	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime_in() {
		return time_in;
	}

	public void setTime_in(Time time_in) {
		this.time_in = time_in;
	}

	public Time getTime_out() {
		return time_out;
	}

	public void setTime_out(Time time_out) {
		this.time_out = time_out;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("attendanceInfo [staff_id=");
		builder.append(staff_id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", time_in=");
		builder.append(time_in);
		builder.append(", time_out=");
		builder.append(time_out);
		builder.append("]");
		return builder.toString();
	}


}
