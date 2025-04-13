package com.tripit.tripit_backend.common.exception;

import com.tripit.tripit_backend.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Object>> handleCustomException(CustomException e) {
        return ResponseEntity.badRequest()
            .body(ApiResponse.fail(e.getErrorCode().getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
        MethodArgumentNotValidException e) {
        String errorMessage = e.getBindingResult().getAllErrors().stream()
            .findFirst() // 첫 번째 오류만 추출 (여러 개 중 선택)
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .orElse("유효성 검사에 실패했습니다.");

        return ResponseEntity.badRequest()
            .body(ApiResponse.fail(errorMessage));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(Exception e) {
        log.error("서버 오류 {}", e.getMessage());
        return ResponseEntity.internalServerError()
            .body(ApiResponse.fail("서버 내부 오류가 발생했습니다."));
    }

}
