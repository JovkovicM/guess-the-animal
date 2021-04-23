package animals.resources;

import java.util.ListResourceBundle;

public class Messages_eo extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][] {
                {"welcome", "Bonvenon al la sperta sistemo de la besto!"},
                {"greeting", new String[] {
                        "Saluton!"
                }},
                {"greeting.morning", "Bonan matenon!"},
                {"greeting.afternoon", "Bonan tagon!"},
                {"greeting.evening", "Bonan vesperon!"},
                {"greeting.night", "Saluton Nokta Strigo!"},
                {"greeting.early", "Saluton Frua Birdo!"},
                {"greeting.morning", "Bonan matenon!"},
                {"greeting.afternoon", "Bonan tagon!"},
                {"greeting.evening", "Bonan vesperon!"},
                {"greeting.night", "Saluton Nokta Strigo!"},
                {"greeting.early", "Saluton Frua Birdo!"},
                {"time.morning.start", "05:00"},
                {"time.morning.end", "12:00"},
                {"time.afternoon.start", "12:00"},
                {"time.afternoon.end", "18:00"},
                {"time.evening.start", "18:00"},
                {"time.night.end", "03:00"},
                {"time.early.start", "03:00"},
                {"time.early.end", "05:00"},

                {"farewell", new String[]{
                        "Ĝis!",
                        "Ĝis revido!",
                        "Estis agrable vidi vin!"
                }},
                {"ask.again", new String[]{
                        "Bonvolu enigi jes aŭ ne.",
                        "Amuze, mi ankoraŭ ne komprenas, ĉu jes aŭ ne?",
                        "Pardonu, devas esti jes aŭ ne.",
                        "Ni provu denove: ĉu jes aŭ ne?",
                        "Pardonu, ĉu mi rajtas demandi vin denove: ĉu tio estis jes aŭ ne?"
                }},
                {"animal.wantLearn", "Mi volas lerni pri bestoj."},
                {"animal.askFavorite", "Kiun beston vi plej ŝatas?"},
                {"animal.nice", new String[] {
                        "Bela!",
                        "Mirinde!",
                        "Mojosa!",
                        "Bonege!",
                        "Mirinda!"
                }},
                {"animal.learnedMuch", "Mi lernis tiom multe pri bestoj!\n"},
                {"animal.prompt", "Enigu la nomon de besto:"},
                {"animal.error", "La besto devas esti enmetita en la jenan formaton: \n"
                        + "    nomo de la besto, ekzemple, \"elefanto\"."},
                {"statement.prompt", "Indiku fakton, kiu distingas {0} de {1}.\n"
                        + "    La frazo devas esti de la formato: 'Ĝi ...'.\n"},
                {"statement.error", "La ekzemploj de aserto:\n"
                        + "                       - Ĝi povas flugi\n"
                        + "                       - Ĝi havas kornojn\n"
                        + "                       - Ĝi estas mamulo"},
                {"game.letsPlay", "Ni ludu!"},
                {"game.think", "Vi pensu pri besto, kaj mi divenos ĝin."},
                {"game.enter", "Premu enen kiam vi pretas."},
                {"game.win", "Bonege, ke mi trafis ĝin ĝuste!"},
                {"game.giveUp", "Mi rezignas. Kiun beston vi havas en la kapo?"},
                {"game.isCorrect", "Ĉu la aserto ĝustas por la {0}?"},
                {"game.learned", "Mi lernis la jenajn faktojn pri bestoj:"},
                {"game.distinguish", "Mi povas distingi ĉi tiujn bestojn per la demando:"},
                {"game.thanks", new String[] {
                        "Tio estis amuza!",
                        "Estis agrable ludi kun vi!",
                        "Dankon pro ludado!",
                        "Dankon! Mi tro amuziĝis!"
                }},
                {"game.again", new String[] {
                        "Ĉu vi volas provi denove?",
                        "Ĉu vi ŝatas ludi denove?",
                        "Ĉu vi volas ripeti?",
                        "Ĉu vi volas ludi denove?",
                        "Ankoraŭ unu ludo?"
                }},
                {"menu.property.title", "Kion vi volas fari:"},
                {"menu.property.exit", "Eliri"},
                {"menu.property.error", "Bonvolu enigi numeron de 0 ĝis {0}"},
                {"menu.entry.play", "Ludi la divenludon"},
                {"menu.entry.list", "Listo de ĉiuj bestoj"},
                {"menu.entry.search", "Serĉi beston"},
                {"menu.entry.delete", "Forigi beston"},
                {"menu.entry.statistics", "Kalkuli statistikojn"},
                {"menu.entry.print", "Printi la Sciarbon"},
                {"tree.list.animals", "Jen la bestoj, kiujn mi konas:"},
                {"tree.list.printf", "- %1$s (%2$d)%n"},
                {"tree.search.facts", "Faktoj pri la {0}:"},
                {"tree.search.noFacts", "Neniuj faktoj pri la {0}."},
                {"tree.search.printf", "- %s%n"},
                {"tree.delete.root", "Ne eblas forigi la solan beston de la radiko."},
                {"tree.delete.successful", "La {0} estis forigita de la sciobazo."},
                {"tree.delete.fail", "La {0} ne troviĝis en la sciobazo."},
                {"tree.stats.title", "La statistiko de la Scio-Arbo"},
                {"tree.stats.root", "- radika nodo"},
                {"tree.stats.nodes", "- totala nombro de nodoj"},
                {"tree.stats.animals", "- totala nombro de bestoj"},
                {"tree.stats.statements", "- totala nombro de deklaroj"},
                {"tree.stats.height", "- alteco de la arbo"},
                {"tree.stats.minimum", "- minimuma profundo"},
                {"tree.stats.average", "- averaĝa profundo"},
                {"tree.print.vertical", "│"},
                {"tree.print.branch", "├"},
                {"tree.print.corner", "└"},
                {"tree.print.printf", "%1$s%2$s %3$s%n"}
        };
    }
}
