# CRAZYTAXI:
Back when I was younger there was this really popular Flash game that everyone played at school called Crazy Taxi.
You can actually still play it today [here](http://www.softschools.com/games/action_games/crazy_taxi/) and it's a pretty entertaining
game (if you have literally nothing else to play)

The concept of the Crazy Taxi game is that you're driving a taxi (in the desert for some reason) and you're trying to get to the
goal before time runs out. You can move your car side to side or jump over the cars in front of you and you can accelerate or decelerate
your car freely

I made the first iteration of this game when I was in Grade 11 sort of based on Crazy Taxi. I changed the concept to a simpler model where
it was just a top-down overview of a driver on the highway trying to weave in and out of traffic (with less annoying sound effects!). 
The game mechanics are totally different than the original Crazy Taxi game and is much simpler overall.

The structure of the main game template is taken from my highschool Computer Science teacher Mr. Lamont. You can find the template
at his website [here](http://www.mrlamont.com/basic-game-class.html). I made all the sprites out of Java Graphics objects for simplicity

# RUNNING THE GAME:
To run the game on your desktop simply run the `CrazyTaxi.jar` file found in the repository.

I intend to one day make this game runnable on my website however I don't have a lot of experience in Java applets and Java Web Start
so the ETA on that is unknown

# CONTROLS:
* <b>Up Arrow</b>: moves car up
* <b>Down Arrow</b>: moves car down
* <b>Left Arrow</b>: moves car left
* <b>Right Arrow</b>: moves car right

# POSSIBLE FUTURE FEATURES:
The original game I had made in Grade 11 did not feature full-fleged control of the car. Instead you could only move side to side and
the car would teleport into the adjacent lane. I found this to make the game too easy as it just became a matter of reaction time as
opposed to skillful dodging of the cars. One idea I had to increase the difficulty of the game was to add a "petrol" mechanic where you
would have to pick up petrol on the road to fill your gas meter and if your gas meter was at 0 you would be unable to move. I haven't
thought exactly how I'm going to layout the petrol spawns so I haven't implemented this feature yet. I want the game to be more challenging
as it progresses however not impossible or just unfair at some point

I've considered adding a secondary task of picking up coins that could possibly increase your score. I found this idea kind of dumb because
it's basically the petrol mechanic except optional and additionally I didn't like the idea of your score being tied to RNG so I've
willfully decided to leave out this feature

The original game had a feature where it would store a local highscore and would update the highscore if it was ever beaten. I like
this idea and may try to implement it in the future. I would also like this feature to work if someone were to play it in a web browser
as well but again I'm not very knowledgeable in Java applets

# KNOWN BUGS/ISSUES:
* moving left/right or up/down very fast sometimes causes the car to freeze
  * this is an issue with the KeyRelease implementation but I don't have a fix for it currently
* magic numbers in source
