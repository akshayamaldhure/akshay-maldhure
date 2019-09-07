package models.common;

import lombok.Getter;

/**
 * Response to a failing HTTP request to any of the entity API calls
 */
@Getter
public class ErrorResponse {
    private String name;
    private String message;
    private int code;
    private String className;
    private Object errors;
}
