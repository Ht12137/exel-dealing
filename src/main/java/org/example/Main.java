package org.example;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Constants.*;

public class Main {


    public static final String ORIGIN_FILE_NAME_TWO = "D:\\IdeaProjects\\suncong\\exel-dealing\\src\\main\\resources\\教育+企业分类+城市.xlsx";

    private static String[] c1 = {"计算机制造","整机","零部件","外围设备","工业控制","信息安全设备通讯及雷达设备制造","通信","雷达","数字媒体设备制造","数字媒体","广播","音响","电视","影视","智能设备","智能","机器人","电子元器件及设备制造","电子","半导体","元器件","电路","其他数字产品制造业","游艺设备","游戏","3D打印","电线电缆","光纤","光缆","工业自动控制系统","信息化学品","计算器"};
    private static String[] c2 = {"数字产品批发","电子设备批发","电信设备批发","广播影视设备批发","数字产品零售","计算机零售","电子产品零售","电信设备零售","数字产品租赁","电子设备租赁"," 音响设备出租","数字产品维修", "电子设备维修","通讯设备维修","其他数字产品服务业","数字产品服务业"};
    private static String[] c3 = {"软件开发","软件开发","电信、广播电视和卫星传输服务","电信传输","广播电视传输","卫星传输","互联网相关服务","互联网接入","互联网搜索"," 互联网游戏","互联网咨询","互联网安全"," 互联网数据","信息技术服务","物联网","运行维护","集成电路设计","信息系统集成","信息处理","技术咨询","地理信息","动漫","游戏","其他数字技术应用业","3D 打印","技术推广"};
    private static String[] c4 = {"互联网平台","互联网平台","互联网批发零售","互联网批发","互联网零售","互联网金融","网络借贷","支付服务","金融信息服务","数字内容与媒体","广播节目","电视节目","影视节目","录音制作","广告","数字内容出版","信息基础设施建设","网络基础设施","人工智能","云计算","区块链","数据信息","数据资源与产权交易","数据资源","数据产权","其他数字要素驱动业","供应链管理","安全系统监控","数字技术"};
    private static String[] c5= {"智慧农业","智慧林业","智慧农业","智慧养殖","智慧渔业","智慧牧业","智能制造","数字化设备","智能交通","智能铁路运输","智能道路运输","智能水上运输","智能航空运输","智慧物流","智慧仓储","智慧配送","数字金融","金融服务","市场服务","互联网保险","数字商贸","数字化批发"," 数字化零售","数字化住宿","数字化餐饮","数字化租赁","数字化商务","数字社会","教育","医疗"," 社会工作","数字政府","办公","海关","税务"," 社会保障","其他数字化效率提升业","生活服务"," 能源供应","采矿","建筑业","房地产业","专业技术服务","公共管理","文体娱乐"};

    private static String[] c6 = {"光纤网络","5G网络","IPv6","空间信息技术","算力","算法","数据","应用资源协同"};
    private static String[] c7 = {"数据标注","数据清洗","数据脱敏","数据脱密","数据聚合","数据分析"};
    private static String[] c8 = {"农业","水利","工业","商务","物流","金融","能源","产业园"};
    private static String[] c9 = {"高端芯片","操作系统","工业软件","核心算法与框架","智能制造","数字孪生","城市大脑","边缘计算","脑机融合","下一代移动通信技术","量子信息","神经芯片","类脑智能","DNA存储","第三代半导体","基础软硬件","核心电子元器件","关键基础材料","新兴共享经济","智能经济","新个体经济","在线服务"};
    private static String[] c10 = {"政务","社会服务","文化教育","医疗健康","会展旅游","体育健身","智慧教育","数字健康","数字文旅","智慧社区","社会保障"};
    private static String[] c11 = {"政府","社会公众","协同治理","平台","行业组织","企业"};
    private static String[] c12 = {"网络安全","数据安全"};
    private static String[] c13 = {"跨境电商","境外数字基础设施","跨境光缆"};


    public static void main(String[] args) {
        List<MainData2> list = doRead2();
        doWrite2(list);
    }

    private static List<MainData2> doRead2(){
        List<MainData2> list = EasyExcel.read(ORIGIN_FILE_NAME_TWO).head(MainData2.class).sheet().doReadSync();
        list.forEach(element-> System.out.println("读取到的数据" + JSONUtil.toJsonStr(element)));
        return list;
    }

    private static void doWrite2(List<MainData2> list){
        EasyExcel.write(FINISH_FILE_NAME, MainData2.class).sheet("sheet1").doWrite(fillInData2(list));
    }

    private static List<MainData2> fillInData2(List<MainData2> mainData){
        List<MainData2> resultData = new ArrayList<>();
        for (MainData2 data : mainData) {
            MainData2 mainData2 = new MainData2();
            BeanUtil.copyProperties(data,mainData2);
            cycle(mainData2,c1);
            cycle(mainData2,c2);
            cycle(mainData2,c3);
            cycle(mainData2,c4);
            cycle(mainData2,c5);
            cycle(mainData2,c6);
            cycle(mainData2,c7);
            cycle(mainData2,c8);
            cycle(mainData2,c9);
            cycle(mainData2,c10);
            cycle(mainData2,c11);
            cycle(mainData2,c12);
            cycle(mainData2,c13);
            resultData.add(mainData2);
        }
        return resultData;
    }

    private static void cycle(MainData2 data,String[] criteria){
        String positionName = data.getPositionName();
        String companyName = data.getCompanyName();
        String companyTag = data.getCompanyTag();
        String positionTag = data.getPositionTag();
        for (String s : criteria) {
            if(isContain(s,positionName)||isContain(s,companyName)||isContain(s,companyTag)||isContain(s,positionTag)){
                if(Arrays.equals(criteria, c1)){
                    data.setCriteria1("√");
                    break;
                }else if(Arrays.equals(criteria,c2)){
                    data.setCriteria2("√");
                    break;
                }else if(Arrays.equals(criteria,c3)){
                    data.setCriteria3("√");
                    break;
                }else if(Arrays.equals(criteria,c4)){
                    data.setCriteria4("√");
                    break;
                }else if(Arrays.equals(criteria,c5)){
                    data.setCriteria5("√");
                    break;
                }else if(Arrays.equals(criteria,c6)){
                    data.setCriteria6("√");
                    break;
                }else if(Arrays.equals(criteria,c7)){
                    data.setCriteria7("√");
                    break;
                }else if(Arrays.equals(criteria,c8)){
                    data.setCriteria8("√");
                    break;
                }else if(Arrays.equals(criteria,c9)){
                    data.setCriteria9("√");
                    break;
                }else if(Arrays.equals(criteria,c10)){
                    data.setCriteria10("√");
                    break;
                }else if(Arrays.equals(criteria,c11)){
                    data.setCriteria11("√");
                    break;
                }else if(Arrays.equals(criteria,c12)){
                    data.setCriteria12("√");
                    break;
                }else if(Arrays.equals(criteria,c13)){
                    data.setCriteria13("√");
                    break;
                }
            }
        }
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
        if (StrUtil.isEmpty(target)){
            return false;
        }
        return target.contains(judge);
    }




}