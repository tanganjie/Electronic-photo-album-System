package com.dzxc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.dzxc.base.action.BaseAction;
import com.dzxc.entity.Dictionary.DQuestion;
import com.dzxc.entity.User.User;
import com.dzxc.service.IDictionaryService;
import com.dzxc.service.IUserService;

public class UserAction extends BaseAction{
	private static final long serialVersionUID = 6387042708363383815L;

	private IUserService userService;

	private IDictionaryService dictionaryService;

	private User user;

	private User iuser;

	private List<DQuestion> questionList;
	
	private DQuestion question;
	
	private int num;

	/**
	 * @author t.anjie update by HC
	 * �û���½/����MD5����
	 * @return
	 */
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int flag=this.getUserService().login(user);
		if(flag>0){
			user=this.getUserService().findCurrentUser(user.getUserName());
			session.setAttribute("user", user);
			if(flag==1){
				this.setDynamicUrl("/Album_findAllAlbum.action");
				return this.MYREDIRCT;
			}
			else{
				this.setDynamicUrl("/Album_findAllKind.action");
				return this.MYREDIRCT;
			}
		}
		else{
			this.setDynamicUrl("/error.jsp");
			return this.DYNAMIC;
		}
	}

	/**
	 * @author t.anjie update by HC
	 * �����û�ע��ҳ��/����MD5����
	 * @return
	 */
	public String forRegist(){
		this.questionList=this.getDictionaryService().getQuestionList();
		this.setDynamicUrl("/regist.jsp");
		return this.DYNAMIC;
	}

	/**
	 * @author t.anjie
	 * ע���û�
	 * @return
	 */
	public String regist(){
		this.getUserService().regist(user);
		this.setDynamicUrl("/registSuccess.jsp");
		return this.DYNAMIC;
	}

	/**
	 * @author t.anjie
	 * �û��ǳ�
	 * @return
	 */
	public String logOut(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.removeAttribute("user");
		}
		this.setDynamicUrl("/login.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author t.anjie
	 * ��ʼ���û��һ�����
	 * @return
	 */
	public String forCover(){
		System.out.println(user.getUserName());
		int count=this.userService.count(user.getUserName());
		if(count==0){
			this.setDynamicUrl("/nouser.jsp");
			return this.DYNAMIC;
		}
		user=this.userService.findCurrentUser(user.getUserName());
		this.setDynamicUrl("/User_forRecover.action?user.userId="+user.getUserId());
		return this.MYREDIRCT;
	}
	
	/**
	 * @author t.anjie
	 * ����������֤
	 * @return
	 */
	public String forRecover(){
		user=this.getUserService().findById(user.getUserId());
		user.setDquestion(this.dictionaryService.findQuestion(user.getQuestion()));
		this.setDynamicUrl("/recover.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author t.anjie
	 * �û������ڼ�⣬ajax��֤
	 * @return
	 */
	public String checkName(){
		num=this.userService.count(user.getUserName());
		//System.out.println(num);
		return "ajax";
	}
	
	/**
	 * @author t.anjie
	 * ��ʼ�������޸�����
	 * @return
	 */
	public String forChangePassword(){
		user=this.userService.findCurrentUser(user.getUserName());
		if(this.userService.correctAnswer(user)){
			this.setDynamicUrl("/User_forChange.action?user.userId="+user.getUserId());
			return this.MYREDIRCT;
		}
		else
			this.setDynamicUrl("answerFail.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author t.anjie
	 * ���������޸�
	 * @return
	 */
	public String forChange(){
		user=this.getUserService().findById(user.getUserId());
		this.setDynamicUrl("changepassword.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author t.anjie
	 * �����¼ҳ��
	 * @return
	 */
	public String forLogin(){
		this.setDynamicUrl("/login.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author t.anjie
	 * �޸�����
	 * @return
	 */
	public String changePassword(){
		this.userService.changePassword(user);
		this.setDynamicUrl("/User_forLogin.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * �����û�ע�������б�
	 * @return
	 */
	public String forQuestion(){
		questionList=this.getDictionaryService().getQuestionList();
		this.setDynamicUrl("/questionlist.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * ������Ҫ���µ��û�ע������
	 * @return
	 */
	public String findQuestionById(){
		question=this.getDictionaryService().findQuestion(question.getQusId()+"");
		this.setDynamicUrl("/questionupdate.jsp");
		return this.DYNAMIC;
	}
	
	/**
	 * @author Bobo
	 * �����û�ע������
	 * @return
	 */
	public String updateQuestion(){
		this.getDictionaryService().updateQuestion(question);
		this.setDynamicUrl("/User_forQuestion.action");
		return this.MYREDIRCT;
	}

	/**
	 * @author Bobo
	 * ɾ���û�ע������
	 * @return
	 */
	public String deleteQuestion(){
		this.getDictionaryService().deleteQuestion(question.getQusId());
		this.setDynamicUrl("/User_forQuestion.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * @author Bobo
	 * ����û�ע������
	 * @return
	 */
	public String addQuestion(){
		this.getDictionaryService().addQuestion(question);
		this.setDynamicUrl("/User_forQuestion.action");
		return this.MYREDIRCT;
	}
	
	/**
	 * get&set
	 * @return
	 */
	@JSON(serialize=false)
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getIuser() {
		return iuser;
	}

	public void setIuser(User iuser) {
		this.iuser = iuser;
	}

	public List<DQuestion> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<DQuestion> questionList) {
		this.questionList = questionList;
	}

	@JSON(serialize=false)
	public IDictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(IDictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public DQuestion getQuestion() {
		return question;
	}

	public void setQuestion(DQuestion question) {
		this.question = question;
	}
}
