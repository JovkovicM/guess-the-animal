package animals.resources;

import java.util.ListResourceBundle;

public class Messages extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                {"welcome", "Welcome to the animal’s expert system!"},
                {"greeting", new String[]{
                        "Hi!",
                        "Hello!",
                        "Hey!",
                        "Hey man!",
                        "Long time no see!",
                        "It's been a while!",
                        "Good to see you!",
                        "Nice to see you!",
                        "Yo!",
                        "Howdy!",
                        "G'day mate!",
                        "Hiya"
                }},
                {"greeting.morning", "Good morning!"},
                {"greeting.afternoon", "Good afternoon!"},
                {"greeting.evening", "Good evening!"},
                {"greeting.night", "Hi Night Owl!"},
                {"greeting.early", "Hi Early Bird!"},
                {"time.morning.start", "05:00"},
                {"time.morning.end", "12:00"},
                {"time.afternoon.start", "12:00"},
                {"time.afternoon.end", "18:00"},
                {"time.evening.start", "18:00"},
                {"time.night.end", "03:00"},
                {"time.early.start", "03:00"},
                {"time.early.end", "05:00"},
                {"christmas.date.after", "12-20"},
                {"christmas.date.before", "12-26"},
                {"farewell", new String[]{
                        "Bye!",
                        "Bye, bye!",
                        "See you later!",
                        "See you soon!",
                        "Talk to you later!",
                        "I’m off!",
                        "It was nice seeing you!",
                        "See ya!",
                        "See you later, alligator!",
                        "In a while, crocodile!",
                        "Hasta la vista, baby!",
                        "Adios, amigos!",
                        "Au revoir!",
                        "Adieu!",
                        "Have a nice one!"
                }},
                {"ask.again", new String[]{
                        "Come on, yes or no?",
                        "Please enter yes or no.",
                        "Funny, I still don’t understand, is it yes or no?",
                        "Sorry, it must be yes or no.",
                        "Let’s try again: yes or no?",
                        "I’m not sure I caught you: was it yes or no?",
                        "Oh, it’s too complicated for me: just say me yes or no.",
                        "I’m filling a bit intrigued: just say yes or no.",
                        "I am a bit confused, give me a simple answer: yes or no",
                        "Oh, no, don’t try to confuse me: say yes or no.",
                        "Could you please simply say yes or no?",
                        "Sorry, may I ask you again: was it yes or no?"
                }},
                {"animal.wantLearn", "I want to learn about animals."},
                {"animal.askFavorite", "Which animal do you like most?"},
                {"animal.nice", new String[]{
                        "Nice!",
                        "Great!",
                        "Wonderful!",
                        "Awesome!",
                        "Excellent",
                        "Marvelous"
                }},
                {"animal.learnedMuch", "I've learned so much about animals!\n"},
                {"animal.prompt", "Enter the animal:"},
                {"animal.error", "The animal should be entered in the following format:\n"
                        + "    a/an + name of the animal, for example, “an elephant”."},
                {"statement.prompt", "Specify a fact that distinguishes {0} from {1}.\n"
                        + "    The sentence should be of the format: 'It can/has/is ...'.\n"},
                {"statement.error", "The examples of a statement:\n"
                        + "                       - It can fly\n"
                        + "                       - It has horns\n"
                        + "                       - It is a mammal"},
                {"game.letsPlay", "Let's play a game!"},
                {"game.think", "You think of an animal, and I guess it."},
                {"game.enter", "Press enter when you’re ready."},
                {"game.win", "It's great that I got it right!\n"
                        + "    I didn't even hope that it would be possible to guess!"},
                {"game.giveUp", "I give up. What animal do you have in mind?"},
                {"game.isCorrect", "Is the statement correct for {0}?"},
                {"game.learned", "I have learned the following facts about animals:"},
                {"game.distinguish", "I can distinguish these animals by asking the question:"},
                {"game.thanks", new String[]{
                        "That was funny!",
                        "It was nice to play with you!",
                        "It was a pleasure for me to know you better!",
                        "Thank you for playing!",
                        "Thank you! I had too much fun!"
                }},
                {"game.again", new String[]{
                        "Want to try again?",
                        "Would you like to play again?",
                        "Do you want to repeat?",
                        "Want to play again?",
                        "One more game?",
                        "Do you want to play again?"
                }},
                {"menu.property.title", "What do you want to do:"},
                {"menu.property.exit", "Exit"},
                {"menu.property.error", "Please enter the number from 0 up to {0}"},
                {"menu.entry.play", "Play the guessing game"},
                {"menu.entry.list", "List of all animals"},
                {"menu.entry.search", "Search for an animal"},
                {"menu.entry.delete", "Delete an animal"},
                {"menu.entry.statistics", "Calculate statistics"},
                {"menu.entry.print", "Print the Knowledge Tree"},
                {"tree.list.animals", "Here are the animals (facts) I know:"},
                {"tree.list.printf", "- %1$s (%2$d)%n"},
                {"tree.search.facts", "Facts about the{0}:"},
                {"tree.search.noFacts", "No facts about the{0}."},
                {"tree.search.printf", "- %s%n"},
                {"tree.delete.root", "Can’t delete the only animal from the root."},
                {"tree.delete.successful", "The {0} was deleted from the knowledge base."},
                {"tree.delete.fail", "The {0} was not found in the knowledge base."},
                {"tree.stats.title", "The Knowledge Tree stats"},
                {"tree.stats.root", "- root node"},
                {"tree.stats.nodes", "- total number of nodes"},
                {"tree.stats.animals", "- total number of animals"},
                {"tree.stats.statements", "- total number of statements"},
                {"tree.stats.height", "- height of the tree"},
                {"tree.stats.minimum", "- minimum depth"},
                {"tree.stats.average", "- average depth"},
                {"tree.print.vertical", "│"},
                {"tree.print.branch", "├"},
                {"tree.print.corner", "└"},
                {"tree.print.printf", "%1$s%2$s %3$s%n"}
        };
    }
}
