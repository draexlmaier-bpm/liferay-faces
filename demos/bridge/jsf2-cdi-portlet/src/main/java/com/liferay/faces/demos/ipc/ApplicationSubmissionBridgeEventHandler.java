package com.liferay.faces.demos.ipc;

import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.EventResponse;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.liferay.cdi.portlet.bridge.CDIBeanManagerUtil;
import com.liferay.faces.demos.bean.ApplicantBackingBean;
import com.liferay.faces.demos.bean.ApplicationSubmissionBean;

public class ApplicationSubmissionBridgeEventHandler implements BridgeEventHandler
{
//    @Inject
//    private Instance<Conversation> conversationInstance;
//    
//    @Inject
//    private Instance<ApplicationSubmissionBean> applicationSubmissionBeanInstance;
//    
//    public ApplicationSubmissionBridgeEventHandler()
//    {
//        BeanProvider.injectFields(this);
//    }

    @Override
    public EventNavigationResult handleEvent(FacesContext facesContext, Event event)
    {
        if(ApplicantBackingBean.QNAME_EVENT.equals(event.getQName()))
        {
            ApplicationSubmissionBean applicationSubmissionBean = (ApplicationSubmissionBean)CDIBeanManagerUtil.getManagedBeanReference(ApplicationSubmissionBean.class);
            applicationSubmissionBean.setApplicant((String)event.getValue());
            
            EventResponse evenResponse = (EventResponse) facesContext.getExternalContext().getResponse();
            evenResponse.setRenderParameter("startConversation", "true");
            
//            conversationInstance.get().begin();
//            
//            applicationSubmissionBeanInstance.get().setApplicant((String)event.getValue());
        }
        
        return new EventNavigationResult();
    }
    
    
}
