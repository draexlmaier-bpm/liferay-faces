package com.liferay.faces.demos.portlet;

import java.io.IOException;

import javax.enterprise.context.Conversation;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.faces.GenericFacesPortlet;

import com.liferay.cdi.portlet.bridge.CDIBeanManagerUtil;

public class JSDF2CDIReceivePortlet extends GenericFacesPortlet
{
    @Override
    protected void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException,
            IOException
    {
        if("true".equals(renderRequest.getParameter("startConversation")))
        {
            ((Conversation)CDIBeanManagerUtil.getManagedBeanReference(Conversation.class)).begin();
        }
        
        super.doView(renderRequest, renderResponse);
    }

}
