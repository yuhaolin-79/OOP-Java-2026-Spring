import java.io.*;

/**
 * Declares a method for obtaining a product catalog from a file.
 */
public interface CatalogLoader {

    /**
     * Loads the information in the specified file into a product catalog.
     *
     * @param fileName the name of a file that contains catalog information
     * @return a product catalog
     * @throws FileNotFoundException if the specified file does not exist
     * @throws IOException           if there is an error reading the file
     * @throws DataFormatException   if the file contains badly-formed data
     */
    Catalog loadCatalog(String fileName)
            throws FileNotFoundException, IOException, DataFormatException;
}
