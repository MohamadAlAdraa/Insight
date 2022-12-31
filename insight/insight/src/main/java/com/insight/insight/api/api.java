package com.insight.insight.api;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insight.insight.entity.aboutus;
import com.insight.insight.entity.admin;
import com.insight.insight.entity.blog;
import com.insight.insight.entity.committee;
import com.insight.insight.entity.contactinfo;
import com.insight.insight.entity.faq;
import com.insight.insight.entity.futureevent;
import com.insight.insight.entity.goal;
import com.insight.insight.entity.previousevent;
import com.insight.insight.entity.program;
import com.insight.insight.entity.subcommittee;
import com.insight.insight.repository.aboutusRep;
import com.insight.insight.repository.adminRep;
import com.insight.insight.repository.blogRep;
import com.insight.insight.repository.committeeRep;
import com.insight.insight.repository.contactinfoRep;
import com.insight.insight.repository.faqRep;
import com.insight.insight.repository.futureeventRep;
import com.insight.insight.repository.goalRep;
import com.insight.insight.repository.previouseventRep;
import com.insight.insight.repository.programRep;
import com.insight.insight.repository.subcommitteeRep;

@RestController
@RequestMapping("/api/insight/v1")
public class api {

	@Autowired
	private adminRep AdminRep;
	@Autowired
	private aboutusRep AboutusRep;
	@Autowired
	private blogRep BlogRep;
	@Autowired
	private committeeRep CommitteeRep;
	@Autowired
	private contactinfoRep ContactinfoRep;
	@Autowired
	private faqRep FaqRep;
	@Autowired
	private futureeventRep FutureeventRep;
	@Autowired
	private goalRep GoalRep;
	@Autowired
	private previouseventRep PreviouseventRep;
	@Autowired
	private programRep ProgramRep;
	@Autowired
	private subcommitteeRep SubcommitteeRep;

//	********************************* ABOUT US APIS *********************************
	@GetMapping("/aboutus")
	public String getAboutus() {
		return AboutusRep.findAll().get(0).getAboutus();
	}
	
