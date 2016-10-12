package exercise.pages;


import org.apache.commons.io.FilenameUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ETLPage {

    private static List<String> outputHeaders =  new ArrayList<String>(
            Arrays.asList("id", "date","src_acc","dest_acc","type","amount","ccy"));

    private ETLPage() {
    }

    public static void upload(List<String> files){
        ArrayList<Transaction> allTransactions = new ArrayList<>();
        for (String file : files){
            ArrayList<Transaction> transactions = parseFile(file);
            allTransactions.addAll(transactions);
        }

        try {
            generateXmlFile(allTransactions);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateXmlFile(ArrayList<Transaction> allTransactions) throws ParserConfigurationException, TransformerException, FileNotFoundException, UnsupportedEncodingException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.newDocument();

        Element rootElement = document.createElement("txns");
        document.appendChild(rootElement);

        for (Transaction transaction : allTransactions){
            Element childElement = document.createElement("txn");
            rootElement.appendChild(childElement);

            for (String header : outputHeaders) {
                Element current = document.createElement(header);
                current.appendChild(document.createTextNode(transaction.getValue(header)));
                childElement.appendChild(current);
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        Writer output = new StringWriter();
        transformer.transform(new DOMSource(document), new StreamResult(output));
        PrintWriter writer = new PrintWriter("src/test/resources/output.xml", "UTF-8");
        writer.println(output.toString());
        writer.close();
    }

    private static ArrayList<Transaction> parseFile(String filePath) {
        String fileExtension = fileExtension(filePath);
        if (fileExtension.contains("csv")) {
            return cvsParser(filePath);
        } else if (fileExtension.contains("txt")) {
            return txtParser(filePath);
        } else {
            return new ArrayList<>();
        }
    }

    private static String fileExtension(String filePath) {
        return FilenameUtils.getExtension("src/test/resources/" + filePath);
    }

    private static ArrayList<Transaction> txtParser(String filePath) {

        ArrayList<Transaction> transactions = new ArrayList<>();
        String csvFile = "src/test/resources/" + filePath;
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] rawTransactions = line.split("\\s+");
                transactions.add(new Transaction(rawTransactions));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return transactions;
    }

    private static ArrayList<Transaction> cvsParser(String filePath) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        String csvFile = "src/test/resources/" + filePath;
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {
            br = new BufferedReader(new FileReader(csvFile));
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine){
                    firstLine = false;
                    continue;
                }
                String[] rawTransactions = line.split(cvsSplitBy);
                transactions.add(new Transaction(rawTransactions));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return transactions;
    }
}
