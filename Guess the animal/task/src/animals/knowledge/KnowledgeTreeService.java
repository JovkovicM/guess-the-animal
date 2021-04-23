package animals.knowledge;

public interface KnowledgeTreeService {

    void load(String[] args);
    void save();
    void startGuessing();
    void printAllKnownAnimals();
    void searchForAnimal();
    void printStats();
    void printKnowledgeTree();

}