	@PutMapping("/aboutus/update")
	public int updateAboutus(@RequestBody aboutus u_obj) {
		
		try {
			aboutus obj = AboutusRep.getReferenceById(1);
			obj.setAboutus(u_obj.getAboutus());
			AboutusRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
//	*********************************************************************************
	
//	********************************* ADMIN APIS *********************************
	@GetMapping("/admin")
	public List<admin> getAdmin(){
		List<admin> l = new ArrayList<admin>();
		for (int i = 0; i < AdminRep.findAll().size(); i++) {
			admin obj = new admin();
			obj.setAdminemail(AdminRep.findAll().get(i).getAdminemail());
			obj.setAdminfirstname(AdminRep.findAll().get(i).getAdminfirstname());
			obj.setAdminlastname(AdminRep.findAll().get(i).getAdminlastname());
			l.add(obj);
		}
		return l;
	}
	
	@PutMapping("/admin/update")
	public int updateAdmin(@RequestBody admin u_obj) {
		try {
			if(AdminRep.existsById(u_obj.getAdminemail())) {
				admin obj = AdminRep.getReferenceById(u_obj.getAdminemail());
				obj.setAdminemail(u_obj.getAdminemail());
				obj.setAdminfirstname(u_obj.getAdminfirstname());
				obj.setAdminlastname(u_obj.getAdminlastname());
				AdminRep.save(obj);
				return Response.OK.getValue();
			}else {
				return Response.NOT_OK.getValue();
			}
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PutMapping("/admin/update/password")
	public int updateAdminPassword(@RequestBody admin u_obj) {
		try {
			if(AdminRep.existsById(u_obj.getAdminemail())) {
				admin obj = AdminRep.getReferenceById(u_obj.getAdminemail());
				String password = security.encrypt(u_obj.getAdminpassword());
				obj.setAdminpassword(password);
				AdminRep.save(obj);
				return Response.OK.getValue();
			}else {
				return Response.NOT_OK.getValue();
			}
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/admin/add")
	public int addAdmin(@RequestBody admin u_obj) {
		try {
			if(!AdminRep.existsById(u_obj.getAdminemail())) {
				admin obj = new admin();
				obj.setAdminfirstname(u_obj.getAdminfirstname());
				obj.setAdminlastname(u_obj.getAdminlastname());
				obj.setAdminemail(u_obj.getAdminemail());
				String password = security.encrypt(u_obj.getAdminpassword());
				obj.setAdminpassword(password);
				AdminRep.save(obj);
				return Response.OK.getValue();
			}else {
				return Response.NOT_OK.getValue();
			}
			
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@DeleteMapping("/admin/delete/{email}")
	public int deleteAdmin(@PathVariable String email) {
		try {
			if(AdminRep.existsById(email)) {
				AdminRep.deleteById(email);
				return Response.OK.getValue();
			}else {
				return Response.NOT_OK.getValue();
			}
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
//	*********************************************************************************
	
//	********************************* AUTHENTICATION APIS *********************************
	@PostMapping("/admin/login")
	public int login(@RequestBody admin loggingAdmin) {
		try {
			if(AdminRep.existsById(loggingAdmin.getAdminemail())) {
				admin obj = AdminRep.getReferenceById(loggingAdmin.getAdminemail());
				String db_pass = security.decrypt(obj.getAdminpassword());
				if(db_pass.equals(loggingAdmin.getAdminpassword())) {
					return Response.OK.getValue();
				}else {
					return Response.NOT_OK.getValue();
				}
			}else {
				return Response.NOT_OK.getValue();
			}
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
//	*********************************************************************************
	
//	********************************* COMMITTEE APIS *********************************
	@GetMapping("/committee")
	public List<committee> getCommittee(){
		return CommitteeRep.findAll();
	}
	
	@PutMapping("/committee/update")
	public int updateCommittee(@RequestBody committee u_obj) {
		try {
			committee obj = CommitteeRep.getReferenceById(u_obj.getIdcommittee());
			obj = u_obj;
			CommitteeRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/committee/add")
	public int addCommittee(@RequestBody committee u_obj) {
		try {
			CommitteeRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
	@DeleteMapping("/committee/delete/{id}")
	public int deleteCommittee(@PathVariable Integer id) {
		try {
			CommitteeRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
//	*********************************************************************************
	
//	********************************* SUBCOMMITTEE APIS *********************************
	@GetMapping("/subcommittee")
	public List<subcommittee> getSubcommittee(){
		return SubcommitteeRep.findAll();
	}
	
	@PutMapping("/subcommittee/update")
	public int updateSubcommittee(@RequestBody subcommittee u_obj) {
		try {
			subcommittee obj = SubcommitteeRep.getReferenceById(u_obj.getIdsubcommittee());
			obj = u_obj;
			SubcommitteeRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/subcommittee/add")
	public int addSubommittee(@RequestBody subcommittee u_obj) {
		try {
			SubcommitteeRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@DeleteMapping("/subcommittee/delete/{id}")
	public int deleteSubcommittee(@PathVariable Integer id) {
		try {
			SubcommitteeRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}


//*********************************************************************************

//********************************* PROGRAM APIS *********************************

	@GetMapping("/program")
	public List<program> getProgram(){
		return ProgramRep.findAll();
	}
	
	@PutMapping("/program/update")
	public int updateProgram(@RequestBody program u_obj) {
		try {
			program obj = ProgramRep.getReferenceById(u_obj.getIdprogram());
			obj = u_obj;
			ProgramRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/program/add")
	public int addProgram(@RequestBody program u_obj) {
		try {
			ProgramRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@DeleteMapping("/program/delete/{id}")
	public int deleteProgram(@PathVariable Integer id) {
		try {
			ProgramRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
//	*********************************************************************************
	
//	********************************* FUTUREEVENT APIS *********************************
	
	@GetMapping("/futureevent")
	public List<futureevent> getFutureevent(){
		return FutureeventRep.findAll();
	}
	
	@PutMapping("/futureevent/update")
	public int updateFutureevent(@RequestBody futureevent u_obj) {
		try {
			futureevent obj = FutureeventRep.getReferenceById(u_obj.getIdfutureevent());
			obj = u_obj;
			FutureeventRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/futureevent/add")
	public int addFutureevent(@RequestBody futureevent u_obj) {
		try {
			FutureeventRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@DeleteMapping("/futureevent/delete/{id}")
	public int deleteFutureevent(@PathVariable Integer id) {
		try {
			FutureeventRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
//	*********************************************************************************
	
//	********************************* PREVIOUSEVENT APIS *********************************
	
	@GetMapping("/previousevent")
	public List<previousevent> getPreviousevent(){
		return PreviouseventRep.findAll();
	}
	
	@PutMapping("/previousevent/update")
	public int updatePreviousevent(@RequestBody previousevent u_obj) {
		try {
			previousevent obj = PreviouseventRep.getReferenceById(u_obj.getIdpreviousevent());
			obj = u_obj;
			PreviouseventRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/previousevent/add")
	public int addPreviousevent(@RequestBody previousevent u_obj) {
		try {
			PreviouseventRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@DeleteMapping("/previousevent/delete/{id}")
	public int deletePreviousevent(@PathVariable Integer id) {
		try {
			PreviouseventRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}

//	*********************************************************************************
	
//	********************************* CONTACTINFO APIS *********************************
	
	@GetMapping("/contactinfo")
	public List<contactinfo> getContactinfo(){
		return ContactinfoRep.findAll();
	}
	
	@PutMapping("/contactinfo/update")
	public int updateContactinfo(@RequestBody contactinfo u_obj) {
		try {
			contactinfo obj = ContactinfoRep.getReferenceById(u_obj.getContactinfolocation());
			obj = u_obj;
			ContactinfoRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
//	*********************************************************************************
	
//	********************************* FAQ APIS *********************************
	
	@GetMapping("/faq")
	public List<faq> getFaqs(){
		return FaqRep.findAll();
	}
	
	@PutMapping("/faq/update")
	public int updateFaq(@RequestBody faq u_obj) {
		try {
			faq obj = FaqRep.getReferenceById(u_obj.getIdfaq());
			obj = u_obj;
			FaqRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/faq/add")
	public int addFaq(@RequestBody faq u_obj) {
		try {
			FaqRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
	@DeleteMapping("/faq/delete/{id}")
	public int deleteFaq(@PathVariable Integer id) {
		try {
			FaqRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
//	*********************************************************************************
	
//	********************************* GOALS APIS *********************************
	
	@GetMapping("/goal")
	public List<goal> getGoals(){
		return GoalRep.findAll();
	}
	
	@PutMapping("/goal/update")
	public int updateGoal(@RequestBody goal u_obj) {
		try {
			goal obj = GoalRep.getReferenceById(u_obj.getIdgoal());
			obj = u_obj;
			GoalRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/goal/add")
	public int addGoal(@RequestBody goal u_obj) {
		try {
			GoalRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
	@DeleteMapping("/goal/delete/{id}")
	public int deleteGoal(@PathVariable Integer id) {
		try {
			GoalRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
//	*********************************************************************************
	
//	********************************* BLOG APIS *********************************
	
	@GetMapping("/blog")
	public List<blog> getBlogs(){
		return BlogRep.findAll();
	}
	
	@PutMapping("/blog/update")
	public int updateBlog(@RequestBody blog u_obj) {
		try {
			blog obj = BlogRep.getReferenceById(u_obj.getIdblog());
			obj = u_obj;
			BlogRep.save(obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
		
	}
	
	@PostMapping("/blog/add")
	public int addBlog(@RequestBody blog u_obj) {
		try {
			BlogRep.save(u_obj);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	
	@DeleteMapping("/blog/delete/{id}")
	public int deleteBlog(@PathVariable Integer id) {
		try {
			BlogRep.deleteById(id);
			return Response.OK.getValue();
		}catch (IllegalArgumentException e) {
			return Response.EXCEPTION.getValue();
		}
	}
	

	
}
	