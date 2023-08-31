package com.ec.cluv.academy.model.dto.menu;

import lombok.Data;

import java.util.List;

@Data
public class ItemDTO {

    private String label;
    private String icon;
    private String url;
    private String routerLink;
    private String badge;

    List<ItemDTO> menuList;

}
