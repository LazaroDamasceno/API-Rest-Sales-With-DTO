package com.apirestsaleswithdto.dtos;

import com.apirestsaleswithdto.models.SaleModel;

import java.util.List;
import java.util.stream.Collectors;

public class DtoMapper {

    public static List<SaleDTO> convertAll(List<SaleModel> all) {
        return all.stream().map(SaleDTO::new).collect(Collectors.toList());
    }

}
