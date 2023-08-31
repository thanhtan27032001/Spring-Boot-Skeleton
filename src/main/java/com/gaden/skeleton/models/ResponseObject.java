package com.gaden.skeleton.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
