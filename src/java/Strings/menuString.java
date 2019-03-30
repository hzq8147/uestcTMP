package Strings;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import model.menuFirst;
import model.menuSecond;

import java.util.ArrayList;

public class menuString {
    private static ArrayList<menuFirst> menu;

    public static void main(String argc[]) {

        String string=getMenu(1);
    }
    public static String getMenu(int identity){
        if (identity==1){
            menu=getTeacherMenu();
        }

        JSONArray json=JSON.parseArray(JSON.toJSONString(menu));
        JSONObject menuJson=new JSONObject();
        menuJson.put("menu",json);
        String menustring=JSON.toJSONString(menuJson);
        //System.out.println(menustring);
       return menustring;
    }
    private static menuSecond addSec(String name,String url){
        menuSecond secTmp=new menuSecond();
        secTmp.setName(name);
        secTmp.setUrl(url);
        return secTmp;
    }
    private static menuFirst addSecList(String name){
        menuFirst firTmp=new menuFirst();
        firTmp.setName(name);
        ArrayList<menuSecond> menusec=new ArrayList<>();
        switch (name){
            case "课程材料":
                menusec.add(addSec("课件上传","login.html"));
                menusec.add(addSec("教案上传","upload.html"));
                menusec.add(addSec("讲义上传","upload.html"));
                break;
            case "教师评价结果":
                menusec.add(addSec("教师教学过程评价","upload.html"));
                menusec.add(addSec("教师教学成效评价","upload.html"));
                menusec.add(addSec("教师教学质量评价","upload.html"));
                break;
        }

        firTmp.setMenuList(menusec);
        return firTmp;
    }
    private static ArrayList<menuFirst> getTeacherMenu(){
        ArrayList<menuFirst> menu=new ArrayList<>();

        menu.add(addSecList("课程材料"));
        menu.add(addSecList("教师评价结果"));
        return menu;
    }
}
