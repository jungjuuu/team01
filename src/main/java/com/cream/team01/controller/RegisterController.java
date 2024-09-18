package com.cream.team01.controller;

public class RegisterController {
	
	@Autowired
    private RegisterDAO registerDAO;
	
	// 멤버 회원가입
	@RequestMapping("/memberregister")
    public ModelAndView addMemberRegisterForm( 
    		@ModelAttribute AccountVO account, 
            @ModelAttribute MemberVO member){ 
		
		 registerDAO.createAccount(account);  
		 member.setAccountNo(account.getAccountNo());   
		 registerDAO.createMember(member);
		 
		
		 
        ModelAndView result = new ModelAndView("/memberregister"); 
        return result;
    }

	public static void main(String[] args) {
		
	}

}
