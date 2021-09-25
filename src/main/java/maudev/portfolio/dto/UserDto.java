package maudev.portfolio.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable{
    

    private Long id;
    private String name;
    private String token;
}
