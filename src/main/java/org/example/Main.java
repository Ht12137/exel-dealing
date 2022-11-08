package org.example;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import java.util.Arrays;
import java.util.List;

import static org.example.Constants.*;

public class Main {

    public static void main(String[] args) {
        List<MainData> list = doRead();
        doWrite(list);
    }

    private static List<MainData> doRead(){
        List<MainData> list = EasyExcel.read(ORIGIN_FILE_NAME).head(MainData.class).sheet().doReadSync();
        list.forEach(element-> System.out.println("读取到的数据" + JSONUtil.toJsonStr(element)));
        return list;
    }


    private static void doWrite(List<MainData> list){
        EasyExcel.write(FINISH_FILE_NAME, MainData.class).sheet("sheet1").doWrite(fillInData(list));
    }

    private static List<MainData> fillInData(List<MainData> originData) {
        List<MainData> list = ListUtils.newArrayList();
        for (MainData originDatum : originData) {
            MainData data = new MainData();
            data.setSchool(originDatum.getSchool());
            data.setArea(originDatum.getArea());
            data.setSubject(originDatum.getSubject());
            for (String s : isLogicalJudgeList) {
                if (isContain(s, originDatum.getSubject())) {
                    data.setIsLogical("√");
                    break;
                }
            }
            for (String s : isMessageTechJudgeList) {
                if (isContain(s, originDatum.getSubject())) {
                    data.setIsInfoTech("√");
                    break;
                }
            }
            for (String s : isDataPracticeJudgeList) {
                if (isContain(s, originDatum.getSubject())) {
                    data.setIsDataPractice("√");
                    break;
                }
            }
            list.add(data);
        }
        return list;
    }

    private static boolean isContain(String judge,String target){
        return target.contains(judge);
    }




}