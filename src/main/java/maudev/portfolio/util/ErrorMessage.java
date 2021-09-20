package maudev.portfolio.util;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ErrorMessage {
    
    private String codeError;
    private List<Map<String , String>> messages;
}
