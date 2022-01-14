package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
    
	@Autowired
	RecoveryRoomService recoveryService;
	
	@GetMapping(path="/create")
	public String getForm(ModelMap modelMap) {
		modelMap.addAttribute("recoveryRoom", new RecoveryRoom());
		modelMap.addAttribute("type", recoveryService.getAllRecoveryRoomTypes());
		return "recoveryroom/createOrUpdateRecoveryRoomForm";
	}
	
	@PostMapping(path="create")
	public String postForm(@Valid RecoveryRoom r, BindingResult b, ModelMap modelMap) {
		if(b.hasErrors()) {
			modelMap.addAttribute("recoveryRoom", r);
			modelMap.addAttribute("type", recoveryService.getAllRecoveryRoomTypes());
			return "recoveryroom/createOrUpdateRecoveryRoomForm";
		}else {
			recoveryService.save(r);
			modelMap.addAttribute("recoveryRoom", r);
			modelMap.addAttribute("type", recoveryService.getAllRecoveryRoomTypes());
			return "welcome";
		}
	}
}
