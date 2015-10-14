/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software GmbH, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.workplace.tools.content;

import org.opencms.jsp.CmsJspActionElement;
import org.opencms.report.I_CmsReportThread;
import org.opencms.workplace.list.A_CmsListReport;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

/**
 * Provides a report for changing the Locale of page elements.<p>
 *
 * @since 6.0.1
 */
public class CmsElementChangeLocaleReport extends A_CmsListReport {

    /** Request parameter name for the class name to get the dialog object from. */
    public static final String PARAM_CLASSNAME = "classname";

    /** Request parameter for the class name to get the dialog object from. */
    private String m_paramClassname;

    /**
     * Public constructor with JSP action element.<p>
     *
     * @param jsp an initialized JSP action element
     */
    public CmsElementChangeLocaleReport(CmsJspActionElement jsp) {

        super(jsp);
    }

    /**
     * Public constructor with JSP variables.<p>
     *
     * @param context the JSP page context
     * @param req the JSP request
     * @param res the JSP response
     */
    public CmsElementChangeLocaleReport(PageContext context, HttpServletRequest req, HttpServletResponse res) {

        this(new CmsJspActionElement(context, req, res));
    }

    /**
     * Returns the request parameter value for the class name to get the dialog object from.<p>
     *
     * @return the request parameter value for the class name to get the dialog object from
     */
    public String getParamClassname() {

        return m_paramClassname;
    }

    /**
     *
     * @see org.opencms.workplace.list.A_CmsListReport#initializeThread()
     */
    @Override
    public I_CmsReportThread initializeThread() {

        CmsElementChangeLocaleSettings settings = (CmsElementChangeLocaleSettings)((Map)getSettings().getDialogObject()).get(
            getParamClassname());

        I_CmsReportThread changeThread = new CmsChangeElementLocaleThread(getCms(), settings);

        return changeThread;
    }

    /**
     * Sets the request parameter value for the class name to get the dialog object from.<p>
     *
     * @param className the request parameter value for the class name to get the dialog object from
     */
    public void setParamClassname(String className) {

        m_paramClassname = className;
    }

}