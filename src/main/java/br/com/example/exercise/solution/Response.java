package br.com.example.exercise.solution;

import br.com.example.exercise.model.Country;
import com.google.gson.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class Response {
    private static final String FILE_NAME = "country_languages.json";
    private static final String PATH_NAME = "src/main/resources/";

    private static List<Country> listCountry;

    private static String[] arrayLanguage;

    public static void exercise1(Integer number) {
        if(number%3==0 && number%5==0){
            System.out.print("Visual Nuts");
        } else if (number%3==0) {
            System.out.print("Visual");
        } else if (number%5==0) {
            System.out.print("Nuts");
        } else {
            System.out.print(number);
        }
    }

    public static void exercise2() throws IOException {
        InputStream initialStream = Files.newInputStream(new File(PATH_NAME + FILE_NAME).toPath());

        if (initialStream == null) {
            throw new IOException("File not found in classpath.");
        }

        Reader reader = new InputStreamReader(initialStream);
        JsonElement tree = JsonParser.parseReader(reader);

        JsonArray array = tree.getAsJsonArray();

        System.out.println("Number of countries is " + array.size() + " .");
        System.out.println("The "+ countryMostLanguages(array) +" is the country with the most official languages and speak German.");
        countLanguageCounty(listCountry);
        totalOfficialLanguages(arrayLanguage);
        highestNumberLanguages(listCountry);
        commonOfficialLanguages(arrayLanguage);
    }

    private static String countryMostLanguages(JsonArray array) {
        listCountry = new ArrayList<Country>();
        List listaLanguage = new ArrayList();

        arrayLanguage = (String[]) listaLanguage.toArray(new String[0]);
        Locale obj = new Locale("", "");
        String countryName="";
        String languageCode="";
        int largerAmount = 0;

        for (JsonElement element : array) {
            if (element.isJsonObject()) {
                JsonObject jsonObject = element.getAsJsonObject();
                //System.out.println(jsonObject.get("country").getAsString());
                Country country = new Country();
                country.setCode(jsonObject.get("country").getAsString());

                obj = new Locale("", country.getCode());
                country.setName(obj.getDisplayCountry());

                JsonArray language = jsonObject.getAsJsonArray("languages");
                List idiom = language.asList();
                List languages = new ArrayList();
                for (Object temp : idiom) {
                    languageCode = temp.toString().replace("\"","");
                    languages.add(languageCode);
                    listaLanguage.add(languageCode);
                    if(languageCode.equals("de") && language.size() > largerAmount){
                        countryName = country.getName();
                        largerAmount = language.size();
                    }
                    //System.out.println(languageCode);
                }
                country.setLanguages(languages);
                listCountry.add(country);
            }
        }
        arrayLanguage = (String[]) listaLanguage.toArray(new String[0]);
        //System.out.println(languageCode);
        return countryName;
    }

    private static void countLanguageCounty(List<Country> countries) {
        for (Country countryElement : countries) {
            System.out.println(countryElement.getName() +" country has " + countryElement.getLanguages().size() +" languages.");
        }
    }

    private static void totalOfficialLanguages(String[] arrayLanguage) {
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(arrayLanguage));
        String[] uniqueArr = new String[uniqueSet.size()];
        int i = 0;
        for (String str : uniqueSet) {
            uniqueArr[i++] = str;
        }
        System.out.println("The total of official languages is " + uniqueArr.length +" .");
    }

    private static void highestNumberLanguages(List<Country> countries) {
        Integer largerAmount = 0;
        String countryName= "";
        for (Country countryElement : countries) {
            if(countryElement.getLanguages().size() > largerAmount){
                countryName = countryElement.getName();
                largerAmount = countryElement.getLanguages().size();
            }
        }
        System.out.println("The "+ countryName +" country is the country with the highest number of official languages.");
    }

    private static void commonOfficialLanguages(String[] arrayLanguage) {
        Map<String, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < arrayLanguage.length; i++) {
            int freq = freqMap.getOrDefault(arrayLanguage[i], 0) + 1;
            freqMap.put(arrayLanguage[i], freq);
            maxFreq = Math.max(maxFreq, freq);
        }
        List<String> modaList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFreq) {
                modaList.add(entry.getKey());
            }
        }
        String[] modaArr = new String[modaList.size()];
        for (int i = 0; i < modaList.size(); i++) {
            modaArr[i] = modaList.get(i);
        }

        System.out.print("The most common official language(s): ");

        Locale obj = new Locale("", "");

        for (int i = 0; i < modaArr.length; i++) {
            obj = new Locale(modaArr[i], "");
            System.out.print(obj.getDisplayLanguage() + " ");
        }
        System.out.println(" ");
    }

}
