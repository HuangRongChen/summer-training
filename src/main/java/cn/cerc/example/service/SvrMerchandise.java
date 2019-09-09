package cn.cerc.example.service;

import cn.cerc.example.common.AppDB;
import cn.cerc.jbean.core.CustomService;
import cn.cerc.jdb.core.Record;
import cn.cerc.jdb.mysql.SqlQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SvrMerchandise extends CustomService {

    public boolean search() {
        Record headIn = getDataIn().getHead();

        SqlQuery cdsTmp = new SqlQuery(this);
        cdsTmp.add("select * from %s", AppDB.Table_PartInfo);
        cdsTmp.open();

        getDataOut().appendDataSet(cdsTmp);
        log.info("商品信息 {}", getDataOut());
        return true;
    }
}
