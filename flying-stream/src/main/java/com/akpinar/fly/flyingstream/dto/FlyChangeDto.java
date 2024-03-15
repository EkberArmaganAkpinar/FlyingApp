package com.akpinar.fly.flyingstream.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
public class FlyChangeDto implements Serializable{
    private Long id;
    private Long planeId;
    private String status;
    private List<String> route;
}
