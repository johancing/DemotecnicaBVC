package co.com.demobvc.infrastructure.util;

import java.util.Date;

public class AppInformation {

	public static final String BASE_URL = "/bvcdemo/api/v1/invoice";
	private static AppInformation aapInformation;
	private String fileName;
	private String uid;
	private Date creationdate;
	private String user;

	private AppInformation() {
	}

	public static AppInformation getInstance() {
		if (aapInformation == null)
			aapInformation = new AppInformation();
		return aapInformation;
	}

	public void reset() {
		fileName = null;
		uid = null;
		creationdate = null;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
