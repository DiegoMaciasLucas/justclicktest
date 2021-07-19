package com.justclick.test.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * *********************************************************************************************************
 * Name: ResponseHeader 
 * Description:response header parameter
 * *********************************************************************************************************
 */
public class ResponseHeader {
	@JsonProperty("Set-Cookie")
	public String setCookie;

	public String getSetCookie() {
		return setCookie;
	}

	public void setSetCookie(String setCookie) {
		this.setCookie = setCookie;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResponseHeader responseHeader = (ResponseHeader) o;
		return Objects.equals(this.setCookie, responseHeader.setCookie);
	}

	@Override
	public int hashCode() {
		return Objects.hash(setCookie);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("    setCookie: ").append(toIndentedString(setCookie)).append("\n");
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
