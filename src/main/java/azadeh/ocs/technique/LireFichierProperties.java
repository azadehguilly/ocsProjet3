package azadeh.ocs.technique;

import azadeh.ocs.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static azadeh.ocs.App.nbCase;
import static azadeh.ocs.App.nbEssais;
import static azadeh.ocs.App.modeDeveloppeur;
import static azadeh.ocs.App.symbolsRechercheTable;
import static azadeh.ocs.App.symbolsMastermindTable;


/**
 * Cette classe LireFichierProperties, permet de lire le fichier properties et importer les variables.
 *
 * @author Azadeh GUILLY
 * @version 1.0
 */
public class LireFichierProperties {

    /**
     * LOGGER pour loger dans un ficher les points essentiel à tracer pour pouvoir gerer les erreur, les bugs et les infos.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(LireFichierProperties.class.getName());

    /**
     * Importer les variables du fichier parametre et alimenter les attributs static du jeu
     */
    public void importerLesParametres() {
        Properties prop = new Properties();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        InputStream input = null;

        //Importer les valeur de fichier config.properties
        try {
            //input = new FileInputStream("C:/DEV_AZADEH/ocsProjet3/src/main/resources/config.properties");
            input = classLoader.getResourceAsStream("config.properties");
            // load le fichier properties
            prop.load(input);

            nbCase = Integer.valueOf(prop.getProperty("nbCase"));
            nbEssais = Integer.valueOf(prop.getProperty("nbEssais"));
            String symbolsRecherche = prop.getProperty("symbolsRecherche");
            String symbolsMastermind = prop.getProperty("symbolsMastermind");
            modeDeveloppeur = Boolean.valueOf(prop.getProperty("modeDeveloppeur"));

            symbolsRechercheTable = symbolsRecherche.split(",");
            symbolsMastermindTable = symbolsMastermind.split(",");


            LOGGER.debug("nbCase " + nbCase);
            LOGGER.debug("nbEssais " + nbEssais);
            LOGGER.debug("modeDeveloppeur " + modeDeveloppeur);
            LOGGER.debug("symbolsRecherche " + symbolsRecherche);
            LOGGER.debug("symbolsMastermind " + symbolsMastermind);


        } catch (IOException ex) {
            ex.printStackTrace();
            LOGGER.error("Il y a eu un problème pendant le chargement du fichier config.properties");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("Il y a eu un problème à la fermeture du fichier config.properties");
                }
            }
        }
    }
}
