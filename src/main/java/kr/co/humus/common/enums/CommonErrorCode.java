package kr.co.humus.common.enums;

import kr.co.humus.common.exception.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorCode implements ErrorCode {
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "유효하지 않은 파라메터가 포함되어 있습니다."),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "데이터가 존재하지 않습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    EXTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "외부 호출 실패"),
    JSON_PARSING_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "json parsing 실패"),
    ;


    private final HttpStatus httpStatus;
    private final String message;

}
