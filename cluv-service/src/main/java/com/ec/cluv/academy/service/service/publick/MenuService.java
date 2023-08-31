package com.ec.cluv.academy.service.service.publick;

import com.ec.cluv.academy.model.dto.menu.ItemDTO;
import com.ec.cluv.academy.model.dto.publick.MenuDto;
import com.ec.cluv.academy.service.GenericService;

import java.util.List;

/**
 * Definine las operaciones disponibles en el servicio transacciones auditoria
 */
public interface MenuService extends GenericService<MenuDto, Integer> {
    List<MenuDto> findByUsername(String username);

    List<MenuDto> findPadreByUsername(String username);

    List<MenuDto> findHijoByMenuPadreAndUsername(Integer menuPadre, String username);

    List<ItemDTO> findMenuItems(String username);
}
