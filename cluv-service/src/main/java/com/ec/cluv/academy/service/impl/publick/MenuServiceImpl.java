package com.ec.cluv.academy.service.impl.publick;


import com.ec.cluv.academy.model.dto.menu.ItemDTO;
import com.ec.cluv.academy.model.dto.publick.MenuDto;
import com.ec.cluv.academy.model.entities.publick.Menu;
import com.ec.cluv.academy.model.mappers.publick.MenuMapper;
import com.ec.cluv.academy.repository.publick.MenuRepository;
import com.ec.cluv.academy.service.service.publick.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Autowired
    private MenuMapper mapper;


    @Override
    public MenuDto create(MenuDto obj) {
        return mapper.toDto(repository.save(mapper.toEntity(obj)));
    }

    @Override
    public List<MenuDto> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public MenuDto findById(Integer id) {
        return mapper.toDto(repository.findById(id).isPresent() ? repository.findById(id).get() : null);
    }

    @Override
    public boolean delete(Integer id) {
        repository.deleteById(id);
        return repository.findById(id).isPresent();
    }


    @Override
    public List<MenuDto> findByUsername(String username) {
        List<Menu> listEntitie = (List<Menu>) repository.findByUsername(username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public List<MenuDto> findPadreByUsername(String username) {
        List<Menu> listEntitie = (List<Menu>) repository.findPadreByUsername(username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }

    @Override
    public List<MenuDto> findHijoByMenuPadreAndUsername(Integer menuPadre, String username) {
        List<Menu> listEntitie = (List<Menu>) repository.findHijoByMenuPadreAndUsername(menuPadre, username);
        List<MenuDto> listDto = mapper.toDto(listEntitie);
        return listDto;
    }


    public List<ItemDTO> construirArbolProfundidad(String username) {
        List<Menu> menusRaiz = repository.findMenuRaizByUsername(username);
        List<ItemDTO> menuModel = new ArrayList<>();
        return getItemDTOS(username, menusRaiz, menuModel);
    }

    private List<ItemDTO> getItemDTOS(String username, List<Menu> menusRaiz, List<ItemDTO> menuModel) {
        for (Menu menu : menusRaiz) {
            ItemDTO item = new ItemDTO();
            item.setLabel(menu.getNombre());
            item.setIcon(null); // icono desde bdd
            item.setUrl(menu.getUrl());
            item.setRouterLink(menu.getUrl()); // routerlink necesario para angular14
            item.setBadge(null); // badge no soportado en version 14 de angular

            List<ItemDTO> subItems = construirSubArbol(menu, username);
            item.setMenuList(subItems);

            menuModel.add(item);
        }
        return menuModel;
    }

    // Función recursiva para construir el sub-árbol
    private List<ItemDTO> construirSubArbol(Menu menuPadre, String username) {
        List<ItemDTO> subItems = new ArrayList<>();
        List<Menu> menusHijos = repository.findRecursiveHijoByMenuPadreAndUsername(menuPadre.getIdMenu(), username);
        return getItemDTOS(username, menusHijos, subItems);
    }


    @Override
    public List<ItemDTO> findMenuItems(String username) {
        //List<MenuDto> lstPadre = this.findPadreByUsername(username);


        List<ItemDTO> lst =construirArbolProfundidad(username);

/*
        for (MenuDto obj : lstPadre) {
            ItemMenuDTO menu = new ItemMenuDTO();
            ItemDTO item = new ItemDTO();
            item.setLabel(obj.getNombre());
            item.setIcon("fa fa-send");
            item.setBadge("");
            item.setRouterLink(obj.getUrl());

            List<MenuDto> lstHijo = this.findHijoByMenuPadreAndUsername(obj.getIdMenu(), username);
            List<ItemDTO> listItemHijo = new ArrayList<>();
            for (MenuDto objHijo : lstHijo) {
                ItemDTO itemHijo = new ItemDTO();
                itemHijo.setLabel(objHijo.getNombre());
                itemHijo.setIcon("pi pi-check");
                itemHijo.setBadge("");
                itemHijo.setRouterLink(objHijo.getUrl());
                listItemHijo.add(itemHijo);
            }

            menu.setItemDTO(item);
            if (lstHijo.size() > 0)
                menu.setItemsDTO(listItemHijo);

            lst.add(menu);


        }

*/
        return lst;
    }
}
