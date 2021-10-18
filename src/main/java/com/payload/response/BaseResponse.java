package com.payload.response;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
@Data
public class BaseResponse {
	int status;
	@Nullable
	private final Object data;
	private String message;
	private BaseResponse(@Nullable Object data, int status, String message){
		this.data = data;
		this.status = status;
		this.message = message;
	}
	public static BaseResponse success(Object data){
		return new BaseResponse(data, HttpStatus.OK.value(),null);
	}
	public static BaseResponse failure(int status){
		switch (status){
			case 400:
				return new BaseResponse(null, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
			case 401:
				return new BaseResponse(null, HttpStatus.BAD_REQUEST.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
			default:
				return new BaseResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
	}
}
