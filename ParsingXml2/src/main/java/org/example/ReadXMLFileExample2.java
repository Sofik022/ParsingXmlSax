package org.example;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class ReadXMLFileExample2
{
    public static void main(String args[])
    {
        try
        {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler()
            {
                boolean id = false;
                boolean employeeId = false;
                boolean Name = false;
                boolean deptId = false;
                //parser starts parsing a specific element inside the document
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
                {
                    System.out.println("Start Element :" + qName);
                    if(qName.equalsIgnoreCase("Id"))
                    {
                        id=true;
                    }
                    if (qName.equalsIgnoreCase("employeeId"))
                    {
                        employeeId = true;
                    }
                    if (qName.equalsIgnoreCase("Name"))
                    {
                        Name = true;
                    }
                    if (qName.equalsIgnoreCase("deptId"))
                    {
                        deptId = true;
                    }
                }
                //parser ends parsing the specific element inside the document
                public void endElement(String uri, String localName, String qName) throws SAXException
                {
                    System.out.println("End Element:" + qName);
                }
                //reads the text value of the currently parsed element
                public void characters(char ch[], int start, int length) throws SAXException
                {
                    if (id)
                    {
                        System.out.println("ID : " + new String(ch, start, length));
                        id = false;
                    }
                    if (employeeId)
                    {
                        System.out.println("employeeId: " + new String(ch, start, length));
                        employeeId = false;
                    }
                    if (Name)
                    {
                        System.out.println("Last Name: " + new String(ch, start, length));
                        Name = false;
                    }
                    if (deptId)
                    {
                        System.out.println("Subject: " + new String(ch, start, length));
                        deptId = false;
                    }
                }
            };
            saxParser.parse("C:\\Users\\sophi\\Downloads\\Employee.xml", handler);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}