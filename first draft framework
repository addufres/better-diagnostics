var user = prompt("Sorry to hear you are having car troubles! First off is the problem a NOISE, a VIBRATION, or NO START UP").toLowerCase();

switch(user) {
    
    case 'noise':
        var answerNoise = prompt("Is it from the front of the vehicle?").toLowerCase();
        var answerNoiseSide = prompt("Is it specific to one side?").toLowerCase();
       if(answerNoise && answerNoiseSide === 'yes') {
           console.log("Awesome! Single sided issue. That narrows it down a lot actually!");
        } else {
            console.log("Hmmm...Let's look a little closer.");
               }
       break;
       
    case 'vibration':
        var answerVibration = prompt("Is it a constant vibration").toLowerCase();
        var answerVibrationVolume = prompt("Does it get louder with speed?");
        if(answerVibration || answerVibrationVolume === 'yes') {
            console.log("Oh jeez, that's never good. Let's try and pinpoint where the vibration is coming from.");
        } else {
            console.log("Well that's a plus. At least it's not constant. ");
               }
        break;
    case "no start up":
        var answerNoStart = prompt("That's the worst! We will work this out...Let's start with the basics. When you turn the key to START does the vehicle attempt to crank over? YES or NO").toLowerCase();
        if(answerNoStart === 'yes') {
            console.log("That is good news...kinda. It means I know where to look first!");
            } else {
                console.log("Go grab your Voltmeter and see what your battery is putting out between the POSITIVE terminal and a good ground. It should read at least 10.8V of DC.");
                }
        break;
    default:
        console.log("Uh-oh! I may be pretty smart with cars but that answer didn't make sense to me. Please try again.");
        break;
    }
