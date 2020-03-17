/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author School
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws lab5.InvalidCatalogException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, InvalidCatalogException, FileNotFoundException, ClassNotFoundException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog
                = new Catalog("Java Resources", "E:\\Fac\\2\\Programare Avansata\\Lab5\\catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws InvalidCatalogException, IOException, FileNotFoundException, ClassNotFoundException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("E:\\Fac\\2\\Programare Avansata\\Lab5\\catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }
}
