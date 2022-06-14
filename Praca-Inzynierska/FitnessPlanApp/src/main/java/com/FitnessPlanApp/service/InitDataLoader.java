package com.FitnessPlanApp.service;

import javax.annotation.PostConstruct;

import com.FitnessPlanApp.model.Day;
import com.FitnessPlanApp.model.Plan;
import com.FitnessPlanApp.model.User;
import com.FitnessPlanApp.model.Workout;
import com.FitnessPlanApp.repository.DayRepository;
import com.FitnessPlanApp.repository.PlanRepository;
import com.FitnessPlanApp.repository.UserRepository;
import com.FitnessPlanApp.repository.WorkoutRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InitDataLoader {

    /*@Autowired
    UserRepository userRepository;

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    PlanRepository planRepository;

    @Autowired
    DayRepository dayRepository;

    @PostConstruct
    public void init() {
        User admin = new User(null, "Admin", "Admin", "admin@sport.pl", DigestUtils
                .md5Hex("admin").toUpperCase(), 1, null);
        User user1 = new User(null, "Bogdan", "Kleszcz", "person1@sport.pl", DigestUtils
                .md5Hex("person1").toUpperCase(), 2, null);
        User user2 = new User(null, "Bogdan", "Kleszcz", "person2@sport.pl", DigestUtils
                .md5Hex("person2").toUpperCase(), 2, null);

        userRepository.save(admin);
        userRepository.save(user1);
        userRepository.save(user2);

        Workout workout1 = new Workout(null,
                "Barki",
                "Wyciskanie sztangi sprzed głowy",
                "W pozycji stojącej: stajemy w rozkroku nieco szerszym, niż barki (inna forma ćwiczenia zakłada wysunięcie jednej nogi nieco w przód, dla lepszej równowagi) - klatka piersiowa wypchnięta ku przodowi, zachowana naturalna krzywizna kręgosłupa-pracują podczas ćwiczenia tylko ramiona i barki (staramy się unikać dodatkowych ruchów tułowia i nóg), uchwyt nieco szerszy, niż rozstaw barków.\n"
                        + "Im węższy uchwyt, tym bardziej pracę w ćwiczeniu przejmują mięśnie trójgłowe ramion.\n"
                        + "\n"
                        + "W pozycji siedzącej: staramy się zwracać dużą uwagę na prawidłową pozycję-przez cały czas należy mieć wypchniętą ku przodowi klatkę piersiową i zachowywać naturalna krzywiznę kręgosłupa. Taka pozycja zabezpiecza (oczywiście nie w pełni) przed urazami dolnego odcinka kręgosłupa. (można zastosować oparcie o ławkę-zmniejsza naciski na dyski międzykręgowe).\n"
                        + "\n"
                        + "UWAGI: Nie poleca się tego ćwiczenia dla początkujących, ponieważ jest ono bardzo kontuzjogenne i najmniejsze błędy w jego wykonaniu mogą spowodować niebezpieczne kontuzje.",
                "https://youtube.pl/embed/BclIGnkgZVc",
                null);

        Workout workout2 = new Workout(null,
                "Plecy",
                "Podciąganie na drążku",
                "Nie ma drugiego takiego ćwiczenia pod względem wszechstronności rozwoju mięsni grzbietu. Ćwiczenie to można wykonywać do karku i do brody, lecz wersja do karku jest mniej naturalna dla stawów. Chwytamy drążek nachwytem na szerokość taką, by po podciągnięciu ramiona z przedramionami tworzyły kąt prosty(w przybliżeniu).Nogi ugięte w kolanach(dla lepszej stabilności można je spleść).Łokcie pracują w płaszczyźnie pleców-w jednej linii. Wdech robimy przed rozpoczęciem ruchu podciągania-wydech dopiero, gdy jesteśmy już u góry. Ruch podciągania kończymy w momencie, gdy nasza broda(lub kark) jest na wysokości drążka lub nieco ponad nim. Opuszczamy się wolno i pod pełną kontrolą. Jeśli jesteśmy bardziej zaawansowani i możemy wykonać wiele powtórzeń w tym ćwiczeniu, to można zastosować dodatkowe obciążenie.",
                "https://youtube.pl/embed/X5eptRVZUno",
                null);

        Workout workout3 = new Workout(null,
                "Ramiona",
                "Uginanie ramion ze sztangą stojąc podchwytem",
                "Tułów podczas ćwiczenia utrzymujemy w pozycji wyprostowanej(bez bujania nim). Zakres ruchu: od pełnego rozgięcia bicepsów(nie ramion)do pełnego ich skurczu. Pełne rozciągnięcie bicepsów, to nie to samo, co pełny wyprost ramion. Należy unikać(nie tylko w tym ćwiczeniu) tzw. ”przeprostów” ramion, czyli nadmiernego ich wyprostowywania(do pełnego zakresu ruchu w stawie łokciowym).Łokcie przez cały czas przylegają do tułowia-nie powinny uciekać na boki, ani w przód, gdyż powoduje to zaangażowanie innych mięśni do pracy. Powietrza nabieramy w pozycji wyjściowej, wypuszczamy je dopiero po przejściu ciężaru przez najtrudniejszy punkt ruchu. W pozycji końcowej można zatrzymać na chwilę ciężar dla lepszego ukrwienia mięśnia, ale pod warunkiem utrzymania bicepsów w pełnym napięciu. Należy pamiętać, że ruch opuszczania musi być w pełni kontrolowany i wolniejszy od unoszenia. Do ćwiczenia można używać zarówno sztangi prostej, jak i łamanej-gryf łamany zmniejsza napięcia powstające w nadgarstkach.",
                "https://youtube.pl/embed/415ZedAmmGg",
                null);

        Workout workout4 = new Workout(null,
                "Brzuch",
                "Skłony w leżeniu płasko",
                "Kładziemy się na materacu lub ławce. Nogi ugięte, ręce nad głową i unosimy tułów w górę. Pierwsza do góry unosi się głowa, potem barki, a na końcu reszta tułowia. Dla lepszego zaangażowania mięśni skośnych brzucha, w końcowej fazie unoszenia tułowia można wykonywać nim skręty(gif 1a.). Jest to jednak wersja trudniejsza i bardziej narażająca na ewentualne kontuzje(mocniej obciąża dolne partie grzbietu).Nabieramy powietrza przed rozpoczęciem ruchu, a wypuszczamy je w trakcie unoszenia tułowia.",
                "https://youtube.pl/embed//VVcm4LdmIwM",
                null);

        Workout workout5 = new Workout(null,
                "Łydki",
                "Wspięcia na palce",
                "Ćwiczenie to można wykonywać zarówno przy pomocy sztangi(gif 1), suwnicy Smitha(gif 1a) lub specjalnej maszyny(gif 1c). Można wykonywać je również bez obciążenia, a także jednonóż(gif 1b).Sztangę można również zastąpić sztangielką trzymaną w dłoni(po tej samej stronie, co ćwiczona noga: lewa noga- lewa ręka, prawa noga- prawa ręka). Istotnym elementem w tym ćwiczeniu jest użycie grubej podkładki pod palce stóp, która pozwala zwiększyć znacznie zakres ruchu, a co za tym idzie-poprawić efektywność ćwiczenia. Pozycja wyjściowa, to wyprostowany tułów i plecy, nogi wyprostowane w kolanach, rozkrok 25-30 cm, palce stóp(wraz ze stawami łączącymi je ze śródstopiem) na podkładce-mięsnie łydek rozciągnięte maksymalnie. Z takiej pozycji rozpoczynamy wspięcia. Ruch powinien być wolny i dokładny, ze stałym „czuciem” pracy mięśni. Należy unikać odbijania się pięt od podłogi.",
                "https://youtube.pl/embed/mbyTbDJBsR8",
                null);

        workoutRepository.save(workout1);
        workoutRepository.save(workout2);
        workoutRepository.save(workout3);
        workoutRepository.save(workout4);
        workoutRepository.save(workout5);

        Plan plan1 = new Plan(null,
                "Trening na poprawę siły",
                "Każda grupa mięśniowa trenowana raz w tygodniu. Trening na dużych ciężarach z małą ilością powtórzeń w seriach(8-1).Przerwy pomiędzy seriami wydłużamy do 3-5 minut.",
                admin,
                null,
                false);
        addDaysToPlan(planRepository.save(plan1));

        Plan plan2 = new Plan(null,
                "Trening na masę",
                "Oparty powinien być na ćwiczeniach podstawowych(przysiady, wyciskania, uginania i wyprosty ramion, itp.)z wolnymi ciężarami(sztanga, sztangielki)",
                admin,
                null,
                false);
        addDaysToPlan(planRepository.save(plan2));
    }

    public void addDaysToPlan(Plan plan) {
        Day monday = new Day(null, "Poniedziałek", plan, null);
        Day tuesday = new Day(null, "Wtorek", plan, null);
        Day wednesday = new Day(null, "Sroda", plan, null);
        Day thursday = new Day(null, "Czwartek", plan, null);
        Day friday = new Day(null, "Piątek", plan, null);
        Day saturday = new Day(null, "Sobota", plan, null);
        Day sunday = new Day(null, "Niedziela", plan, null);

        dayRepository.save(monday);
        dayRepository.save(tuesday);
        dayRepository.save(wednesday);
        dayRepository.save(thursday);
        dayRepository.save(friday);
        dayRepository.save(saturday);
        dayRepository.save(sunday);
    }*/
}