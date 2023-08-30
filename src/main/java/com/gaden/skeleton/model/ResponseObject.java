package com.gaden.skeleton.model;

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
