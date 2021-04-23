package animals.engine;

import animals.util.ScannerUtil;
import animals.knowledge.KnowledgeTree;

import java.text.MessageFormat;

import static animals.util.UserCommunicationUtil.*;
import static animals.knowledge.KnowledgeTreeRepository.appMessageResource;

public class Game {

    public static void run(String[] args) {
        greetUser();

        KnowledgeTree knowledgeTree = new KnowledgeTree();
        knowledgeTree.load(args);

        boolean exit = false;
        while (!exit) {
            printMenu();
            String option = ScannerUtil.getInstance().nextLine();
            switch (option) {
                case "1":
                    knowledgeTree.startGuessing();
                    break;
                case "2":
                    knowledgeTree.printAllKnownAnimals();
                    break;
                case "3":
                    knowledgeTree.searchForAnimal();
                    break;
                case "4":
                    knowledgeTree.printStats();
                    break;
                case "5":
                    knowledgeTree.printKnowledgeTree();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println(MessageFormat.format(
                            appMessageResource.getString("menu.property.error"), 5));
            }
        }
        farewellUser();
    }
}
