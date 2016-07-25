package no.itera.tia.unmarshalling;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.TransformerFactoryConfigurationError;

import no.itera.tia.beans.Entity;
import no.itera.tia.exceptions.TestException;

/**
 * This class executes unmarshalling of test entities from xml format.
 */
public final class EntityConverter {

    /**
     * Executes unmarshalling and returns entity object. Object state is read from xml format.
     * 
     * @param fileName File name, relative to resources path, e.g 'test_data/customer.xml'
     * @param entity Entity class to be instantiated and returned
     * @return Entity object
     * @throws TestException If unmarshalling failed or if resource could not be found
     */
    public static <T extends Entity> T convert(String fileName, Class<T> entity) {
        InputStream stream = ResourceConverter.toStream(fileName);

        T object;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(entity);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = entity.cast(jaxbUnmarshaller.unmarshal(stream));
        } catch (JAXBException | TransformerFactoryConfigurationError exception) {
            throw TestException.get("Error on unmarshalling " + entity.getName() + " object from file " 
                    + fileName, exception);
        } catch (ClassCastException exception) {
            throw TestException.get("Can't unmarshall object " + entity.getName() 
                + " from file " + fileName + ". Types are incompatible. \n", exception);
        }

        return object;
    }
}
