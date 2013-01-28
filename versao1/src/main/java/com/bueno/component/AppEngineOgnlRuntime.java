package com.bueno.component;

import ognl.OgnlRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class AppEngineOgnlRuntime {
	private static Logger logger = LoggerFactory.getLogger(AppEngineOgnlRuntime.class);
	static {
		logger.info("Setting null on OGNL security manager, working around GAE");
		OgnlRuntime.setSecurityManager(null);
	}
}