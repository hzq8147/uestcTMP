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

        switch(identity){
            case 1:
                menu=getTeacherMenu();
                break;
            case 2:
                menu=getResponsibleMemberMenu();
                break;
            case 3:
                menu=getResponsibleLeaderMenu();
                break;
            case 4:
                menu=getAdministrationMenu();
                break;
            case 5:
                menu=getDeanMenu();
                break;
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
       
        ArrayList<menuSecond> menusec=new ArrayList<>();
        switch (name){
            case "课程材料":
                firTmp.setName("课程材料");
                menusec.add(addSec("课件上传","login.html"));
                menusec.add(addSec("教案上传","upload.html"));
                menusec.add(addSec("讲义上传","upload.html"));
                break;
            case "教师评价结果":
                firTmp.setName("教师评价结果");
                menusec.add(addSec("教师教学过程评价","upload.html"));
                menusec.add(addSec("教师教学成效评价","upload.html"));
                menusec.add(addSec("教师教学质量评价","upload.html"));
                break;
            case "课程组质量分析":
                firTmp.setName("课程组质量分析");
                menusec.add(addSec("课程组教学过程评价","upload.html"));
                menusec.add(addSec("课程组教学成效评价","upload.html"));
                menusec.add(addSec("课程组教学质量评价","upload.html"));
                break;
            case "专业质量分析":
                firTmp.setName("专业质量分析");
                menusec.add(addSec("专业教学过程评价","upload.html"));
                menusec.add(addSec("专业教学成效评价","upload.html"));
                menusec.add(addSec("专业教学质量评价","upload.html"));
                break;
            case "社会评价":
                firTmp.setName("社会评价");
                menusec.add(addSec("毕业生用人单位反馈","upload.html"));
                menusec.add(addSec("实习生用人单位反馈","upload.html"));
                menusec.add(addSec("毕业生反馈","upload.html"));
                break;
            case "我的任务1":
                firTmp.setName("我的任务");
                menusec.add(addSec("我的检查任务","upload.html"));
                break;
            case "我的任务2":
                firTmp.setName("我的任务");
                menusec.add(addSec("我的检查任务","upload.html"));
                menusec.add(addSec("任务分配","upload.html"));
                menusec.add(addSec("任务完成进度","upload.html"));
                break;
            case "专业数据管理":
                firTmp.setName("专业数据库管理");
                menusec.add(addSec("培养方案管理","upload.html"));
                menusec.add(addSec("培养目标管理","upload.html"));
                menusec.add(addSec("毕业要求管理","upload.html"));
                menusec.add(addSec("毕业要求映射","upload.html"));
                break;
            case "社会问卷管理":
                firTmp.setName("社会问卷管理");
                menusec.add(addSec("毕业生用人单位反馈","upload.html"));
                menusec.add(addSec("实习生用人单位反馈","upload.html"));
                menusec.add(addSec("毕业生反馈","upload.html"));
                break;
            case "教师教学评价排名":
                firTmp.setName("教师教学评价排名");
                menusec.add(addSec("教学过程评价","upload.html"));
                menusec.add(addSec("教学成效评价","upload.html"));
                menusec.add(addSec("教学质量评价","upload.html"));
                break;

        }

        firTmp.setMenuList(menusec);
        return firTmp;
    }
    private static ArrayList<menuFirst> getTeacherMenu(){//普通教师
        ArrayList<menuFirst> menu=new ArrayList<>();

        menu.add(addSecList("课程材料"));
        menu.add(addSecList("教师评价结果"));
        menu.add(addSecList("课程组质量分析"));
        menu.add(addSecList("专业质量分析"));
        menu.add(addSecList("社会评价"));
        return menu;
    }
    private static ArrayList<menuFirst> getResponsibleMemberMenu(){//质量小组成员
        ArrayList<menuFirst> menu=new ArrayList<>();

        menu.add(addSecList("我的任务1"));
        menu.add(addSecList("课程组质量分析"));
        menu.add(addSecList("专业质量分析"));
        menu.add(addSecList("社会评价"));
        return menu;
    }
    private static ArrayList<menuFirst> getResponsibleLeaderMenu(){//质量小组组长
        ArrayList<menuFirst> menu=new ArrayList<>();

        menu.add(addSecList("我的任务2"));
        menu.add(addSecList("课程组质量分析"));
        menu.add(addSecList("专业质量分析"));
        menu.add(addSecList("社会评价"));
        return menu;
    }
    private static ArrayList<menuFirst> getAdministrationMenu(){//教务科
        ArrayList<menuFirst> menu=new ArrayList<>();

        menu.add(addSecList("问卷数据采集"));
        menu.add(addSecList("教学管理数据采集"));
        menu.add(addSecList("教师教学评价排名"));
        menu.add(addSecList("课程组质量分析"));
        menu.add(addSecList("专业质量分析"));
        menu.add(addSecList("社会评价"));
        return menu;
    }
    private static ArrayList<menuFirst> getDeanMenu(){//教学院长
        ArrayList<menuFirst> menu=new ArrayList<>();
        menu.add(addSecList("教师教学评价排名"));
        menu.add(addSecList("课程组质量分析"));
        menu.add(addSecList("专业质量分析"));
        menu.add(addSecList("社会评价"));
        return menu;
    }

}
