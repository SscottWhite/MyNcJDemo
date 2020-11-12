package com.example.DTO;

import java.util.List;


public class UserDTO {
	
	private String  userID;
	
	private Integer userAge;
	
	private List<String> userInfo;
	
	private String[] infoS;

	public UserDTO(String... strings ) {
		this.infoS = strings;
	}
	
	public String getUserID() {
		return userID;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public List<String> getUserInfo() {
		return userInfo;
	}
	public String[] getInfoS() {
		return infoS;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public void setUserInfo(List<String> userInfo) {
		this.userInfo = userInfo;
	}
	public void setInfoS(String[] infoS) {
		this.infoS = infoS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAge == null) ? 0 : userAge.hashCode());
		result = prime * result + ((userID == null) ? 0 : userID.hashCode());
		result = prime * result + ((userInfo == null) ? 0 : userInfo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (userAge == null) {
			if (other.userAge != null)
				return false;
		} else if (!userAge.equals(other.userAge))
			return false;
		if (userID == null) {
			if (other.userID != null)
				return false;
		} else if (!userID.equals(other.userID))
			return false;
		if (userInfo == null) {
			if (other.userInfo != null)
				return false;
		} else if (!userInfo.equals(other.userInfo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [userInfo=" + userInfo + "]";
	}

	
	
	
}
