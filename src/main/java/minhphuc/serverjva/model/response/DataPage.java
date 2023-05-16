package minhphuc.serverjva.model.response;

import lombok.Data;

@Data
public class DataPage {
    private Integer total;

    private Integer current;

    private Object records;

    private Integer rows;
}
