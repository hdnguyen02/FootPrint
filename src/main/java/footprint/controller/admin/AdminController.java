package footprint.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import footprint.bean.UploadFile;
import footprint.bean.User;
import footprint.dao.AccountDao.EnumRoleID;
import footprint.entity.Account;
import footprint.entity.Role;
import footprint.helper.ConverterUploadHandler;
import footprint.service.AccountService;

@Controller
public class AdminController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("admin")
	public String index(ModelMap model) {
		List<Account> accounts = accountService.listAccountWithRole(EnumRoleID.STAFF);
		model.addAttribute("accounts", accounts);
		model.addAttribute("source", "admin.htm");
		
		model.addAttribute("sidebarDashboard", "admin/sidebar.jsp");
		model.addAttribute("bodyDashboard", "admin/index.jsp");
		return "layout/main-dashboard";
	}
	
	@RequestMapping(value = "enable{id}")
	public String enableStatusUser(@PathVariable("id") Long id, ModelMap modelMap, @RequestParam("source") String source) {
		Account acc = accountService.getAccountWithId(id);
		if (acc != null) {
			if (acc.getDisable() == false)
				acc.setDisable(true);
			else if (acc.getDisable() == true)
				acc.setDisable(false);
			accountService.update(acc);
		}
		return "redirect:" + source;
	}

	@RequestMapping(value = "delete{id}")
	public String deleteUser(@PathVariable("id") Long id, ModelMap modelMap, @RequestParam("source") String source) {
		Account acc = accountService.getAccountWithId(id);
		if (acc != null) {
			if (accountService.deleteAccount(acc)) {

			}
		}
		return "redirect:" + source;
	}

	@RequestMapping("admin/create-staff")
	public String registerStaffForm(ModelMap modelMap) {
		User accEmploy = new User();
		modelMap.addAttribute("userbean", accEmploy);
		return "admin/admin-register-staff";
	}

	@Autowired
	@Qualifier("accountImgDir")
	private UploadFile uploadFile;

	@Autowired
	private ConverterUploadHandler convertHandler; 
	
	@RequestMapping(value = "admin/staff-register", method = RequestMethod.POST)
	public String register(@ModelAttribute("userbean") User user, ModelMap modelMap) {
		
			String avatarDir = "";
			if (!user.getAvatar().isEmpty()) {
				if (convertHandler.MoveMultipartToDirectory(user.getAvatar(), uploadFile.getbasePath())) {
					user.setAvatarDir(convertHandler.SetImageNameViaMultipartFile(user.getAvatar()));
				}
			}

			Role role = accountService.getRoleViaEnum(EnumRoleID.STAFF);
			Account account = new Account(role, user.getLastName(), user.getFirstName(), user.getEmail(),
					user.getPhoneNumber(), avatarDir, user.getPassword(), user.getUsername());

			if (!user.getAvatarDir().isEmpty()) {
				account.setImageUrl(user.getAvatarDir());
			}

			if (accountService.insertStaff(account)) {
				return "redirect:/admin.htm";
			}
			
		modelMap.addAttribute("userbean", user);
		return "admin/admin-register-staff";
	}
}
