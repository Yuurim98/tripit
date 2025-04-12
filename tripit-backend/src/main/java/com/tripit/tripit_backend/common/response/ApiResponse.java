package com.tripit.tripit_backend.common.response;

import lombok.Getter;

@Getter
public class ApiResponse<T> {

    private boolean success;   // 성공 여부
    private T data;            // 실제 응답 데이터
    private String message;    // 성공/실패 메시지

    public ApiResponse(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, null, message);
    }
}
