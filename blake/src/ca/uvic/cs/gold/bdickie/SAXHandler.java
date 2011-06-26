/*
 * $Id: SAXHandler.java,v 1.2 2004/12/07 17:53:22 bdickie Exp $
 *
 * Repository Explorer and Repository Grapher
 * Copyright (C) 2004 Blake Dickie
 *
 * This program is free software; you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the Free Software 
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
 * MA 02111-1307 USA
 *
 */

package ca.uvic.cs.gold.bdickie;


import org.xml.sax.helpers.*;
import org.xml.sax.*;

/** A SAX Handler that keeps track of if an error occured.
 * @author Blake Dickie
 */
public class SAXHandler extends DefaultHandler {
    private boolean m_error;
    
    //*********************** CONSTRUCTORS ************************
    
    /** Creates a new instance of SAXHandler */
    public SAXHandler() {
        m_error = false;
    }
    
    //*********************** PUBLIC METHODS **********************
    
    /** Checks if an error occured.
     */
    public boolean isError() {
        return m_error;
    }
    
    /** Handler for an error.
     */
    public void error(SAXParseException e) {
        ErrorLog.reportError("Error parsing XML file.", e.getMessage(), true);
        m_error = true;
    }
    
    /** Handler for a fatal error.
     */
    public void fatalError(SAXParseException e) {
        ErrorLog.reportError("Error parsing XML file.", e.getMessage(), true);
        m_error = true;
    }
    
    /** Handler for a warning.
     */
    public void warning(SAXParseException e) {
        ErrorLog.reportError("Error parsing XML file.", e.getMessage(), true);
        m_error = true;
    }
}

/* ChangeLog:
 *   $Log: SAXHandler.java,v $
 *   Revision 1.2  2004/12/07 17:53:22  bdickie
 *   Done Repository Grapher and added GPL boilerplate to older files.
 *
 *   Revision 1.1  2004/10/31 23:43:51  bdickie
 *   Done prelimiary version of repository explorer.
 *
 */