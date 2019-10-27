package cn.cerc.example.forms;

import cn.cerc.jbean.client.LocalService;
import cn.cerc.jbean.form.IPage;
import cn.cerc.jdb.core.DataSet;
import cn.cerc.jdb.core.Record;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;
import cn.cerc.jmis.page.RedirectPage;
import cn.cerc.jpage.core.UrlRecord;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmPartInfo extends AbstractForm {

    @Override
    public IPage execute() {
        JspPage jspPage = new JspPage(this, "common/FrmPartInfo.jsp");

        String message = getRequest().getParameter("message");
        if (message != null) {
            jspPage.setMessage(message);
        }

        LocalService svr = new LocalService(this, "SvrPartInfo.search");
        Record headIn = svr.getDataIn().getHead();
        headIn.setField("code_", getRequest().getParameter("code"));
        headIn.setField("searchText_", getRequest().getParameter("searchText"));
        if (!svr.exec()) {
            jspPage.setMessage(svr.getMessage());
            return jspPage;
        }

        DataSet dataSet = svr.getDataOut();
        jspPage.add("dataSet", dataSet);
        log.info("dataSet {}", dataSet);
        return jspPage;
    }

    public IPage append() {
        JspPage jspPage = new JspPage(this, "common/FrmPartInfo_append.jsp");
        String submit = getRequest().getParameter("submit");
        log.info("submit {}", submit);
        if (submit == null || "".equals(submit)) {
            return jspPage;
        }

        String code = getRequest().getParameter("code");
        String desc = getRequest().getParameter("desc");
        String spec = getRequest().getParameter("spec");
        String unit = getRequest().getParameter("unit");
        String remark = getRequest().getParameter("remark");

        LocalService svr = new LocalService(this, "SvrPartInfo.append");
        Record headIn = svr.getDataIn().getHead();
        headIn.setField("code_", code);
        headIn.setField("desc_", desc);
        headIn.setField("spec_", spec);
        headIn.setField("unit_", unit);
        headIn.setField("remark_", remark);
        if (!svr.exec()) {
            jspPage.setMessage(svr.getMessage());
            return jspPage;
        }

        UrlRecord url = new UrlRecord();
        url.setSite("FrmPartInfo");
        url.putParam("message", "商品添加成功");
        log.info(url.getUrl());
        return new RedirectPage(this, url.getUrl());
    }


    public IPage modify() {
        JspPage jspPage = new JspPage(this, "common/FrmPartInfo_modify.jsp");
        String code = getRequest().getParameter("code");
        if (code == null || "".equals(code)) {
            jspPage.setMessage("code 不允许为空");
            return jspPage;
        }

        String message = getRequest().getParameter("message");
        if (message != null) {
            jspPage.setMessage(message);
        }

        LocalService svr1 = new LocalService(this, "SvrPartInfo.download");
        Record headIn1 = svr1.getDataIn().getHead();
        headIn1.setField("code_", code);
        if (!svr1.exec()) {
            jspPage.setMessage(svr1.getMessage());
            return jspPage;
        }
        Record record = svr1.getDataOut().getHead();
        jspPage.add("record", record);

        String submit = getRequest().getParameter("submit");
        if (submit != null && !"".equals(submit)) {
            String price = getRequest().getParameter("sex");
            if (price == null || "".equals(price)) {
                jspPage.setMessage("price 代码不允许为空");
                return jspPage;
            }
            LocalService svr2 = new LocalService(this, "SvrPartInfo.modify");
            Record headIn2 = svr2.getDataIn().getHead();
            headIn2.setField("code_", code);
            headIn2.setField("price_", price);
            headIn2.setField("number_", getRequest().getParameter("number"));
            if (!svr2.exec()) {
                jspPage.setMessage(svr2.getMessage());
                return jspPage;
            }
            UrlRecord url = new UrlRecord();
            url.setSite("FrmPartInfo.modify");
            url.putParam("code", code);
            url.putParam("message", "修改成功");
            return new RedirectPage(this, url.getUrl());
        }
        return jspPage;
    }

    public IPage delete() {
        UrlRecord url = new UrlRecord();
        String code = getRequest().getParameter("code");
        LocalService svr = new LocalService(this, "SvrPartInfo.delete");
        Record headIn2 = svr.getDataIn().getHead();
        headIn2.setField("code_", code);
        if (!svr.exec()) {
            url.setSite("FrmPartInfo.modify");
            url.putParam("code_", code);
            url.putParam("message", svr.getMessage());
            return new RedirectPage(this, url.getUrl());
        }
        url.setSite("FrmPartInfo");
        url.putParam("message", "删除成功");
        return new RedirectPage(this, url.getUrl());
    }

    @Override
    public boolean logon() {
        return true;
    }
}