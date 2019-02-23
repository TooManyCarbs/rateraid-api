package com.rateraid.rateraidapi.core;

import com.rateraid.rateraidapi.media.*;
import com.rateraid.rateraidapi.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final BookRepository books;
    private final GameRepository games;
    private final TvSeriesRepository tvSeries;
    private final MovieRepository movies;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(
            BookRepository books,
            GameRepository games,
            TvSeriesRepository tvSeries,
            MovieRepository movies,
            UserRepository users) {
        this.books = books;
        this.games = games;
        this.tvSeries = tvSeries;
        this.movies = movies;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) {

        String[] bookNames = {
                "Horse Of The East",
                "Rebel With Money",
                "Hunters Of The Gods",
                "Kings With Honor",
                "Butchers And Lions",
                "Foreigners And Lords",
                "Demise Without Fear",
                "Fate Of My Imagination",
                "Running In The Beginning",
                "Breath Of The Demons"
        };

        String[] authors = {
                "Anthony Spencer",
                "Jeremiah Richards",
                "Nichole Hammond",
                "Emma Curry",
                "Alton Bennett",
                "Rodney Guzman",
                "Lloyd Fowler",
                "Juanita Romero",
                "Amos Schmidt",
                "Ollie Munoz"
        };

        List<Book> bunchOfBooks = new ArrayList<>();
        for (int i = 0; i < bookNames.length; i++) {
            bunchOfBooks.add(new Book(bookNames[i], authors[i]));
        }

        books.saveAll(bunchOfBooks);

        String[] movieTitles = {
                "Extreme Extermination",
                "War for Extremism",
                "Infinite Punishment",
                "Double Retreat",
                "Triple Surrender",
                "Terminal Termination",
                "Fist of Prejudice",
                "Instant Honor",
                "Duke of Retaliation",
                "Inferno of Death"
        };

        List<Movie> bunchOfMovies = new ArrayList<>();
        for (int i = 0; i < movieTitles.length; i++) {
            bunchOfMovies.add(new Movie(movieTitles[i]));
        }

        String[] gameTitles = {
                "Chrome Campaign",
                "Fury Harvest",
                "Struggle of Democracy",
                "Crush of Vengeance",
                "Crisis and Battle",
                "Duty and Sacrifice",
                "Fusefire",
                "Fusioncraft",
                "Astroback",
                "Archewind"
        };

        String[] gameDescriptions = {
                "The rough life of a elderly man changes for better or worse as a strange boy enters his life."
                        + "The strange boy claims the elderly man has been corrupted by evil, something which has happened at birth and something which happens to a lot of people. The evil remains harmless until fully grown, but once it reaches maturity true evil will take over the mind. Fortunately there's a way to cleanse the body of this evil. Suspicious of this situation, but somewhat trusting of this strange boy, the elderly man cautiously agrees to the proposal, the situation is all too strange, it's best to get more information as soon as possible."
                        + "But what if this strange boy is pulling a prank. Or what if the complete opposite is true. How could an ordinary elderly man come out of this situation in a better way. No turning back now though.",
                "The casual life of a teenage boy changes for better or worse as a strange man enters his life."
                        + "The strange man claims the teenage boy has been seen committing several crimes by a lot of eye witnesses, but this person claims to know it was an imposter, an exact look-a-like, and offers a way out of what will undoubtedly be a very tricky situation. Unsure what to think of all this and of this strange man, the teenage boy oddly enthusiastically agrees to the proposal, if all this turns out to be false, this choice will seem foolish, but it's still worth checking out."
                        + "But what if this strange man can't be trusted. Or what if there's a change of mind. How could an ordinary teenage boy be this lucky, or unlucky, depending on the turnout. Only one way to find out.",
                "The peaceful life of a man take a sharp turn as a childhood friend enters his life."
                        + "The childhood friend claims the man is in danger, war is upon us all, enemy forces have already landed in a nearby coastal town, if this town doesn't evacuate right now it'll likely get caught in a horrible battle. Skeptical of this situation and of this childhood friend, the man hastily agrees to the proposal, if all this turns out to be false, this choice will seem foolish, but it's still worth checking out."
                        + "But what if this childhood friend is just a crazy person. Or what if everything told is completely true. How could an ordinary man be this lucky, or unlucky, depending on the turnout. No turning back now though.",
                "The unexciting life of a woman might turn out differently as a stranger enters her life."
                        + "The stranger claims the woman might wish to stay away from the capitol this evening as this person has something 'grand' planned. Before there's a chance to reply this strange person has moved on. Unconvinced of the situation, but trusting of this stranger, the woman cautiously agrees to the proposal, but something does feel very wrong about this whole situation, hopefully the right choice was made."
                        + "But what if this stranger is just a crazy person. Or what if the situation has changed or will change. How could an ordinary woman end up in a situation like this. Time will tell.",
                "The normal life of a woman is going in a different direction as a neighbor enters her life."
                        + "The neighbor claims the woman will need to find a new home as this current house will be demolished by the government in order to make room for a highway. A large sum of money will be paid if the house is left within a week. Unsure about everything, including this neighbor, the woman hesitantly agrees to the proposal, there's no way this is all a lie, right? If it is, a terrible choice might have been made."
                        + "But what if this neighbor is trying be misleading. Or what if the wrong person was picked for this. How could an ordinary woman find out what's happening without help. Time to find out.",
                "The quiet life of a teenage girl is going in a different direction as a stranger enters her life."
                        + "The stranger claims the teenage girl is never going to believe his eyes, dragons have returned and are currently gathering at the nearby mountain range. Nobody knows why they're back nor what they have planned, but it's safe to take a look from a distance. Unsure about everything, including this stranger, the teenage girl hastily agrees to the proposal, the situation is all too strange, it's best to get more information as soon as possible."
                        + "But what if this stranger can't be trusted. Or what if there's a change of mind. How could an ordinary teenage girl be helpful at all in this situation. Only one way to find out.",
                "The relaxed life of a teenage boy is going in a different direction as a friendly acquaintance enters his life."
                        + "The friendly acquaintance claims the teenage boy is chosen to be trained in the prestigious way of an ancient martial arts, which has been used to defend the nation for centuries. Two hours are given to decide whether to accept or decline this incredible offer. Believing both the situation and this friendly acquaintance, the teenage boy unusually eagerly agrees to the proposal, if all this turns out to be false, this choice will seem foolish, but it's still worth checking out."
                        + "But what if this friendly acquaintance is not speaking the truth. Or what if somebody is orchestrating all of this. How could an ordinary teenage boy be this important to the situation. Only one way to find out.",
                "The carefree life of a elderly woman will be permanently altered as a new friend enters her life."
                        + "The new friend claims the elderly woman will have to leave town within 2 hours or risk being stuck in a quarantine zone. There will be traffic jams and other hindrances, so it's best to leave right now without taking anything with you. Skeptical of this situation and of this new friend, the elderly woman somewhat gladly agrees to the proposal, there's something exciting about this whole situation, surely the right choice was made."
                        + "But what if this new friend speaks only lies. Or what if the situation is worse than it appears. How could an ordinary elderly woman be relied upon in something this big. No turning back now though.",
                "The smooth life of a elderly woman changes for better or worse as a strange girl enters her life."
                        + "The strange girl claims the elderly woman is one of the rare few people in possession of a guardian animal spirit. It's widely known these exist and rituals are held on a near weekly basis to connect with these guardian spirits, now its time to be the center of that ritual. Concerned of the situation and a little distrusful of this strange girl, the elderly woman hastily agrees to the proposal, the choice was made fast, perhaps too fast, but this situation requires quick thinking."
                        + "But what if this strange girl is a con artist. Or what if everything told is completely true. How could an ordinary elderly woman play a part in all this. Time will tell.",
                "The relaxed life of a boy has a chance to change, for better or worse, as a strange boy enters his life."
                        + "The strange boy claims the boy is in possession of a powerful artifact, an artifact which looks like any ordinary object, but an artifact which is of the utmost importance to this person, who will offer a reward for it. Sure of the truth in this situation, but somewhat distrustful of this strange boy, the boy somewhat keenly agrees to the proposal, but there's no time to waste, a decision had to be made quickly."
                        + "But what if this strange boy can't be trusted. Or what if this is all far bigger than what has been told. How could an ordinary boy be this important to the situation. Only one way to find out."
        };

        List<Game> bunchOfGames = new ArrayList<>();
        for (int i = 0; i < gameTitles.length; i++) {
            bunchOfGames.add(new Game(gameTitles[i], gameDescriptions[i], Game.ESRB_RATINGS.E));
        }

        games.saveAll(bunchOfGames);

        List<User> reviewers =
                Arrays.asList(
                        new User("jacobproffer", "password", new String[]{"ROLE_USER"}),
                        new User("mlnorman", "password", new String[]{"ROLE_USER"}),
                        new User("k_freemansmith", "password", new String[]{"ROLE_USER"}),
                        new User("seth_lk", "password", new String[]{"ROLE_USER"}),
                        new User("mrstreetgrid", "password", new String[]{"ROLE_USER"}),
                        new User("anthonymikhail", "password", new String[]{"ROLE_USER"}),
                        new User("boog690", "password", new String[]{"ROLE_USER"}),
                        new User("faelor", "password", new String[]{"ROLE_USER"}),
                        new User("christophernowack", "password", new String[]{"ROLE_USER"}),
                        new User("calebkleveter", "password", new String[]{"ROLE_USER"}),
                        new User("richdonellan", "password", new String[]{"ROLE_USER"}),
                        new User("albertqerimi", "password", new String[]{"ROLE_USER"}));

        User superUser = new User("superuser", "password1", new String[]{"ROLE_USER", "ROLE_ADMIN"});
        users.saveAll(reviewers);
        users.save(superUser);
    }
}
