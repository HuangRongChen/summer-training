
package cn.cerc.example.forms;

import cn.cerc.jbean.form.IPage;
import cn.cerc.jmis.form.AbstractForm;
import cn.cerc.jmis.page.JspPage;

public class FrmText  extends AbstractForm {

    @Override
    public IPage execute() throws Exception {
        return new JspPage(this,"common/FrmText.jsp");
    }

    @Override
    public boolean logon() {
        return true;
    }
}
