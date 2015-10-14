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

package org.opencms.search.extractors;

import java.io.InputStream;

import org.apache.tika.parser.microsoft.OfficeParser;

/**
 * Extracts text data from a VFS resource that is an OLE 2 MS Office document.<p>
 *
 * Supported formats are MS Word (.doc), MS PowerPoint (.ppt) and MS Excel (.xls).<p>
 *
 * The OLE 2 format was introduced in Microsoft Office version 97 and was the default format until Office version 2007
 * and the new XML-based OOXML format.<p>
 *
 * @since 8.0.1
 */
public final class CmsExtractorMsOfficeOLE2 extends A_CmsTextExtractor {

    /** Static member instance of the extractor. */
    private static final CmsExtractorMsOfficeOLE2 INSTANCE = new CmsExtractorMsOfficeOLE2();

    /**
     * Hide the public constructor.<p>
     */
    private CmsExtractorMsOfficeOLE2() {

        // noop
    }

    /**
     * Returns an instance of this text extractor.<p>
     *
     * @return an instance of this text extractor
     */
    public static I_CmsTextExtractor getExtractor() {

        return INSTANCE;
    }

    /**
     * @see org.opencms.search.extractors.I_CmsTextExtractor#extractText(java.io.InputStream, java.lang.String)
     */
    @Override
    public I_CmsExtractionResult extractText(InputStream in) throws Exception {

        return extractText(in, new OfficeParser());
    }
}