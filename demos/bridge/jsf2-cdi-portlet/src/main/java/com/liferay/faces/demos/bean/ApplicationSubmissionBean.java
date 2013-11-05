package com.liferay.faces.demos.bean;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ApplicationSubmissionBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Inject
    private transient Conversation conversation;
    
    private String applicant;

    public String getApplicant()
    {
        return this.applicant;
    }
    
    public void setApplicant(String applicant)
    {
        this.applicant = applicant;
    }
    
    public void acknowledge()
    {
        this.applicant = null;
        
        conversation.end();
    }
}
