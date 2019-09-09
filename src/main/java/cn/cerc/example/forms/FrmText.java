
package cn.cerc.example.forms;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jdb.core.TDateTime;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrmText extends AbstractForm {

    @Override
    public IPage execute() throws Exception {
        log.info("开始运行1 {}-{}", TDateTime.Now(), getRequest().getRequestURI());
        System.out.println(String.format("开始运行2 %s-%s", TDateTime.Now(), getRequest().getRequestURI()));
        return new JspPage(this, "common/FrmText.jsp");
    }

    @Override
    public boolean logon() {
        return true;
    }
}
