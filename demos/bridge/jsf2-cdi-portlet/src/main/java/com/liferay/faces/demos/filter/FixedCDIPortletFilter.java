package com.liferay.faces.demos.filter;

import java.io.IOException;

import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;

import com.liferay.cdi.portlet.bridge.CDIRequestFactory;
import com.liferay.cdi.portlet.bridge.CDIResponseFactory;

public class FixedCDIPortletFilter extends com.liferay.cdi.portlet.bridge.CDIPortletFilter implements EventFilter {

    @Override
    public void doFilter(
            EventRequest eventRequest, EventResponse eventResponse,
            FilterChain filterChain)
        throws IOException, PortletException {
        
        CDIRequestFactory cdiRequestFactory = getCDIRequestFactory();

        eventRequest = cdiRequestFactory.getCDIEventRequest(eventRequest);

        CDIResponseFactory cdiResponseFactory = getCDIResponseFactory();

        eventResponse = cdiResponseFactory.getCDIEventResponse(
            eventResponse, eventRequest.getLocale());

        filterChain.doFilter(eventRequest, eventResponse);
    }
}