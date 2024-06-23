package lessons.lesson_02_21_06_2024.project.backend.dto;

import java.util.List;

public class ClientResponseDto<T> {
    private Integer responseCode;
    private T responseInfo;
    private List<String> errors;

    public ClientResponseDto(Integer responseCode, T responseInfo, List<String> errors) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.errors = errors;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ClientResponseDto{" +
                "responseCode=" + responseCode +
                ", responseInfo=" + responseInfo +
                ", errors=" + errors +
                '}';
    }
}

