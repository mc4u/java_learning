package com.cloud4u.membership.util;

import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;

import com.cloud4u.membership.domain.entity.MemberShipDetailEntity;


public class UserPDFExporter {
	private List<MemberShipDetailEntity> listMembers;

	public UserPDFExporter(List<MemberShipDetailEntity> listMembers) {
		this.listMembers = listMembers;
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
    	
	}

}
