package com.justclick.test.model;

import java.util.Objects;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
/**
 * *********************************************************************************************************
 * Name: UserAgent 
 * Description:UserAgent model thah obtain browser and device information
 * *********************************************************************************************************
 */
@Document(indexName = "user_agent")
public class UserAgent {

	@Id
	private String id;
	private String osType;
	private String osVersion;
	private String browserType;
	private String browserVersion;
	private String deviceType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserAgent responseUserAgent = (UserAgent) o;
		return Objects.equals(this.id, responseUserAgent.id) && Objects.equals(this.osType, responseUserAgent.osType)
				&& Objects.equals(this.osVersion, responseUserAgent.osVersion)
				&& Objects.equals(this.browserType, responseUserAgent.browserType)
				&& Objects.equals(this.browserVersion, responseUserAgent.browserVersion)
				&& Objects.equals(this.deviceType, responseUserAgent.deviceType);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, osType, osVersion, browserType, browserVersion, deviceType);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    osType: ").append(toIndentedString(osType)).append("\n");
		sb.append("    osVersion: ").append(toIndentedString(osVersion)).append("\n");
		sb.append("    browserType: ").append(toIndentedString(browserType)).append("\n");
		sb.append("    browserVersion: ").append(toIndentedString(browserVersion)).append("\n");
		sb.append("    deviceType: ").append(toIndentedString(deviceType)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	private static String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
