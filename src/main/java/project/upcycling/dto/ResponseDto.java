package project.upcycling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto<T> {
    private int status;
    private T data;
}
