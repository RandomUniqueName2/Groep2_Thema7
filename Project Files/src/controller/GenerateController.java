package controller;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import domain.businessrule.BRGBusinessRule;
import domain.businessrule.BRGBusinessRuleType;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GenerateController {
	public static final URL packageUrl = GenerateController.class
			.getResource("/resources/templates");

	public static void implementBusinessRule(BRGBusinessRule rule) {
		BRGBusinessRuleType type = rule.getBusinessRuleType();
		String generatedCode;

		switch (type.getCode()) {
		case BRGBusinessRuleType.ACMP:
			break;
		}

	}

	public static String generateACMPRule(String column, String operand,
			String value) {
		Configuration cfg = new Configuration();
		Template tpl = null;
		Map<String, Object> input = new HashMap<String, Object>();
		StringWriter writer = new StringWriter();

		try {
			cfg.setDirectoryForTemplateLoading(new File(
					"Groep2_Thema7/Project Files/src/resources/templates"));

			tpl = cfg.getTemplate("ACMPRule.ftl");

			input.put("column", column);
			input.put("operand", operand);
			input.put("value", value);

			tpl.process(input, writer);
		} catch (IOException | TemplateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return writer.toString();
	}
}