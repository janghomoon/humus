package kr.co.humus.common.exception;

import kr.co.humus.common.exception.code.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class HumusException extends RuntimeException {

    private final ErrorCode errorCode;

}
