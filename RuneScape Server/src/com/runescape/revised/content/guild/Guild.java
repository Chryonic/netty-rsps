package com.runescape.revised.content.guild;

import com.runescape.revised.MemberType;
import com.runescape.revised.content.location.LocationType;

public class Guild {

	private String guildName;
	private Object[] requirements;
	private LocationType locationType;
	private MemberType memberType;
	
	public Guild(String guildName, Object[] requirements, LocationType locationType, MemberType memberType) {
		this.setGuildName(guildName);
		this.setRequirements(requirements);
		this.setLocationType(locationType);
		this.setMemberType(memberType);
	}
	
	public void setGuildName(String guildName) {
		this.guildName = guildName;
	}
	
	public String getGuildName() {
		return guildName;
	}
	
	public void setRequirements(Object[] requirements) {
		this.requirements = requirements;
	}
	
	public Object[] getRequirements() {
		return requirements;
	}
	
	public void setLocationType(LocationType locationType) {
		this.locationType = locationType;
	}
	
	public LocationType getLocationType() {
		return locationType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	public MemberType getMemberType() {
		return memberType;
	}
}