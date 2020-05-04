package controllers;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class AfficheList extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("test1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test2");
		return EVAL_BODY_AGAIN;
	}

}
