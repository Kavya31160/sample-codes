package com.stackroute.samplerestbasic.config;


import jakarta.activation.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CustomDataSource implements DataSource {

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "sampleauto";
	}

   
}
