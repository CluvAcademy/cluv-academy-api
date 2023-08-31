package com.ec.cluv.academy.model.dto.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeNodeDto<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    private String label;
    private T data;
    private String icon;
    private Object expandedIcon;
    private Object collapsedIcon;
    private List<TreeNodeDto<T>> children;
    private Boolean leaf = null;
    private Boolean expanded = null;
    private String type;
    private TreeNodeDto<T> parent;
    private Boolean partialSelected = null;
    private String style;
    private String styleClass;
    private Boolean draggable = null;
    private Boolean droppable = null;
    private Boolean selectable = null;
    private String key;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Object getExpandedIcon() {
        return expandedIcon;
    }

    public void setExpandedIcon(Object expandedIcon) {
        this.expandedIcon = expandedIcon;
    }

    public Object getCollapsedIcon() {
        return collapsedIcon;
    }

    public void setCollapsedIcon(Object collapsedIcon) {
        this.collapsedIcon = collapsedIcon;
    }

    public List<TreeNodeDto<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeDto<T>> children) {
        this.children = children;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TreeNodeDto<T> getParent() {
        return parent;
    }

    public void setParent(TreeNodeDto<T> parent) {
        this.parent = parent;
    }

    public Boolean getPartialSelected() {
        return partialSelected;
    }

    public void setPartialSelected(Boolean partialSelected) {
        this.partialSelected = partialSelected;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    public Boolean getDraggable() {
        return draggable;
    }

    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    public Boolean getDroppable() {
        return droppable;
    }

    public void setDroppable(Boolean droppable) {
        this.droppable = droppable;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}