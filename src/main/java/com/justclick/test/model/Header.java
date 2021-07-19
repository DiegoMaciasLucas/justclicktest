package com.justclick.test.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * *********************************************************************************************************
 * Name: Header 
 * Description:header parameter
 * *********************************************************************************************************
 */
public class Header {
	@JsonProperty("sec-fetch-mode")
	private String secFetchMode;
	@JsonProperty("sec-fetch-site")
	private String secFetchSite;
	@JsonProperty("accept-language")
	private String acceptLanguage;
	@JsonProperty("sec-fetch-user")
	private String secFetchUser;
	private String accept;
	@JsonProperty("sec-ch-ua")
	private String secChUa;
	@JsonProperty("sec-ch-ua-mobile")
	private String secChUaMobile;
	private String host;
	@JsonProperty("upgrade-insecure-requests")
	private String upgradeInsecureRequests;
	private String connection;
	@JsonProperty("accept-encoding")
	private String acceptEncoding;
	@JsonProperty("user-agent")
	private String userAgent;
	@JsonProperty("sec-fetch-dest")
	private String secFetchDest;

	public String getSecFetchMode() {
		return secFetchMode;
	}

	public void setSecFetchMode(String secFetchMode) {
		this.secFetchMode = secFetchMode;
	}

	public String getSecFetchSite() {
		return secFetchSite;
	}

	public void setSecFetchSite(String secFetchSite) {
		this.secFetchSite = secFetchSite;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getSecFetchUser() {
		return secFetchUser;
	}

	public void setSecFetchUser(String secFetchUser) {
		this.secFetchUser = secFetchUser;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getSecChUa() {
		return secChUa;
	}

	public void setSecChUa(String secChUa) {
		this.secChUa = secChUa;
	}

	public String getSecChUaMobile() {
		return secChUaMobile;
	}

	public void setSecChUaMobile(String secChUaMobile) {
		this.secChUaMobile = secChUaMobile;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUpgradeInsecureRequests() {
		return upgradeInsecureRequests;
	}

	public void setUpgradeInsecureRequests(String upgradeInsecureRequests) {
		this.upgradeInsecureRequests = upgradeInsecureRequests;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSecFetchDest() {
		return secFetchDest;
	}

	public void setSecFetchDest(String secFetchDest) {
		this.secFetchDest = secFetchDest;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Header requestHeader = (Header) o;
		return Objects.equals(this.secFetchMode, requestHeader.secFetchMode)
				&& Objects.equals(this.secFetchSite, requestHeader.secFetchSite)
				&& Objects.equals(this.acceptLanguage, requestHeader.acceptLanguage)
				&& Objects.equals(this.secFetchUser, requestHeader.secFetchUser)
				&& Objects.equals(this.accept, requestHeader.accept)
				&& Objects.equals(this.secChUa, requestHeader.secChUa)
				&& Objects.equals(this.secChUaMobile, requestHeader.secChUaMobile)
				&& Objects.equals(this.host, requestHeader.host)
				&& Objects.equals(this.upgradeInsecureRequests, requestHeader.upgradeInsecureRequests)
				&& Objects.equals(this.connection, requestHeader.connection)
				&& Objects.equals(this.acceptEncoding, requestHeader.acceptEncoding)
				&& Objects.equals(this.userAgent, requestHeader.userAgent)
				&& Objects.equals(this.secFetchDest, requestHeader.secFetchDest);
	}

	@Override
	public int hashCode() {
		return Objects.hash(secFetchMode, secFetchSite, acceptLanguage, secFetchUser, accept, secChUa, secChUaMobile,
				host, upgradeInsecureRequests, connection, acceptEncoding, userAgent, secFetchDest);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n");
		sb.append("    secFetchMode: ").append(toIndentedString(secFetchMode)).append("\n");
		sb.append("    secFetchSite: ").append(toIndentedString(secFetchSite)).append("\n");
		sb.append("    acceptLanguage: ").append(toIndentedString(acceptLanguage)).append("\n");
		sb.append("    secFetchUser: ").append(toIndentedString(secFetchUser)).append("\n");
		sb.append("    accept: ").append(toIndentedString(accept)).append("\n");
		sb.append("    secChUa: ").append(toIndentedString(secChUa)).append("\n");
		sb.append("    secChUaMobile: ").append(toIndentedString(secChUaMobile)).append("\n");
		sb.append("    host: ").append(toIndentedString(host)).append("\n");
		sb.append("    upgradeInsecureRequests: ").append(toIndentedString(upgradeInsecureRequests)).append("\n");
		sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
		sb.append("    acceptEncoding: ").append(toIndentedString(acceptEncoding)).append("\n");
		sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
		sb.append("    secFetchDest: ").append(toIndentedString(secFetchDest)).append("\n");
		;
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
