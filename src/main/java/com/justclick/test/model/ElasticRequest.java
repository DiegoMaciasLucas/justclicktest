package com.justclick.test.model;
/**
 * *********************************************************************************************************
 * Name: ElasticRequest 
 * Description:clicks.json file model
 * *********************************************************************************************************
 */
public class ElasticRequest {

	private Request request;
	private Response response;
	private Header header;

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

}
