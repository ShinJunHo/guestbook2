package com.hanains.guestbook.http.action;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory{
	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		Action action = null;
		
		if("add".equals(actionName)){
			action = new AddAction();
		}else if("deleteform".equals(actionName)){
			action = new DeleteformAction();
		}else if("delete".equals(actionName)){
			action = new DeleteAction();
		}else{
			action = new IndexAction();
		}
		
		
		return action;
	}
}
