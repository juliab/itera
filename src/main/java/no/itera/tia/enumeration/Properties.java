package no.itera.tia.enumeration;

// TODO take this out to property file
public interface Properties {

    String FILE_SEPARATOR = System.getProperty("file.separator");
    String DOWNLOADS_PATH = System.getProperty("downloads.folder");
    String TEST_DATA_PATH = "test_data" + FILE_SEPARATOR;
    String RESOURCE_PROPERTIES_PATH = "properties" + FILE_SEPARATOR;
}
