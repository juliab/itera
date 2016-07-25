package no.itera.tia.unmarshalling;

import java.io.InputStream;

import no.itera.tia.exceptions.TestException;

/**
 * This class purpose is to convert resource to input stream.
 */
public final class ResourceConverter {
	
    /**
     * Returns an input stream for reading the specified resource.
     * 
     * @param fileName The resource name
     * @return An input stream for reading the resource
     * @throws TestException If resource could not be found 
     */
	public static InputStream toStream(String fileName) {
	    InputStream stream = ResourceConverter.class.getClassLoader().getResourceAsStream(fileName);
	    if (stream != null) {
	        return stream;
	    }
		throw TestException.get("File " + fileName + " cannot be found");
	}
}
