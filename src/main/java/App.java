import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.seasar.fisshplate.template.FPTemplate;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, Poi> map = new HashMap<String, Poi>();
        map.put("data", new Poi());

        InputStream is = App.class.getClassLoader().getResourceAsStream("aaaa/sample.xls");
        System.out.println(App.class.getClassLoader().getResource("aaaa/sample.xls")); // debug: テンプレートのパス
        FPTemplate template = new FPTemplate();
        HSSFWorkbook wb;
        try {
            wb = template.process(is, map);
        } catch (Exception e) {
            //例外処理
            throw e;
        }

        FileOutputStream fos = new FileOutputStream("out.xls");      
        wb.write(fos);
        fos.close();
    }
}