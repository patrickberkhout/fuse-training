package com.github.patrickberkhout.com.fuseproxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.camel.component.urlrewrite.HttpUrlRewrite;
import org.apache.camel.util.IOHelper;
import org.tuckey.web.filters.urlrewrite.Conf;

public class FileBasedHttpUrlRewrite extends HttpUrlRewrite {

	@Override
	protected void doStart() throws Exception {
		InputStream is = new FileInputStream(new File(configFile));
		try {
			conf = new Conf(is, configFile);
		} finally {
			IOHelper.close(is);
		}
		super.doStart();
	}
}
