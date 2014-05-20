package com.nickforum.controller;

public class RestConstants {
	public static final String DUMMY_USER = "/rest/user/dummy";
	public static final String GET_USER = "/rest/user/{id}";
	public static final String GET_ALL_USER = "/rest/users";
	public static final String CREATE_USER = "/rest/user/create";
	public static final String DELETE_USER = "/rest/user/delete/{id}";

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
