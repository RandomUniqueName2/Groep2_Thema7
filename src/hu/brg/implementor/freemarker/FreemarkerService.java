package hu.brg.implementor.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public final class FreemarkerService {
	private final Configuration cfg = new Configuration();
	
	public FreemarkerService() { 
		try {
			cfg.setDirectoryForTemplateLoading(new File("src/hu/brg/resources/templates"));
		} catch (Exception e) {
			// TODO: Handle error correctly
			e.printStackTrace();
		}
	}
	
	public final String processTemplate(String tplName, Map<String, Object> data) {
		StringWriter sw = new StringWriter();
		
		try {
			 Template tpl = cfg.getTemplate(tplName);
			 tpl.process(data, sw);
		} catch (IOException | TemplateException e) {
			// TODO Handle error correctly
			e.printStackTrace();
		}
		
		return sw.toString();
	}
}
