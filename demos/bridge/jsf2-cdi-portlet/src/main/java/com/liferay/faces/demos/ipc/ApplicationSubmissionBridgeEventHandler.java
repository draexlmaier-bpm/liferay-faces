package com.liferay.faces.demos.ipc;

import javax.enterprise.context.Conversation;
import javax.enterprise.inject.Instance;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import org.apache.deltaspike.core.api.provider.BeanProvider;

import com.liferay.faces.demos.bean.ApplicantBackingBean;
import com.liferay.faces.demos.bean.ApplicationSubmissionBean;

public class ApplicationSubmissionBridgeEventHandler implements BridgeEventHandler
{
    @Inject
    private Instance<Conversation> conversationInstance;
    
    @Inject
    private Instance<ApplicationSubmissionBean> applicationSubmissionBeanInstance;
    
    public ApplicationSubmissionBridgeEventHandler()
    {
        BeanProvider.injectFields(this);
    }

    @Override
    public EventNavigationResult handleEvent(FacesContext facesContext, Event event)
    {
        if(ApplicantBackingBean.QNAME_EVENT.equals(event.getQName()))
        {
            conversationInstance.get().begin();
            
            applicationSubmissionBeanInstance.get().setApplicant((String)event.getValue());
        }
        
        return new EventNavigationResult();
    }
    
    
}
