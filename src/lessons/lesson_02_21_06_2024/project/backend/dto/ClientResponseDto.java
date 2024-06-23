package lessons.lesson_02_21_06_2024.project.backend.dto;

public class ClientResponseDto<T> {
    private int responseCode;
    private T responseInfo;
    private String message;

    public ClientResponseDto(int responseCode, T responseInfo, String message) {
        this.responseCode = responseCode;
        this.responseInfo = responseInfo;
        this.message = message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseInfo() {
        return responseInfo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ClientResponseDto{" +
                "responseCode=" + responseCode +
                ", responseInfo=" + responseInfo +
                ", message='" + message + '\'' +
                '}';
    }
}
