package com.cloud4u.membership.controller;

import com.cloud4u.membership.domain.dto.MemberInfo;
import com.cloud4u.membership.domain.entity.MemberDetailEntity;
import com.cloud4u.membership.domain.entity.MemberEntity;
import com.cloud4u.membership.domain.entity.MemberShipDetailEntity;
import com.cloud4u.membership.service.MemberService;
import com.cloud4u.membership.util.UserPDFExporter;
import com.cloud4u.membership.vo.NotificationVo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/membership/api")
@CrossOrigin({"https://cloud4u-trainig-ui.s3.ap-south-1.amazonaws.com/", "http://localhost:4200"})
public class MemberController {
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping(value = "/registration")
	public ResponseEntity<MemberInfo> registration(@RequestBody MemberInfo memberInfo) {
		return ResponseEntity.ok(memberService.register(memberInfo));
	}

	@GetMapping(value = "/login/{emailId}/{password}")
	public ResponseEntity<MemberInfo> login(@PathVariable("emailId") String emailId,
			@PathVariable("password") String password) {
		return ResponseEntity.ok(memberService.login(emailId, password));
	}

	@GetMapping(value = "/memberDetails/{member_id}")
	public MemberDetailEntity memberDetails(@PathVariable("member_id") long member_id) {

		return memberService.getMemberDetails(member_id);
	}

	@GetMapping(value = "/notification")
	public List<NotificationVo> notification() throws ParseException {
		List<MemberShipDetailEntity> memberShip = memberService.getNotification();
		String notification = "";
		List<NotificationVo> notificationList = new ArrayList<NotificationVo>();
		List<MemberInfo> memberInfolist = new ArrayList<MemberInfo>();
		for (MemberShipDetailEntity obj : memberShip) {
			notification = "";
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy");

			String start = dtf.format(now);
			String end = obj.getEndingDate();
			if ((start.compareTo(end))== -1) {
				notification="Package Will Expire Tommorow";
			} else if (start.compareTo(end) > 0) {
				notification = "Package is Expire";
			} else if (start.compareTo(end) == 0) {
				notification = "Package Will Expire today";
			} else {
				notification = "No Notification found";
			}
			
			MemberInfo memberInfo = memberService.GetMember(obj.getMemberId());
			NotificationVo notificationVo = new NotificationVo();
			notificationVo.setMemberId(obj.getMemberId());
			notificationVo.setMemeberName(memberInfo.getName());
			notificationVo.setEmailID(memberInfo.getEmailId());
			notificationVo.setStatus(notification);
			notificationList.add(notificationVo);
		}

		return notificationList;
	}
    @GetMapping(value = "/reciept/{member_id}") public void exportToPDF(@PathVariable("member_id") long member_id,HttpServletResponse
	 response) throws DocumentException, IOException {
	  response.setContentType("application/pdf"); DateFormat dateFormatter = new
	  SimpleDateFormat("yyyy-MM-dd_HH:mm:ss"); String currentDateTime =
	  dateFormatter.format(new Date());
	  
	  String headerKey = "Content-Disposition"; String headerValue =
	  "attachment; filename=users_" + currentDateTime + ".pdf";
	  response.setHeader(headerKey, headerValue); 
	  MemberDetailEntity listUsers = memberService.getMemberDetails(member_id);
	  MemberShipDetailEntity detailEntity=memberService.getMemberById(member_id);
	  UserPDFExporter exporter = new UserPDFExporter(listUsers,detailEntity);
	  exporter.export(response);
	  }
	 
}
