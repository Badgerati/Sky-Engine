package sky.engine.io.xml;

import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;

/**
 * 
 * 
 * @author Matthew Kelly (Badgerati - Cadaeic Studios)
 *
 */
public class XMLParser extends DefaultHandler
{
	
	/**
	 * name of the file this manager is associated with
	 */
	protected String filename;
	
	
	/**
	 * context to help read/write files
	 */
	protected Context context = null;
	
	
	
	
	
	
	/**
	 * 
	 */
	public XMLParser(Context context, String filename)
	{
		this.filename = filename;
		this.context = context;
	}
	
	
	
	
	
	/**
	 * 
	 */
	public void parse()
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		try
		{
			InputStream is = context.openFileInput(filename);
			
			SAXParser parser = factory.newSAXParser();
			parser.parse(is, this);
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes)
		throws SAXException
	{
		return;
	}
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void endElement(String uri, String localName, String name)
		throws SAXException
	{
		return;
	}
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void startDocument() throws SAXException
	{
		return;
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void endDocument() throws SAXException
	{
		return;
	}
	
	
	
	
	
	/**
	 * 
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException
	{
		return;
	}
	
}
