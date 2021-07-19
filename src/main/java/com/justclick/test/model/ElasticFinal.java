package com.justclick.test.model;
/**
 * *********************************************************************************************************
 * Name: ElasticFinal 
 * Description:ElasticSearch index model
 * *********************************************************************************************************
 */
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
@Document(indexName = "web_info")
public class ElasticFinal {
	@Id
	private String id ;
	private Request request;
	private Response response;
	private Header header;
	private UserAgent userAgent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public UserAgent getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(UserAgent userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ElasticFinal requestSolicitud = (ElasticFinal) o;
		return Objects.equals(this.id, requestSolicitud.id) && Objects.equals(this.request, requestSolicitud.request)
				&& Objects.equals(this.response, requestSolicitud.response)
				&& Objects.equals(this.header, requestSolicitud.header)
				&& Objects.equals(this.userAgent, requestSolicitud.userAgent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, request, response, header, userAgent);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ElasticFinal {\n");
		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    request: ").append(toIndentedString(request)).append("\n");
		sb.append("    response: ").append(toIndentedString(response)).append("\n");
		sb.append("    header: ").append(toIndentedString(header)).append("\n");
		sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
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
