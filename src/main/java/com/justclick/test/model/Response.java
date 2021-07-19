package com.justclick.test.model;

import java.util.ArrayList;
import java.util.Objects;
/**
 * *********************************************************************************************************
 * Name: Request 
 * Description:response parameter
 * *********************************************************************************************************
 */
public class Response {
	private String redirect;
	private String writter;
	private ArrayList<ResponseHeader> responseHeader;
	private String encoding;
	private String locale;
	private int status;

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public String getWritter() {
		return writter;
	}

	public void setWritter(String writter) {
		this.writter = writter;
	}

	public ArrayList<ResponseHeader> getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ArrayList<ResponseHeader> responseHeader) {
		this.responseHeader = responseHeader;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Response response = (Response) o;
		return Objects.equals(this.redirect, response.redirect) && Objects.equals(this.writter, response.writter)
				&& Objects.equals(this.responseHeader, response.responseHeader)
				&& Objects.equals(this.encoding, response.encoding) && Objects.equals(this.locale, response.locale)
				&& Objects.equals(this.status, response.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(redirect, writter, responseHeader, encoding, locale, status);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("    redirect: ").append(toIndentedString(redirect)).append("\n");
		sb.append("    writter: ").append(toIndentedString(writter)).append("\n");
		sb.append("    responseHeader: ").append(toIndentedString(responseHeader)).append("\n");
		sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
		sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
