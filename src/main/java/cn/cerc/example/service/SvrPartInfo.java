package cn.cerc.example.service;

import cn.cerc.example.common.AppDB;
import cn.cerc.jbean.core.CustomService;
import cn.cerc.jbean.core.DataValidateException;
import cn.cerc.jdb.core.Record;
import cn.cerc.jdb.mysql.SqlQuery;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SvrPartInfo extends CustomService {

    public boolean search() {
        Record headIn = getDataIn().getHead();
        String searchText = headIn.getString("searchText_");

        SqlQuery cdsTmp = new SqlQuery(this);
        cdsTmp.add("select * from %s", AppDB.Table_PartInfo);
        if (searchText != null && !"".equals(searchText)) {
            searchText = searchText.trim();
            cdsTmp.add("where code_ like '%%%s%%'", searchText);
            cdsTmp.add("or desc_ like '%%%s%%'", searchText);
        }
        log.info("{}", cdsTmp.getSqlText());
        cdsTmp.open();

        getDataOut().appendDataSet(cdsTmp);
        log.info("商品信息 {}", getDataOut());
        return true;
    }

    public boolean append() throws DataValidateException {
        Record headIn = getDataIn().getHead();

        DataValidateException.stopRun("商品代码不允许为空", !headIn.hasValue("code_"));
        String code = headIn.getString("code_");

        DataValidateException.stopRun("商品代码不允许为空", !headIn.hasValue("desc_"));
        String desc = headIn.getString("desc_");

        DataValidateException.stopRun("商品代码不允许为空", !headIn.hasValue("spec_"));
        String spec = headIn.getString("spec_");

        DataValidateException.stopRun("商品代码不允许为空", !headIn.hasValue("unit_"));
        String unit = headIn.getString("unit_");

        String remark = headIn.getString("remark_");

        // 查询数据库是否存在当前商品

        SqlQuery cdsTmp = new SqlQuery(this);
        cdsTmp.add("select * from %s", AppDB.Table_PartInfo);
        cdsTmp.add("where corpNo_='%s'", AppDB.CorpNo);
        cdsTmp.add("and code_='%s'", code);
        cdsTmp.open();
        if (!cdsTmp.eof()) {
            this.setMessage("商品已经存在");
            return false;
        }

        // 将商品数据保存到数据库
        cdsTmp.append();
        cdsTmp.setField("corpNo_", AppDB.CorpNo);
        cdsTmp.setField("code_", code);
        cdsTmp.setField("desc_", desc);
        cdsTmp.setField("spec_", spec);
        cdsTmp.setField("unit_", unit);
        cdsTmp.setField("remark_", remark);
        cdsTmp.post();

        return true;
    }

}
