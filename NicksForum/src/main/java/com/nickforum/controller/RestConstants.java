package com.nickforum.controller;

public class RestConstants {
	
	public static final String AUTH_USER = "/rest/user/auth";
	
	public static final String DUMMY_USER = "/rest/user/dummy";
	public static final String GET_USER = "/rest/user/{id}";
	public static final String GET_USER_BY_EMAIL = "/rest/protected/user/email/{authString}";
	public static final String GET_ALL_USER = "/rest/protected/users/{authString}";
	public static final String CREATE_USER = "/rest/user/create";
	public static final String DELETE_USER = "/rest/protected/user/delete/{id}/{authString}";

	public static final String DUMMY_TOPIC = "/rest/topic/dummy";
	public static final String GET_TOPIC = "/rest/topic/{id}";
	public static final String GET_ALL_TOPIC = "/rest/topics";
	public static final String CREATE_TOPIC = "/rest/topic/create";
	public static final String DELETE_TOPIC = "/rest/topic/delete/{id}";

	public static final String DUMMY_REPLY = "/rest/reply/dummy";
	public static final String GET_REPLY = "/rest/reply/{id}";
	public static final String GET_ALL_REPLY = "/rest/replies";
	public static final String CREATE_REPLY = "/rest/reply/create";
	public static final String DELETE_REPLY = "/rest/reply/delete/{id}";
}
