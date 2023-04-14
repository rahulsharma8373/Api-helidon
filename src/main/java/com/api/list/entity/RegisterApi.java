package com.api.list.entity;

import javax.persistence.Entity;

import lombok.Data;
@Entity
@Data
public class RegisterApi   {
		private String urlId;
		private String request;
		private String response;
		private int module;
		private int operation;
		private int tags;
		private String secretKey;
		private int methodType;
		private int inputType;
		private int outputType;		
		
}
