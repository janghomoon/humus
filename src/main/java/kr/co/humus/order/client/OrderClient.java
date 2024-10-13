package kr.co.humus.order.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import kr.co.humus.common.enums.CommonErrorCode;
import kr.co.humus.common.exception.HumusException;
import kr.co.humus.order.common.configuration.ExternalConfiguration;
import kr.co.humus.order.dto.request.ExternalOrderSaveRequest;
import kr.co.humus.order.dto.response.ExternalOrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class OrderClient {

    private final RestTemplate restTemplate;
    private final ExternalConfiguration externalConfiguration;
    private final ObjectMapper objectMapper;
    //todo 요구사항 상 주소 관련된 정보가 없어 임의 주소 및 요청/응답 객체로 구현

    public ExternalOrderResponse getExternalOrderList() {
        String url = externalConfiguration.getOrderUrl();
        HttpHeaders headers = generateHeaders();
        ResponseEntity<String> responseEntity = restTemplate.exchange(encodeUrl(url),
                HttpMethod.GET, new RequestEntity<>(headers, HttpMethod.GET, encodeUrl(url)), String.class);
        if (!isSuccess(responseEntity.getStatusCode())) throw new HumusException(CommonErrorCode.EXTERNAL_SERVER_ERROR);
        return StringToDto(responseEntity.getBody(), ExternalOrderResponse.class);
    }
    public void sendExternalOrderList(ExternalOrderSaveRequest request) {
        String url = externalConfiguration.getSendOrderUrl();
        HttpHeaders headers = generateHeaders();
        ResponseEntity<String> responseEntity = restTemplate.exchange(encodeUrl(url),
                HttpMethod.POST, new RequestEntity<>(request, headers, HttpMethod.POST, encodeUrl(url)), String.class);
        if (!isSuccess(responseEntity.getStatusCode())) throw new HumusException(CommonErrorCode.EXTERNAL_SERVER_ERROR);
    }

    //수정
    private  <T> T StringToDto(String responseBody, Class<T> responseType) {
        try {
            return objectMapper.readValue(responseBody, responseType);
        } catch (JsonProcessingException e) {
            throw new HumusException(CommonErrorCode.JSON_PARSING_ERROR);
        }
    }

    //주문 보내기 post
    private HttpHeaders generateHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
    private URI encodeUrl(String url) {
        String encodeUrl = url.contains("+") ? url.replace("+", "%2B") : url;
        encodeUrl = encodeUrl.contains(" ") ? encodeUrl.replace(" ", "%20") : encodeUrl;
        return UriComponentsBuilder.fromHttpUrl(encodeUrl)
                .build(true)
                .encode()
                .toUri();
    }

    private boolean isSuccess(HttpStatusCode status) {
        if (status.equals(HttpStatus.OK)) {
            return true;
        }
        if (status.equals(HttpStatus.CREATED)) {
            return true;
        }
        if (status.equals(HttpStatus.ACCEPTED)) {
            return true;
        }
        return false;
    }
}
