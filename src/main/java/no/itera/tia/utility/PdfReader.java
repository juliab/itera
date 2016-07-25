package no.itera.tia.utility;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import no.itera.tia.exceptions.TestException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class PdfReader {

    /**
     * Reads pdf document from stream.
     * 
     * @param stream Input stream
     * @return Pdf plain text content
     * @throws TestException If parsing wasn't successful
     */
    public static String read(InputStream stream) {
        try (PDDocument doc = PDDocument.load(stream)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(doc);
        } catch (IOException e) {
            throw TestException.get("Can't parse pdf", e);
        }
    }

    /**
     * Reads pdf document from file.
     * 
     * @param filePath Path to pdf document, relative to resources folder, e.g 'downloads/file.pdf'
     * @return Pdf plain text content
     * @throws TestException If pdf file cannot be found
     */
    public static String read(String filePath) {
        try {
            return read(new FileInputStream(new File(filePath)));
        } catch (FileNotFoundException e) {
            throw TestException.get("File " + filePath + " not found", e);
        }
    }
}
