package model;


import java.io.Serializable;
import java.util.ArrayList;

public class menuFirst implements Serializable {
    private String name;
    private ArrayList<menuSecond> menuList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<menuSecond> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<menuSecond> menuList) {
        this.menuList = menuList;
    }

}

