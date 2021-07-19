package com.justclick.test.model;

import java.util.Objects;
/**
 * *********************************************************************************************************
 * Name: Request 
 * Description:request parameter
 * *********************************************************************************************************
 */
public class Request {
	private String string;

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Request requestSolicitud = (Request) o;
		return Objects.equals(this.string, requestSolicitud.string);
	}

	@Override
	public int hashCode() {
		return Objects.hash(string);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("    string: ").append(toIndentedString(string)).append("\n");
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
