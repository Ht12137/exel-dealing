package org.example;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ht
 */

public class MainDataListener implements ReadListener<MainData> {

    /**
     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 100;
    /**
     * 缓存的数据
     */
    private List<MainData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


    private List<Map> readResult = new ArrayList<>();

    private Map storeIntoMap(MainData data){
        Map<String,String> readValues = new HashMap<>();
        readValues.put("school",data.getSchool());
        readValues.put("area",data.getArea());
        readValues.put("subject",data.getSubject());
        return readValues;
    }


    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(MainData data, AnalysisContext context) {
        System.out.println(data.getSchool()+ "\t" +data.getArea() + "\t" +data.getSubject());
        Map map = storeIntoMap(data);
        readResult.add(map);
        cachedDataList.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (cachedDataList.size() >= BATCH_COUNT) {
            // 存储完成清理 list
            cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("所有数据解析完成");
    }

}
