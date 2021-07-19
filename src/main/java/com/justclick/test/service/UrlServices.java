package com.justclick.test.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.justclick.test.model.ElasticFinal;
import com.justclick.test.model.ElasticRequest;
import com.justclick.test.model.Url;
import com.justclick.test.model.UserAgent;
import com.justclick.test.repository.UrlElasticRepository;
import com.justclick.test.repository.UrlRepository;

@Service
public class UrlServices {
	public static final String FILE = "/opt/clicks.json";
	String unknownData = "Unknown";
	@Autowired
	private UrlRepository repository;

	@Autowired
	private UrlElasticRepository urlElasticRepository;

	public Url findByName(String name) {
		return repository.findByName(name);
	}
	/**
	 * *********************************************************************************************************
	 * Name: loggerRequest 
	 * Description:Obtain data in the http request and write in a clicks.json file
	 * *********************************************************************************************************
	 */
	public void loggerRequest(HttpHeaders headers, HttpServletResponse response, String uri, String string) {

		try {

			JSONObject finalLog = new JSONObject();
			JSONObject requestObject = new JSONObject();
			requestObject.put("string", validarRequest(string));
			JSONObject responseObject = new JSONObject();
			responseObject.put("redirect", uri);
			responseObject.put("status", response.getStatus());
			JSONArray responseheaderlist = new JSONArray();
			for (String filename : response.getHeaderNames()) {
				JSONObject header = new JSONObject();
				header.put(filename, response.getHeader(filename));
				responseheaderlist.put(header);

			}
			responseObject.put("responseHeader", responseheaderlist);
			responseObject.put("encoding", response.getCharacterEncoding());
			responseObject.put("content-type", response.getContentType());
			responseObject.put("trailerFields", response.getTrailerFields());
			responseObject.put("locale", response.getLocale());
			responseObject.put("writter", response.getWriter());
			JSONObject headerObject = new JSONObject(headers);
			String headerJson = headerObject.toString().replace("[", "").replace("]", "");
			JSONObject headerObjectFinal = new JSONObject(headerJson);
			finalLog.put("header", headerObjectFinal);
			finalLog.put("request", requestObject);
			finalLog.put("response", responseObject);
			System.out.println(finalLog);
			String content;
			ArrayList<String> contentList = new ArrayList<>();
			int count = 0;
			try (FileReader readFile = new FileReader(FILE)) {
				BufferedReader br = new BufferedReader(readFile);

				while ((content = br.readLine()) != null) {
					contentList.add(content);
					count++;
				}
			}
			try (FileWriter file = new FileWriter(FILE)) {
				if (count == 0) {
					file.write(finalLog.toString());
				} else {
					for (String a : contentList) {
						file.write(a + "\n");
					}
					file.write(finalLog.toString());
				}
				file.flush();
			}

		} catch (Exception e) {
			System.out.println("Error:{}" + e.getMessage());
		}

	}
	/**
	 * *********************************************************************************************************
	 * Name: elasticProgram 
	 * Description:A scheduled job that save data in the index of elastic search instance by reading clicks.json file
	 * *********************************************************************************************************
	 */
	@Scheduled(cron="0 0 * * * *", zone="America/Guayaquil")
	public void elasticProgram() {
		Gson gson = new Gson();
		
		try {
			Thread.sleep(300000);
			System.out.println("inicio tareaprogramada");
			urlElasticRepository.deleteAll();
			ArrayList<String> contentList = new ArrayList<>();
			try (FileReader readFile = new FileReader(FILE)) {
				BufferedReader br = new BufferedReader(readFile);
				String content;
				while ((content = br.readLine()) != null) {
					contentList.add(content);
				}
			}
			for (String a : contentList) {
				ElasticRequest elasticRequest = gson.fromJson(a, ElasticRequest.class);
				UserAgent userAgent = getUserAgent(elasticRequest.getHeader().getUserAgent());
				ElasticFinal elasticFinal = new ElasticFinal();
				elasticFinal.setId(UUID.randomUUID().toString());
				elasticFinal.setHeader(elasticRequest.getHeader());
				elasticFinal.setRequest(elasticRequest.getRequest());
				elasticFinal.setResponse(elasticRequest.getResponse());
				elasticFinal.setUserAgent(userAgent);
				urlElasticRepository.save(elasticFinal);
				System.out.println("ejecucion tareaprogramada:" + elasticFinal.toString());
			}

		} catch (Exception e) {

			System.out.println("Error:{}" + e.getMessage());
		}

	}
	/**
	 * *********************************************************************************************************
	 * Name: getUserAgent 
	 * Description:Get the data of a userAgent Web header
	 * *********************************************************************************************************
	 */
	public UserAgent getUserAgent(String userAgent) {
		String osType = unknownData;
		String osVersion = unknownData;
		String browserType = unknownData;
		String browserVersion = unknownData;
		String deviceType = unknownData;
		UserAgent userAgentNew = new UserAgent();
		try {
			if (userAgent.contains("Edge/")) {
				browserType = "Edge";
				browserVersion = userAgent.substring(userAgent.indexOf("Edge")).split("/")[1];

			} else if (userAgent.contains("Safari/") && userAgent.contains("Version/")) {
				browserType = "Safari";
				browserVersion = userAgent.substring(userAgent.indexOf("Version/") + 8).split(" ")[0];

			} else if (userAgent.contains("OPR/") || userAgent.contains("Opera/")) {
				browserType = "Opera";
				browserVersion = userAgent.substring(userAgent.indexOf("OPR")).split("/")[1];

			} else if (userAgent.contains("Chrome/")) {
				browserType = "Chrome";
				browserVersion = userAgent.substring(userAgent.indexOf("Chrome")).split("/")[1];
				browserVersion = browserVersion.split(" ")[0];

			} else if (userAgent.contains("Firefox/")) {
				browserType = "Firefox";
				browserVersion = userAgent.substring(userAgent.indexOf("Firefox")).split("/")[1];
			}
			if (userAgent.indexOf("Windows NT") >= 0) {
				osType = "Windows";
				osVersion = userAgent.substring(userAgent.indexOf("Windows NT ") + 11, userAgent.indexOf(";"));

			} else if (userAgent.indexOf("Mac OS") >= 0) {
				osType = "Mac";
				osVersion = userAgent.substring(userAgent.indexOf("Mac OS ") + 7, userAgent.indexOf(")"));

				if (userAgent.indexOf("iPhone") >= 0) {
					deviceType = "iPhone";
				} else if (userAgent.indexOf("iPad") >= 0) {
					deviceType = "iPad";
				}

			} else if (userAgent.indexOf("X11") >= 0) {
				osType = "Unix";
				osVersion = "Unknown";

			}
			userAgentNew.setOsType(osType);
			userAgentNew.setOsVersion(osVersion);
			userAgentNew.setBrowserType(browserType);
			userAgentNew.setBrowserVersion(browserVersion);
			userAgentNew.setDeviceType(deviceType);
		} catch (Exception e) {
			System.out.println("Error:{}" + e.getMessage());
		}

		return userAgentNew;
	}

	private String validarRequest(String string) {
		String result = "";
		if (string.isEmpty()) {
			result = "";
		} else {
			result = string;
		}
		return result;
	}
}
